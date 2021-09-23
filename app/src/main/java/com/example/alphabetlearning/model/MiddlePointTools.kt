package com.example.alphabetlearning.model

import android.graphics.PointF
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MiddlePointTools(var middlePointsF : ArrayList<PointF>?, var curveMiddle:ArrayList<CurveTools>?):Parcelable {}