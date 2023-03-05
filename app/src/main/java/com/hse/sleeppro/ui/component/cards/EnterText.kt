package com.hse.sleeppro.ui.component.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.hse.sleeppro.ui.theme.PanelGray

@Composable
fun EnterText(
    modifier: Modifier = Modifier
        .fillMaxHeight(0.33f),
    text: String,
    onValueChanged: (String) -> Unit,
    cardTitle: String,
    labelText: String,
    keyboardActions: KeyboardActions
) {

    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .heightIn(min = 30.dp, max = 410.dp)
                .fillMaxWidth()
        ) {
            CardTitle(title = cardTitle)
                OutlinedTextField(
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .heightIn(min = 42.dp)
                        .padding(top = 6.dp)
                        .fillMaxWidth(),
                    value = text,
                    onValueChange = onValueChanged,
                    label = { Text(text = labelText) },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = keyboardActions
                )
            }
        }

}

