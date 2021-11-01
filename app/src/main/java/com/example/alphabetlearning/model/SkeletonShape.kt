package com.example.alphabetlearning.model

import android.graphics.PointF
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.ArrayList

@Parcelize
class SkeletonShape(
    var startPointF: PointF,
    var endPointF: PointF,
    var middleShape: MiddlePointTools,
    var additionalShape: ArrayList<SkeletonShape>,
    var tools: CurveTools,
    var threshold: Int = 15) :
    Parcelable {


//    constructor(startPointF: PointF, endPointF: PointF, middleShape: MiddlePointTools, tools: CurveTools, threshold: Int = 15) : this(startPointF, endPointF, tools, threshold) {
//        this.middleShape = middleShape
//    }
//
//    constructor(startPointF: PointF, endPointF: PointF, middleShape: MiddlePointTools, additionalShape: ArrayList<SkeletonShape>, tools: CurveTools, threshold: Int = 15) : this(startPointF, endPointF, middleShape, tools, threshold) {
//        this.additionalShape = additionalShape
//    }


    fun pathRequireCount(): Int {
        return this.additionalShape.count() + 1
    }

}