package com.example.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingPagerComponent(
    onboardingSteps: List<OnboardingSteps>,
    onOnboardingFinish: () -> Unit
) {
    val pagerState = rememberPagerState(
        pageCount = onboardingSteps.size,
        infiniteLoop = false,
        initialPage = 0
    )

    OnboardingPager(
        item = onboardingSteps,
        pagerState = pagerState,
        modifier = Modifier,
        onOnboardingFinish = onOnboardingFinish
    )
}
