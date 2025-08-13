package com.habib.group.deliveryshebin.rider.features.auth.register

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.habib.group.deliveryshebin.rider.R
import com.habib.group.deliveryshebin.rider.utils.commonUI.CustomButton
import com.habib.group.deliveryshebin.rider.utils.commonUI.EditText
import com.habib.group.deliveryshebin.rider.utils.commonUI.HorizontalSpace
import com.habib.group.deliveryshebin.rider.utils.commonUI.VerticalSpace
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
                }
                .padding(24.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
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
                .padding(24.dp),
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
    Text(R.string.rider_details)

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
    Text(R.string.personal_card)

    VerticalSpace(8.dp)

    Row {
        PickImageBlock(
            modifier = Modifier
                .weight(1f)
                .height(150.dp)
        ) {

        }

        HorizontalSpace(8.dp)

        PickImageBlock(
            modifier = Modifier
                .weight(1f)
                .height(150.dp)
        ) {

        }
    }
}

@Composable
fun VehicleSection() {
    Text(R.string.vehicle_details)
    VerticalSpace(8.dp)
}

@Composable
fun PickImageBlock(
    modifier: Modifier = Modifier,
    onImageSelected: (Uri) -> Unit
) {
    var selectedImage by remember { mutableStateOf<Uri?>(null) }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Gray.copy(alpha = 0.2f))
    ) {
        Image(
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(model = selectedImage)
        )

        Icon(
            tint = Black,
            contentDescription = null,
            painter = painterResource(R.drawable.ic_camera),
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.Center)
                .clickable {
                    // هنا هتفتح الكاميرا أو المعرض
                    // و أول ما ترجع Uri تخزنه
                    // مثال (تجريبي):
                    // val uri = ...
                    // selectedImage = uri
                    // imageSelected(uri)
                }
                .padding(8.dp)
        )
    }
}

@Composable
fun Text(reg: Int) {
    Text(
        color = Black,
        fontSize = 20.sp,
        textAlign = TextAlign.Right,
        text = stringResource(reg)
    )
}
