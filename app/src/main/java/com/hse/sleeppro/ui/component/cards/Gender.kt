package com.hse.sleeppro.ui.component.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hse.sleeppro.ui.theme.Base100
import com.hse.sleeppro.ui.theme.Green500

@Composable
fun DropDownCard(
    modifier: Modifier = Modifier,
    currentModelName: String,
    expanded: Boolean,
    dataList: List<String>,
    onClick: () -> Unit,
    onItemChose: (String) -> Unit,
    cardTitle: String,
    onDismissRequest: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column() {
            CardTitle(title = cardTitle)
            var color = Base100
            val icon = if (expanded){
                color = Green500
                Icons.Filled.KeyboardArrowUp
            }
            else
                Icons.Filled.KeyboardArrowDown
            Column(Modifier.padding()) {
                OutlinedTextField(
                    value = currentModelName,
                    onValueChange = { },
                    modifier = Modifier
                        .heightIn(min = 42.dp)
                        .padding(top = 6.dp)
                        .fillMaxWidth()
                        .border(2.dp, color, RoundedCornerShape(15.dp)),
                    readOnly = true,

                    trailingIcon = {
                        Icon(icon,"contentDescription", modifier = Modifier.clickable { onClick.invoke() })

                    }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = onDismissRequest,
                    ) {
                    dataList.forEach { label ->
                        DropdownMenuItem(onClick = {
                            onItemChose.invoke(label)
                        }) {
                            Text(text = label, modifier = Modifier.fillMaxWidth())
                        }
                    }
                }
            }

        }
    }
}

