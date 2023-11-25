package com.example.grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,
    val coursesAmount: Int,
    @DrawableRes val image: Int
)
