package com.hse.sleeppro.ui.component.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.hse.sleeppro.ui.theme.PanelGray

//data class EnterName(
//    val text:String
//)

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EnterText(
    modifier: Modifier = Modifier
        .fillMaxHeight(0.33f),
    text: String,
    onValueChanged: (String) -> Unit,
    cardTitle: String,
    labelText: String,
   keyboardActions: KeyboardActions
    //trailingIcon: () -> Unit
) {

    Box(
        modifier = modifier
            .padding(bottom = 10.dp, top = 10.dp)
            .background(PanelGray)
    ) {
        Column(
            modifier = Modifier
                .heightIn(min = 30.dp, max = 410.dp)
                .fillMaxWidth()
        ) {
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

