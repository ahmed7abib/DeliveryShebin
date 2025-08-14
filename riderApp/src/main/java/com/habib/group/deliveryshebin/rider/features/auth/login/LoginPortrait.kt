package com.habib.group.deliveryshebin.rider.features.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.habib.group.deliveryshebin.rider.utils.commonUI.CustomButton
import com.habib.group.deliveryshebin.rider.utils.commonUI.VerticalSpace
import com.habib.group.deliveryshebin.rider.utils.theme.Black
import com.habib.group.deliveryshebin.rider.utils.theme.Orange
import com.habib.group.deliveryshebin.rider.utils.theme.Primary
import com.habib.group.deliveryshebin.rider.utils.theme.White


@Composable
fun LoginPortrait(
    onSignInClick: () -> Unit,
    onIgnoreClicked: () -> Unit
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(Primary, Primary)))
            .padding(
                horizontal = 16.dp, vertical = 24.dp
            )
    ) {

        val (header, logo, buttons, footer) = createRefs()

        Header(
            modifier = Modifier.constrainAs(header) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
        )

        VerticalSpace(16.dp)

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

        VerticalSpace(16.dp)

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

    CustomButton(
        textColor = Black,
        backgroundColor = White,
        icon = R.drawable.ic_google,
        modifier = Modifier.padding(horizontal = 16.dp),
        text = stringResource(R.string.google_sign_in),
    ) {
        onSignInClick()
    }

    VerticalSpace(8.dp)

    CustomButton(
        textColor = White,
        backgroundColor = Orange,
        modifier = Modifier.padding(horizontal = 16.dp),
        text = stringResource(R.string.ignore_sign_in),
    ) {
        onIgnoreClicked()
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

    VerticalSpace(8.dp)

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
