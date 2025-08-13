package com.habib.group.deliveryshebin.rider.features.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.habib.group.deliveryshebin.rider.R
import com.habib.group.deliveryshebin.rider.features.auth.register.domain.Vehicle
import com.habib.group.deliveryshebin.rider.utils.commonUI.CustomButton
import com.habib.group.deliveryshebin.rider.utils.commonUI.CustomRadioButton
import com.habib.group.deliveryshebin.rider.utils.commonUI.EditText
import com.habib.group.deliveryshebin.rider.utils.commonUI.HorizontalSpace
import com.habib.group.deliveryshebin.rider.utils.commonUI.VerticalSpace
import com.habib.group.deliveryshebin.rider.utils.imagePicker.ImagePickerBlock
import com.habib.group.deliveryshebin.rider.utils.theme.Black
import com.habib.group.deliveryshebin.rider.utils.theme.Orange
import com.habib.group.deliveryshebin.rider.utils.theme.Primary
import com.habib.group.deliveryshebin.rider.utils.theme.White


@Composable
fun RegisterScreen() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
    ) {
        val (toolbar, topContent, submitBtn) = createRefs()

        Box(
            modifier = Modifier
                .constrainAs(toolbar) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
                .fillMaxWidth()
                .height(80.dp)
                .background(Primary)
        ) {
            Text(
                color = White,
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(R.string.complete_registeration)
            )
        }

        Column(
            modifier = Modifier
                .constrainAs(topContent) {
                    verticalBias = 0f
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    top.linkTo(toolbar.bottom)
                    bottom.linkTo(submitBtn.top)
                    height = Dimension.fillToConstraints
                }
                .verticalScroll(rememberScrollState())
                .padding(vertical = 16.dp, horizontal = 24.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Top
        ) {
            UserDataSection()

            VerticalSpace(16.dp)

            CardIDSection()

            VerticalSpace(16.dp)

            VehicleSection()
        }

        CustomButton(
            modifier = Modifier
                .constrainAs(submitBtn) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
                .padding(horizontal = 24.dp, vertical = 16.dp),
            textSize = 18.sp,
            textColor = White,
            backgroundColor = Orange,
            text = stringResource(R.string.submit),
        ) {

        }
    }
}

@Composable
fun UserDataSection() {
    Text(
        color = Black,
        fontSize = 20.sp,
        textAlign = TextAlign.Right,
        text = stringResource(R.string.rider_details)
    )

    VerticalSpace(8.dp)

    EditText(
        inputType = KeyboardType.Text,
        modifier = Modifier.fillMaxWidth(),
        hint = stringResource(R.string.user_name)
    ) { text -> }

    VerticalSpace(8.dp)

    EditText(
        inputType = KeyboardType.Phone,
        modifier = Modifier.fillMaxWidth(),
        hint = stringResource(R.string.phone)
    ) { text -> }

    VerticalSpace(8.dp)

    EditText(
        inputType = KeyboardType.Email,
        modifier = Modifier.fillMaxWidth(),
        hint = stringResource(R.string.email)
    ) { text -> }
}

@Composable
fun CardIDSection() {
    Text(
        color = Black,
        fontSize = 20.sp,
        textAlign = TextAlign.Right,
        text = stringResource(R.string.personal_card)
    )

    VerticalSpace(8.dp)

    Row {
        ImagePickerBlock(
            modifier = Modifier
                .weight(1f)
                .height(150.dp),
            text = stringResource(R.string.back_id_image)
        ) { uri ->
        }

        HorizontalSpace(8.dp)

        ImagePickerBlock(
            modifier = Modifier
                .weight(1f)
                .height(150.dp),
            text = stringResource(R.string.front_id_image)
        ) { uri ->
        }
    }
}

@Composable
fun VehicleSection() {
    Text(
        color = Black,
        fontSize = 20.sp,
        textAlign = TextAlign.Right,
        text = stringResource(R.string.vehicle_details)
    )

    VerticalSpace(8.dp)

    CustomRadioButton(
        options = Vehicle.entries,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp),
        orientation = Orientation.Horizontal
    ) { selectedVehicle ->
    }

    VerticalSpace(8.dp)

    ImagePickerBlock(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(150.dp),
        text = stringResource(R.string.pic_vehicle_image)
    ) { uri ->
    }
}