package com.example.alphabetlearning.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurveTools(var curveRadius: Int = 0, var effectPercent: Int = 50) : Parcelable {}