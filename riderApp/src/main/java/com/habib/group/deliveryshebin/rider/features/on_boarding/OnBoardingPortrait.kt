package com.habib.group.deliveryshebin.rider.features.on_boarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.habib.group.deliveryshebin.rider.R
import com.habib.group.deliveryshebin.rider.features.splash.Header
import com.habib.group.deliveryshebin.rider.utils.commonUI.CustomButton
import com.habib.group.deliveryshebin.rider.utils.commonUI.VerticalSpace
import com.habib.group.deliveryshebin.rider.theme.Black
import com.habib.group.deliveryshebin.rider.theme.Orange2
import com.habib.group.deliveryshebin.rider.theme.Primary
import com.habib.group.deliveryshebin.rider.theme.Secondary
import com.habib.group.deliveryshebin.rider.theme.White

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun OnBoardingPortrait(onLetsGoClick: () -> Unit) {

    val pagerState = rememberPagerState(0, pageCount = { onBoardingPages.size })

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
    ) {
        val (toolbar, body) = createRefs()

        Box(
            modifier = Modifier
                .constrainAs(toolbar) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        ) {
            Column(modifier = Modifier.align(Alignment.Center)) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(CircleShape)
                        .fillMaxHeight(0.4f),
                    contentDescription = "Logo",
                    painter = painterResource(R.drawable.ic_logo_no_txt)
                )

                Header(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }

        ConstraintLayout(
            modifier = Modifier
                .constrainAs(body) {
                    verticalBias = 0f
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    top.linkTo(toolbar.bottom)
                    bottom.linkTo(parent.bottom)
                    height = Dimension.fillToConstraints
                }
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(White)
        ) {

            val (pager, indicator) = createRefs()

            Column(
                modifier = Modifier.constrainAs(pager) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(indicator.top)
                }
            ) {
                HorizontalPager(state = pagerState) { page ->

                    val currentPage = onBoardingPages[page]

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp),
                            painter = painterResource(currentPage.image),
                        )

                        VerticalSpace(8.dp)

                        if (currentPage.pageHint == R.string.lets_go) {
                            CustomButton(
                                textSize = 18.sp,
                                textColor = White,
                                backgroundColor = Orange2,
                                text = stringResource(R.string.lets_go),
                                modifier = Modifier.padding(horizontal = 60.dp)
                            ) {
                                onLetsGoClick()
                            }
                        } else {
                            Text(
                                color = Black,
                                fontSize = 18.sp,
                                text = stringResource(currentPage.pageHint)
                            )
                        }
                    }
                }
            }

            VerticalSpace(16.dp)

            Row(
                modifier = Modifier
                    .constrainAs(indicator) {
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center) {
                repeat(onBoardingPages.size) { index ->
                    val isSelected = pagerState.currentPage == index
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(12.dp)
                            .background(
                                shape = CircleShape,
                                color = if (isSelected) Primary else Secondary
                            )
                    )
                }
            }
        }
    }
}

private val onBoardingPages = listOf(
    OnBoardingModel(
        image = R.drawable.on_boarding_1,
        title = R.string.onboarding_hint_1,
        pageHint = R.string.onboarding_hint_4
    ), OnBoardingModel(
        image = R.drawable.on_boarding_2,
        title = R.string.onboarding_hint_2,
        pageHint = R.string.onboarding_hint_5
    ), OnBoardingModel(
        image = R.drawable.on_boarding_3,
        title = R.string.onboarding_hint_3,
        pageHint = R.string.onboarding_hint_6
    ), OnBoardingModel(
        title = R.string.lets_go_1, pageHint = R.string.lets_go, image = R.drawable.on_boarding_4
    )
)

private data class OnBoardingModel(val image: Int, val title: Int, val pageHint: Int)