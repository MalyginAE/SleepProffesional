package com.hse.sleeppro.ui.component.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hse.sleeppro.ui.theme.PanelGray

//data class EnterName(
//    val text:String
//)

@Composable
fun EnterName(
    modifier: Modifier = Modifier,
    text: String,
    onValueChanged: (String) -> Unit,
    cardTitle: String,
    labelText: String,
    keyboardActions: KeyboardActions
    //trailingIcon: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxHeight(0.33f)
            .padding(bottom = 10.dp, top = 10.dp)
            .background(PanelGray)
    ) {
        Column(
            modifier = Modifier
                .heightIn(min = 30.dp, max = 410.dp)
                .fillMaxWidth()
        ) {

//            val keyboardController = LocalSoftwareKeyboardController.current
//            val isShowIconCheck = remember {
//                mutableStateOf(false)
//            }
            CardTitle(title = cardTitle)
            OutlinedTextField(
                modifier = Modifier
                    .heightIn(min = 10.dp)
                    .padding(start = 15.dp, end = 15.dp)
                    .fillMaxWidth(),
                value = text,
                onValueChange = onValueChanged,
                label = { Text(text = labelText) },
//                trailingIcon = {
//                    if (isShowIconCheck.value) {
//                        IconButton(onClick = { /*Nothing*/ }) {
//                            Icon(imageVector = Icons.Filled.Check, contentDescription = "")
//                        }
//                    }
//                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = keyboardActions
            )
        }
    }
}

