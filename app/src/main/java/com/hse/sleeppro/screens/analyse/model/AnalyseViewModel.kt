package com.hse.sleeppro.screens.analyse.model

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.net.toFile
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hse.sleeppro.base.EventHandler
import com.hse.sleeppro.screens.analyse.model.dto.SaveUserResponseDto
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitFormWithBinaryData
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.contentLength
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.core.isEmpty
import io.ktor.utils.io.core.readBytes
import kotlinx.coroutines.launch
import java.io.File
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class AnalyseViewModel @Inject constructor() : ViewModel(), EventHandler<AnalyzeEvent> {
    private val BASE_URL = "http://192.168.181.76:8080" //todo вынести в конфиг
    private val GET_IMAGE = "$BASE_URL/image/"// todo тоже тудаже
    private val POST_CUSTOMER = "$BASE_URL/customer"// todo тоже тудаже
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

                    HttpClient(Android){
                        install(JsonFeature) {
                            serializer = GsonSerializer()

                        }
                        expectSuccess=true
                    }.use {

                        val file = event.uri?.toFile()
                        var customerId: Long? = null
                        try {
                            val response = it.submitFormWithBinaryData<SaveUserResponseDto>(
                                url = POST_CUSTOMER,
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
                            customerId = response.id
                            Log.d("RESPONSE", "POST TO $POST_CUSTOMER returned $response")
                        }
                        catch (e: Exception) {
                            //тут можно пульнуть экран с кнопкой переповторить
                            Log.e("ERROR","error ",e)
                        }
                            // вынести в suspend функцию
                        var response = it.get<HttpResponse>(GET_IMAGE+ customerId+"?state=analyze")
                        val channel: ByteReadChannel = response.content
                        while (!channel.isClosedForRead) {
                            val packet = channel.readRemaining(DEFAULT_BUFFER_SIZE.toLong(), DEFAULT_BUFFER_SIZE)
                            while (!packet.isEmpty) {
                                val bytes = packet.readBytes()
                                tempFile.appendBytes(bytes)
                                Log.i(
                                    "File received",
                                    "Received ${tempFile.length()} bytes from ${response.contentLength()}"
                                )
                            }
                        }
                        Log.i("File Saved", "A file saved to ${tempFile.path}")


                    }

                    _analyseViewState.postValue(AnalyseViewState.Display(event.fvs.enterNameModel.text, tempFile))

                }
            }
        }
    }
}