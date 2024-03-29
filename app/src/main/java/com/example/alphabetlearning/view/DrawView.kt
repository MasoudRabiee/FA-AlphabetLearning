package com.example.alphabetlearning.view

import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context
import android.graphics.*
import android.media.MediaPlayer
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.example.alphabetlearning.R
import com.example.alphabetlearning.model.*
import kotlin.math.*

class DrawView : View {

    private lateinit var paint: Paint
    private lateinit var drawPaint: Paint
    private lateinit var canvasPaint: Paint
    private lateinit var drawPath: Path
    private lateinit var canvasBitmap: Bitmap
    private lateinit var drawCanvas: Canvas

    private var pFlag = true
    private var holdFlag = false

    private lateinit var paths: Array<Path>
    private lateinit var pathsPoints: List<Array<TouchFloatPoint?>>

    private lateinit var thresholdList: Array<Int>

    //data
    private var dataDraw: AlphabetLetter? = null

    //alertDialog
    private lateinit var alertShow: AlertDialog

    // context
    private var _context: Context
    private var clearCanvasFlag = false
    private lateinit var toast: Toast

    constructor(context: Context) : super(context) {
        _context = context
        init()
    }

    constructor(context: Context, datadraw: AlphabetLetter) : super(context) {
        _context = context
        this.dataDraw = datadraw
        init()
    }

    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        _context = context
        init()
    }

    constructor(context: Context, attr: AttributeSet, defStyle: Int) : super(
        context,
        attr,
        defStyle
    ) {
        _context = context
        init()
    }

