package com.habib.group.deliveryshebin.rider.features.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.habib.group.deliveryshebin.rider.R
import com.habib.group.deliveryshebin.rider.utils.theme.Black
import com.habib.group.deliveryshebin.rider.utils.theme.Orange
import com.habib.group.deliveryshebin.rider.utils.theme.Primary
import com.habib.group.deliveryshebin.rider.utils.theme.White


@Composable
fun LoginScreen() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(Primary, Primary)))
            .padding(horizontal = 16.dp, vertical = 48.dp)
    ) {
        val (header, body, footer) = createRefs()

        Column(
            modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()
        }

        Column(
            modifier = Modifier.constrainAs(body) {
                top.linkTo(header.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(footer.top)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Body()
        }

        Column(
            modifier = Modifier.constrainAs(footer) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Footer()
        }
    }
}

@Composable
private fun Header() {
    Text(
        text = stringResource(R.string.delivery_shebin),
        color = White,
        fontSize = 32.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = stringResource(R.string.login_hint_1),
        color = White,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Normal
    )
}


@Composable
private fun Body() {
    Image(
        contentDescription = "Logo",
        painter = painterResource(R.drawable.ic_logo_no_txt),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )

    Text(
        text = stringResource(R.string.login_hint_2),
        color = White,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Normal
    )
}

@Composable
private fun Footer() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(White)
            .padding(12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Image(
            contentDescription = "Google Icon",
            painter = painterResource(R.drawable.ic_google),
            modifier = Modifier.size(32.dp)
        )

        Spacer(Modifier.width(8.dp))

        Text(
            text = stringResource(R.string.google_sign_in),
            color = Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
    }

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = stringResource(R.string.login_hint_3),
        color = White,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Orange)
            .padding(12.dp),
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = stringResource(R.string.privacy_policy_hint),
        color = White,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Normal,
        fontFamily = FontFamily(Font(R.font.arabic_font_lite))
    )
}