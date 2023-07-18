package com.example.onboarding

import androidx.annotation.RawRes
import androidx.annotation.StringRes

enum class OnboardingSteps(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @RawRes val image: Int
) {
    STEP_1(R.string.step_1_title, R.string.step_1_description, R.raw.step_1),
    STEP_2(R.string.step_2_title, R.string.step_2_description, R.raw.step_2),
    STEP_3(R.string.step_3_title, R.string.step_3_description, R.raw.step_3)
}