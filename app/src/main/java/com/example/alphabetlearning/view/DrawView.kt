package com.example.alphabetlearning.view

import android.content.ContentValues
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.example.alphabetlearning.data.DataAlphabetLetter
import com.example.alphabetlearning.model.AlphabetLetter
import com.example.alphabetlearning.model.SkeletonShape
import kotlin.math.*

class DrawView : View {

    private lateinit var paint: Paint
    private lateinit var drawPaint: Paint
    private lateinit var canvasPaint: Paint
    private lateinit var drawPath: Path
    private lateinit var canvasBitmap: Bitmap
    private lateinit var drawCanvas: Canvas

    //    var p: Path? = null
//    var r: Region? = null
    private lateinit var pointPath: Array<FloatPoint?>
    private var pFlag = true
    private var holdFlag = false

    // roz 4 :
    private lateinit var paths: Array<Path>
    private lateinit var pathsPoints: List<Array<FloatPoint?>>

    // roz 6:
    private lateinit var thresholdList: Array<Int>

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        init()
    }

    constructor(context: Context, attr: AttributeSet, defStyle: Int) : super(
        context,
        attr,
        defStyle
    ) {
        init()
    }

    private fun init() {
        // initialize variables :
        paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 20f
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND

        // bra keshidan :
        drawPaint = Paint()
        drawPaint.color = Color.RED
        drawPaint.isAntiAlias = true
        drawPaint.strokeWidth = 50f
        drawPaint.style = Paint.Style.STROKE
        drawPaint.strokeJoin = Paint.Join.ROUND
        drawPaint.strokeCap = Paint.Cap.ROUND

        canvasPaint = Paint(Paint.DITHER_FLAG)

        drawPath = Path()

        //roz 4:
        val pathCount = DataAlphabetLetter.BE.totalPath()
        paths = Array<Path>(pathCount) {
            Path()
        }
        thresholdList = Array(pathCount) {
            0
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(canvasBitmap)
    }


    override fun onDraw(canvas: Canvas) {
//        p = Path()
        // bra ye khat azmayeshi :
//        p!!.moveTo(50f, 50f)
//        p!!.lineTo(200f, 200f)
//        p!!.lineTo(200f, 500f)
//        p!!.lineTo(800f,500f)
//        p!!.lineTo(80f, 100f)
        // bra dynamic :
//        createPath(p!!, DataSkeleton.ALEF_Skeleton_Sm)
        // bra ye alphabet :
        createPaths(paths, DataAlphabetLetter.BE)
//        canvas.drawPath(p!!, paint)
//        p!!.close()
        drawPaths(canvas, paint, paths)
//        closePaths(paths)
        if (pFlag) {
//            pointPath = getPoints(p!!)
//            pFlag = false
            // bra roz 4 :
            setThresholds(thresholdList , DataAlphabetLetter.BE)
            pathsPoints = getPointsOfPaths(paths , thresholdList)
            pFlag = false

        }
        canvas.drawBitmap(canvasBitmap, 0f, 0f, canvasPaint)
        canvas.drawPath(drawPath, drawPaint)

//        val rectF = RectF()
//        p!!.computeBounds(rectF, true)
//        r = Region()
//        r!!.setPath(
//            p, Region(
//                rectF.left.toInt(), rectF.top.toInt(), rectF.right.toInt(),
//                rectF.bottom.toInt()
//            )
//        )
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val point = PointF()
        point.x = event.x
        point.y = event.y
        Log.d(ContentValues.TAG, "point: $point")
        if (isAllPointsTouched(pathsPoints)) {
            Log.d(ContentValues.TAG, "Mission is complete ez pz")
        } else {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (isNearOfPoint(pathsPoints, point))
                        drawPath.moveTo(point.x, point.y)
                }
                MotionEvent.ACTION_MOVE -> {
                    if (isNearOfPoint(pathsPoints, point)) {
                        if (!holdFlag) {
//                    drawPath.moveTo(point.x, point.y)
                            drawPath.moveTo(point.x, point.y)
                            holdFlag = true
                        }
                        drawCanvas.drawPath(drawPath, drawPaint)
                        drawPath.lineTo(point.x, point.y)
                    } else {
                        drawPath.reset()
                        holdFlag = false
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (isNearOfPoint(pathsPoints, point)) {
//                    drawPath.moveTo(point.x, point.y)
                        drawPath.lineTo(point.x, point.y)
                        drawCanvas.drawPath(drawPath, drawPaint)
                        drawPath.reset()
                    } else {
                        drawPath.reset()
                    }
                }
                else -> return false
            }
        }
//        if (r!!.contains(point.x.toInt(), point.y.toInt())) Log.d(
//            ContentValues.TAG,
//            "Touch IN"
//        ) else Log.d(
//            ContentValues.TAG, "Touch OUT"
//        )
        invalidate()
        return true
    }
}

