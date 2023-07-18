package com.example.onboarding

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingPager(
    item: List<OnboardingSteps>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    onOnboardingFinish: () -> Unit
) {

    val coroutine = rememberCoroutineScope()

    Column(modifier = modifier, verticalArrangement = Arrangement.SpaceBetween) {
        Box(modifier = modifier, contentAlignment = Alignment.BottomEnd){
            SkipNextButton(text = "sasa", modifier = modifier) {

            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                //SkipNextButton(text = "Skip", modifier = modifier, onclick = { onOnboardingFinish() })
                Column(
                    modifier = modifier
                        .padding(60.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoaderIntro(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            .align(
                                alignment = Alignment.CenterHorizontally
                            ),
                        item[page].image
                    )

                    Text(
                        modifier = Modifier.padding(top = 50.dp),
                        text = stringResource(item[page].title),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp),
                        text = stringResource(item[page].description),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }

            PagerIndicator(item.size, pagerState.currentPage)
        }
        Box(contentAlignment = Alignment.BottomCenter) {
            BottomSelection(
                currentPager = pagerState.currentPage,
                onPrevious = {
                    coroutine.launch {
                        pagerState.scrollToPage(
                            if (pagerState.currentPage - 1 == 0) 0 else pagerState.currentPage - 1
                        )
                    }
                },
                onNext = {
                    coroutine.launch {
                        if (pagerState.currentPage + 1 == item.size)
                            onOnboardingFinish()
                        else {
                            pagerState.scrollToPage(
                                if (pagerState.currentPage + 1 == item.size) pagerState.currentPage else pagerState.currentPage + 1
                            )
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun PagerIndicator(size: Int, currentPage: Int) {
    Row(
        modifier = Modifier.padding(top = 60.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) Color.Red.copy(alpha = 0.6f) else Color.LightGray
            )
    )
}

@Composable
fun BottomSelection(
    currentPager: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        SkipNextButton(
            text = "Previous",
            modifier = Modifier,
            onclick = onPrevious
        )
        SkipNextButton(
            text = "Next",
            modifier = Modifier,
            onclick = onNext
        )
    }
}

@Composable
fun SkipNextButton(text: String, modifier: Modifier, onclick: () -> Unit) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier
            .clickable { onclick() }
            .padding(8.dp),
        fontSize = 18.sp,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun LoaderIntro(modifier: Modifier, image: Int) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(image))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier
    )
}