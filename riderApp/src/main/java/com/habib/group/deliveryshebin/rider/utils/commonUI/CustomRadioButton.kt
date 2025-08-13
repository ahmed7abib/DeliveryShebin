package com.habib.group.deliveryshebin.rider.utils.commonUI

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.habib.group.deliveryshebin.rider.features.auth.register.domain.Vehicle
import com.habib.group.deliveryshebin.rider.utils.theme.Primary
import com.habib.group.deliveryshebin.rider.utils.theme.Secondary


@Composable
fun CustomRadioButton(
    options: List<Vehicle>,
    orientation: Orientation,
    modifier: Modifier = Modifier,
    onSelectionChanged: (Vehicle) -> Unit
) {
    var selectedOption by remember { mutableStateOf(options.last()) }

    when (orientation) {
        Orientation.Vertical -> {
            Column(modifier = modifier) {
                options.forEach { option ->
                    MyRadioButton(
                        option = option,
                        isSelected = selectedOption == option,
                        isLastItem = options.last() == option,
                        isFirsItem = options.first() == option,
                    ) { selectedItem ->
                        selectedOption = selectedItem
                        onSelectionChanged(selectedItem)
                    }
                }
            }
        }

        Orientation.Horizontal -> {
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                options.forEach { option ->
                    MyRadioButton(
                        option = option,
                        isSelected = selectedOption == option,
                        isLastItem = options.last() == option,
                        isFirsItem = options.first() == option,
                        modifier = Modifier.weight(1f)
                    ) { selectedItem ->
                        selectedOption = selectedItem
                        onSelectionChanged(selectedItem)
                    }
                }
            }
        }
    }
}

@Composable
private fun MyRadioButton(
    option: Vehicle,
    isSelected: Boolean,
    isFirsItem: Boolean,
    isLastItem: Boolean,
    modifier: Modifier = Modifier,
    selectionChanged: (Vehicle) -> Unit
) {

    val arrangement = when {
        isLastItem -> Arrangement.End
        isFirsItem -> Arrangement.Start
        else -> Arrangement.Center
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { selectionChanged(option) },
        horizontalArrangement = arrangement,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            colors = RadioButtonDefaults.colors(
                selectedColor = Primary,
                unselectedColor = Secondary
            ),
            onClick = { selectionChanged(option) }
        )

        Text(text = stringResource(option.reg), fontSize = 14.sp)
    }
}