private fun getPoints(path: Path, numOfPoints: Int = 10): Array<FloatPoint?> {
    val pointArray: Array<FloatPoint?> = arrayOfNulls<FloatPoint>(numOfPoints)
    val pm = PathMeasure(path, false)
    val length = pm.length / 2
    var distance = 0f
    val speed = length / numOfPoints
    var counter = 0
    val aCoordinates = FloatArray(2)
    while (distance < length && counter < numOfPoints) {
        // get point from the path
        pm.getPosTan(distance, aCoordinates, null)
        pointArray[counter] = FloatPoint(
            aCoordinates[0],
            aCoordinates[1]
        )
        counter++
        distance += speed
    }
    return pointArray
}

fun checkThreshold(p: Array<FloatPoint?>, pointTouch: PointF): Boolean {
    val threshold = getDistance(p[0]!!, p[1]!!)
    val concatPath = Path()
    var concatMeasure: PathMeasure
    p.forEach {
        if (it != null) {
            concatPath.moveTo(it.x, it.y)
            concatPath.lineTo(pointTouch.x, pointTouch.y)
            concatMeasure = PathMeasure(concatPath, false)
            if (concatMeasure.length / 2 <= threshold) {
                it.isTouched = true
                concatPath.reset()
                concatPath.close()
                return true
            }
            concatPath.reset()
            concatPath.close()
        }
    }
    return false
}

fun getDistance(p1: FloatPoint, p2: FloatPoint): Float {
    return sqrt((p1.x - p2.x).pow(2) + (p1.y - p2.y).pow(2))
}

fun isWholeTouch(touchPoints: Array<FloatPoint?>): Boolean {
    var result = true
    touchPoints.forEach {
        if (it != null) {
            result = result and it.isTouched
        }
    }
    return result
}

data class FloatPoint(var x: Float, var y: Float, var isTouched: Boolean = false)


// roz 3:
fun createPath(path: Path, skeletonKind: SkeletonShape) {
    path.reset()
    path.moveTo(skeletonKind.startPointF.x, skeletonKind.startPointF.y)
    var index = 0
    var firstPoint = skeletonKind.startPointF
    var secondPoint : PointF
    if (skeletonKind.middleShape.middlePointsF != null){
        skeletonKind.middleShape.middlePointsF!!.forEach {
            secondPoint = it
            val curveArrow = skeletonKind.middleShape.curveMiddle!![index]
            drawCurvedArrow(firstPoint , secondPoint , path , curveArrow.curveRadius , curveArrow.effectPercent)
            firstPoint = it
            index++
        }
        val lastArrow = skeletonKind.middleShape.curveMiddle!![index]
        drawCurvedArrow(firstPoint , skeletonKind.endPointF , path , lastArrow.curveRadius , lastArrow.effectPercent)
    }
    else {
        val lastArrow = skeletonKind.tools
        drawCurvedArrow(firstPoint , skeletonKind.endPointF , path , lastArrow.curveRadius , lastArrow.effectPercent)
    }

//    skeletonKind.middlePointsF.forEach {
//        path.lineTo(it.x, it.y)
//    }
//    path.lineTo(skeletonKind.endPointF.x, skeletonKind.endPointF.y)
}