//    fun setDataDrawer(data: AlphabetLetter) {
//        dataDraw = data
//    }
//
//    fun reinitialization() {
//        init()
//    }

    private fun init() {
        // initialize variables :
        paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 25f
        paint.style = Paint.Style.STROKE
        paint.strokeJoin = Paint.Join.ROUND
        paint.strokeCap = Paint.Cap.ROUND

        // paint draw :
        drawPaint = Paint()
        drawPaint.color = Color.RED
        drawPaint.isAntiAlias = true
        drawPaint.strokeWidth = 50f
        drawPaint.style = Paint.Style.STROKE
        drawPaint.strokeJoin = Paint.Join.ROUND
        drawPaint.strokeCap = Paint.Cap.ROUND

        canvasPaint = Paint(Paint.DITHER_FLAG)

        drawPath = Path()

        val pathCount = dataDraw!!.totalPath()
        paths = Array<Path>(pathCount) {
            Path()
        }
        thresholdList = Array(pathCount) {
            0
        }

        val builder = AlertDialog.Builder(context)
        builder.setView(inflate(context, R.layout.fragment_success, null))
            .setNegativeButton(
                R.string.back
            ) { dialog, _ ->
                dialog.cancel()
            }
            .setPositiveButton(
                R.string.retry
            ) { dialog, _ ->
                dialog.cancel()
                clearDraw()
            }

        alertShow = builder.create()

        toast = Toast.makeText(_context , "دوباره تلاش کن" , Toast.LENGTH_SHORT)

        val letterSound = ConvertVoice(dataDraw!!.letter[0]).voiceId
        MediaPlayer.create(_context , letterSound).start()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(canvasBitmap)
    }


    override fun onDraw(canvas: Canvas) {
        if (clearCanvasFlag) {
            canvas.drawColor(Color.WHITE)
            clearCanvasFlag = false
        }
        createPaths(paths, dataDraw!!)
//        canvas.drawPath(p!!, paint)
//        p!!.close()
        drawPaths(canvas, paint, paths)
        if (pFlag) {
            setThresholds(thresholdList, dataDraw!!)
            pathsPoints = getPointsOfPaths(paths, thresholdList)
            pFlag = false
        }
        canvas.drawBitmap(canvasBitmap, 0f, 0f, canvasPaint)
        canvas.drawPath(drawPath, drawPaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val point = PointF()
        point.x = event.x
        point.y = event.y
        Log.d(ContentValues.TAG, "point: $point")
        if (isAllPointsTouched(pathsPoints)) {
            alertShow.show()
            MediaPlayer.create(_context , R.raw.vafarin).start()
        } else {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (isNearOfPoint(pathsPoints, point)) {
                        drawPath.moveTo(point.x, point.y)
                        // maybe make bug
                        drawPath.lineTo(point.x, point.y)
                    }
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
                        // bug : :(
//                        MediaPlayer.create(_context , R.raw.vretry).start()
                        toast.show()
                        clearDraw()
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

    private fun clearDraw() {
        clearCanvasFlag = true
        drawPath = Path()
        setFalsePoints(pathsPoints)
        draw(drawCanvas)
        invalidate()
    }

    private fun setFalsePoints(listPoints: List<Array<TouchFloatPoint?>>) {
        listPoints.forEach { it ->
            it.forEach { itT ->
                if (itT != null) {
                    itT.isTouched = false
                }
            }
        }
    }

    private fun getPoints(path: Path, numOfPoints: Int = 10): Array<TouchFloatPoint?> {
        val pointArray: Array<TouchFloatPoint?> = arrayOfNulls<TouchFloatPoint>(numOfPoints)
        val pm = PathMeasure(path, false)
        val length = pm.length / 2
        var distance = 0f
        // check maybe bug this :C
        val speed: Float = if (numOfPoints > 2) {
            length * 2 / numOfPoints
        } else {
            length / numOfPoints
        }
        var counter = 0
        val aCoordinates = FloatArray(2)
        while (distance < length && counter < numOfPoints) {
            // get point from the path
            pm.getPosTan(distance, aCoordinates, null)
            pointArray[counter] = TouchFloatPoint(
                aCoordinates[0],
                aCoordinates[1]
            )
            counter++
            distance += speed
        }
        return pointArray
    }

    private fun checkThreshold(p: Array<TouchFloatPoint?>, pointTouch: PointF): Boolean {
        var result = false
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
                    result = true
                }
                concatPath.reset()
                concatPath.close()
            }
        }
        return result
    }

    private fun getDistance(p1: TouchFloatPoint, p2: TouchFloatPoint): Float {
        return sqrt((p1.x - p2.x).pow(2) + (p1.y - p2.y).pow(2))
    }

    private fun isWholeTouch(touchPoints: Array<TouchFloatPoint?>): Boolean {
        var result = true
        touchPoints.forEach {
            if (it != null) {
                result = result and it.isTouched
            }
        }
        return result
    }

    private fun createPath(path: Path, skeletonKind: SkeletonShape) {
        path.reset()
        path.moveTo(skeletonKind.startPointF.x, skeletonKind.startPointF.y)
        val lastArrow: CurveTools
        var index = 0
        var firstPoint = skeletonKind.startPointF
        var secondPoint: PointF
        if (skeletonKind.middleShape.middlePointsF != null) {
            skeletonKind.middleShape.middlePointsF!!.forEach {
                secondPoint = it
                val curveArrow = skeletonKind.middleShape.curveMiddle!![index]
                drawCurvedArrow(firstPoint, secondPoint, path, curveArrow.curveRadius, curveArrow.effectPercent)
                firstPoint = it
                index++
            }
            lastArrow = skeletonKind.middleShape.curveMiddle!![index]
        } else {
            lastArrow = skeletonKind.tools
        }
//    path.lineTo(skeletonKind.endPointF.x , skeletonKind.endPointF.y)
        drawCurvedArrow(firstPoint, skeletonKind.endPointF, path, lastArrow.curveRadius, lastArrow.effectPercent)


//    skeletonKind.middlePointsF.forEach {
//        path.lineTo(it.x, it.y)
//    }
//    path.lineTo(skeletonKind.endPointF.x, skeletonKind.endPointF.y)
    }

    private fun createPaths(pathList: Array<Path>, alphaLtr: AlphabetLetter) {
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

    private fun drawPaths(canvas: Canvas, paint: Paint, pathList: Array<Path>) {
        pathList.forEach {
            canvas.drawPath(it, paint)
            it.close()
        }
    }

    private fun getPointsOfPaths(pathList: Array<Path>, thresholds: Array<Int>): List<Array<TouchFloatPoint?>> {
        val resultPoints: ArrayList<Array<TouchFloatPoint?>> = arrayListOf()
        for (i in pathList.indices) {
            resultPoints.add(getPoints(pathList[i], thresholds[i]))
        }
        return resultPoints.toList()
    }

    private fun isAllPointsTouched(pointsOfPaths: List<Array<TouchFloatPoint?>>): Boolean {
        var result = true
        var subResult: Boolean
        pointsOfPaths.forEach {
            subResult = isWholeTouch(it)
            result = result and subResult
        }
        return result
    }

    private fun isNearOfPoint(pointsOfPaths: List<Array<TouchFloatPoint?>>, touchPoint: PointF): Boolean {
        var result: Boolean
        pointsOfPaths.forEach {
            result = checkThreshold(it, touchPoint)
            if (result) {
                return true
            }
        }
        return false
    }

    private fun setThresholds(thresholds: Array<Int>, alphaLtr: AlphabetLetter) {
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

// bra keshidan monhani : (dar jahat aqrabe saat)
// curveRadius age manfi bashe reverse mishe **

    private fun drawCurvedArrow(firstPoint: PointF, lastPoint: PointF, path: Path, curveRadius: Int, anglePercent: Int) {
//    val paint = Paint()
//    paint.isAntiAlias = true
//    paint.style = Paint.Style.STROKE
//    paint.strokeWidth = lineWidth
//    paint.color = color
        if (curveRadius == 0) {
            path.lineTo(lastPoint.x, lastPoint.y)
        } else {
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
    }
}

