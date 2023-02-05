package com.hse.sleeppro.screens.analyse.model

import android.graphics.Bitmap
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.net.toFile
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hse.sleeppro.base.EventHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import id.zelory.compressor.Compressor
import id.zelory.compressor.constraint.quality
import id.zelory.compressor.constraint.resolution
import id.zelory.compressor.constraint.size
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.append
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitFormWithBinaryData
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.content.PartData
import io.ktor.http.contentLength
import io.ktor.http.contentType
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.core.isEmpty
import io.ktor.utils.io.core.readBytes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import javax.inject.Inject

@HiltViewModel
class AnalyseViewModel @Inject constructor() : ViewModel(), EventHandler<AnalyzeEvent> {
    private val BASE_URL = "http://192.168.0.9:8080" //todo вынести в конфиг
    private val POST_IMAGE = "$BASE_URL/image"// todo тоже тудаже
    private val _analyseViewState: MutableLiveData<AnalyseViewState> =
        MutableLiveData(AnalyseViewState.Loading)
    val analyseViewState: LiveData<AnalyseViewState> = _analyseViewState


    override fun obtainEvent(event: AnalyzeEvent) {
        when (val currentState = _analyseViewState.value) {
            is AnalyseViewState.Loading -> reduce(currentState, event)
            is AnalyseViewState.Display -> reduce(currentState, event)

        }

    }

    private fun reduce(currentState: AnalyseViewState.Display, event: AnalyzeEvent) {
        when (event) {

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun reduce(currentState: AnalyseViewState.Loading, event: AnalyzeEvent) {
        when (event) {
            is AnalyzeEvent.PostRequest -> {
                viewModelScope.launch {


                    val tempFile = File.createTempFile("files", "index")
                    HttpClient().use {
                        val file = event.uri?.toFile()

//                        val compressFile = Compressor.compress(event.context, file!!){
//                            resolution(1280, 720)
//                            quality(80)
//                            (Bitmap.CompressFormat.PNG)
//                            size(262144)}
                        val data = it.submitFormWithBinaryData<String>(
                            url = POST_IMAGE,
                            formData = formData {
                                if (file != null) {
                                    Log.d("TAG", "file size $file")
                                    append("file", file.readBytes(), Headers.build {
                                        append(HttpHeaders.ContentType, "image/png")
                                        append(HttpHeaders.ContentDisposition, "filename=\"${file.name}\"")
                                    })
                                }
                            }
                        )

                        var response = it.get<HttpResponse>(POST_IMAGE)
                        val channel: ByteReadChannel = response.content
                        while (!channel.isClosedForRead) {
                            val packet = channel.readRemaining(DEFAULT_BUFFER_SIZE.toLong(),DEFAULT_BUFFER_SIZE)
                            while (!packet.isEmpty) {
                                val bytes = packet.readBytes()
                                tempFile.appendBytes(bytes)
                                Log.i("File received","Received ${tempFile.length()} bytes from ${response.contentLength()}")
                            }
                        }
                        println("A file saved to ${tempFile.path}")


                        Log.d("RESPONSE", "POST TO $POST_IMAGE returned $data")
                    }

                    _analyseViewState.postValue(AnalyseViewState.Display(event.firstName,tempFile))

                }
            }
        }
    }
}