package com.habib.group.deliveryshebin.rider.features.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.habib.group.deliveryshebin.rider.R
import com.habib.group.deliveryshebin.rider.utils.commonUI.CustomEditText
import com.habib.group.deliveryshebin.rider.utils.theme.Black
import com.habib.group.deliveryshebin.rider.utils.theme.Orange2
import com.habib.group.deliveryshebin.rider.utils.theme.White

@Composable
fun RegisterScreen() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .padding(24.dp)
    ) {
        val (topContent, submitBtn) = createRefs()

        Column(
            modifier = Modifier.constrainAs(topContent) {
                verticalBias = 0f
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                bottom.linkTo(submitBtn.top)
            },
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            Text(R.string.rider_details)

            UserDataSection()

            Spacer(modifier = Modifier.height(16.dp))

            Text(R.string.personal_card)

            CardIDSection()

            Spacer(modifier = Modifier.height(16.dp))

            Text(R.string.vehicle_details)

            VehicleSection()
        }

        Box(
            modifier = Modifier
                .constrainAs(submitBtn) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Orange2)
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Text(
                color = Black,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                text = stringResource(R.string.submit)
            )
        }
    }
}

@Composable
fun UserDataSection() {
    CustomEditText(
        initValue = "",
        isSingleLine = true,
        label = stringResource(R.string.user_name),
        placeholder = stringResource(R.string.user_name),
    ) { text -> }

    CustomEditText(
        initValue = "",
        isSingleLine = true,
        label = stringResource(R.string.phone),
        placeholder = stringResource(R.string.phone),
    ) { text -> }

    CustomEditText(
        initValue = "",
        isSingleLine = true,
        label = stringResource(R.string.email),
        placeholder = stringResource(R.string.email),
    ) { text -> }
}

@Composable
fun CardIDSection() {
}

@Composable
fun VehicleSection() {
}

@Composable
fun Text(reg: Int) {
    Text(
        color = Black,
        fontSize = 18.sp,
        textAlign = TextAlign.Right,
        text = stringResource(reg)
    )
}