//roz 4:
fun createPaths(pathList: Array<Path>, alphaLtr: AlphabetLetter) {
    createPath(pathList[0], alphaLtr.smallShape)
    createPath(pathList[1], alphaLtr.capitalShape)
    var iterator = 2
    val capAdditionalCount = alphaLtr.capitalShape.pathRequireCount() - 1
    val smAdditionalCount = alphaLtr.smallShape.pathRequireCount() - 1
    if (alphaLtr.smallShape.additionalShape.isNotEmpty()) {
        for (i in iterator until smAdditionalCount + iterator) {
            createPath(pathList[i], alphaLtr.smallShape.additionalShape[i - iterator])
        }
        iterator += smAdditionalCount
    }
    if (alphaLtr.capitalShape.additionalShape.isNotEmpty()) {
        for (i in iterator until capAdditionalCount + iterator) {
            createPath(pathList[i], alphaLtr.capitalShape.additionalShape[i - iterator])
        }
    }
}

//fun closePaths(pathList: Array<Path>){
//    pathList.forEach {
//        it.close()
//
//    }
//}

fun drawPaths(canvas: Canvas, paint: Paint, pathList: Array<Path>) {
    pathList.forEach {
        canvas.drawPath(it, paint)
        it.close()
    }
}

fun getPointsOfPaths(pathList: Array<Path>, thresholds: Array<Int>): List<Array<FloatPoint?>> {
    val resultPoints: ArrayList<Array<FloatPoint?>> = arrayListOf()
    for (i in pathList.indices){
        resultPoints.add(getPoints(pathList[i] , thresholds[i]))
    }
    return resultPoints.toList()
}

fun isAllPointsTouched(pointsOfPaths: List<Array<FloatPoint?>>): Boolean {
    var result = true
    var subResult: Boolean
    pointsOfPaths.forEach {
        subResult = isWholeTouch(it)
        result = result and subResult
    }
    return result
}

fun isNearOfPoint(pointsOfPaths: List<Array<FloatPoint?>>, touchPoint: PointF): Boolean {
    var result: Boolean
    pointsOfPaths.forEach {
        result = checkThreshold(it, touchPoint)
        if (result) {
            return true
        }
    }
    return false
}

fun setThresholds(thresholds: Array<Int>, alphaLtr: AlphabetLetter) {
    thresholds[0] = alphaLtr.smallShape.threshold
    thresholds[1] = alphaLtr.capitalShape.threshold
    var iterator = 2
    val capAdditionalCount = alphaLtr.capitalShape.pathRequireCount() - 1
    val smAdditionalCount = alphaLtr.smallShape.pathRequireCount() - 1
    if (alphaLtr.capitalShape.additionalShape.isNotEmpty()) {
        for (i in iterator until capAdditionalCount + iterator) {
            thresholds[i] = alphaLtr.capitalShape.additionalShape[i - iterator].threshold
        }
        iterator += capAdditionalCount
    }
    if (alphaLtr.smallShape.additionalShape.isNotEmpty()) {
        for (i in iterator until smAdditionalCount + iterator) {
            thresholds[i] = alphaLtr.smallShape.additionalShape[i - iterator].threshold
        }
    }
}

// bra keshidan monhani :
// curveRadius age manfi bashe reverse mishe **

fun drawCurvedArrow(firstPoint: PointF, lastPoint: PointF, path: Path, curveRadius: Int, anglePercent:Int) {
//    val paint = Paint()
//    paint.isAntiAlias = true
//    paint.style = Paint.Style.STROKE
//    paint.strokeWidth = lineWidth
//    paint.color = color
    val midX = firstPoint.x + (lastPoint.x - firstPoint.x) * anglePercent / 100
    val midY = firstPoint.y + (lastPoint.y - firstPoint.y) * anglePercent / 100
    val xDiff = (midX - firstPoint.x)
    val yDiff = (midY - firstPoint.y)
    val angle = atan2(yDiff.toDouble(), xDiff.toDouble()) * (180 / Math.PI) - 90
    val angleRadians = Math.toRadians(angle)
    val pointX = (midX + curveRadius * cos(angleRadians)).toFloat()
    val pointY = (midY + curveRadius * sin(angleRadians)).toFloat()
//    path.moveTo(firstPoint.x, firstPoint.y)
    path.cubicTo(firstPoint.x, firstPoint.y, pointX, pointY, lastPoint.x, lastPoint.y)
//    canvas.drawPath(path, paint)
}