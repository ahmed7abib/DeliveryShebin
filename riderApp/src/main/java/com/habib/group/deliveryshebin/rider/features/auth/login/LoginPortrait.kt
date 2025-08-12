package com.habib.group.deliveryshebin.rider.features.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.habib.group.deliveryshebin.rider.R
import com.habib.group.deliveryshebin.rider.features.splash.Header
import com.habib.group.deliveryshebin.rider.utils.theme.Black
import com.habib.group.deliveryshebin.rider.utils.theme.Orange
import com.habib.group.deliveryshebin.rider.utils.theme.Primary
import com.habib.group.deliveryshebin.rider.utils.theme.White


@Composable
fun LoginPortrait(
    onSignInClick: () -> Unit,
    onIgnoreClicked: () -> Unit,
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(Primary, Primary)))
            .padding(
                horizontal = 16.dp,
                vertical = 24.dp
            )
    ) {

        val (header, logo, buttons, footer) = createRefs()

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

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.constrainAs(logo) {
                top.linkTo(header.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(buttons.top)
            }
        ) {
            PortraitLogoSection()
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.constrainAs(buttons) {
                top.linkTo(logo.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(footer.top)
            }
        ) {
            ButtonsSection(onSignInClick, onIgnoreClicked)
        }

        Column(
            modifier = Modifier.constrainAs(footer) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            PortraitFooterSection()
        }
    }
}

@Composable
fun ButtonsSection(onSignInClick: () -> Unit, onIgnoreClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(White)
            .padding(horizontal = 12.dp)
            .clickable { onSignInClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            contentDescription = "Google Icon",
            modifier = Modifier.size(32.dp),
            painter = painterResource(R.drawable.ic_google)
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

    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Orange)
            .clickable { onIgnoreClicked() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            color = White,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            text = stringResource(R.string.login_hint_3)
        )
    }
}

@Composable
private fun PortraitLogoSection() {
    Image(
        contentDescription = "Logo",
        painter = painterResource(R.drawable.ic_logo_no_txt),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        color = White,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Normal,
        text = stringResource(R.string.login_hint_2)
    )
}

@Composable
private fun PortraitFooterSection() {
    Text(
        color = White,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Normal,
        text = stringResource(R.string.privacy_policy_hint),
        fontFamily = FontFamily(Font(R.font.arabic_font_lite))
    )
}
