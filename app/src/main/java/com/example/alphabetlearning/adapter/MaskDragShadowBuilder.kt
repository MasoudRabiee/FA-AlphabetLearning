package com.example.alphabetlearning.adapter

import android.content.Context
import android.graphics.Canvas
import android.graphics.Point
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.example.alphabetlearning.model.LetterTranslator

class MaskDragShadowBuilder(view: View, data: LetterTranslator, context: Context) : View.DragShadowBuilder(view) {

    private val resId = context.resources.getIdentifier(data.letterImage , "drawable" , context.packageName)
    private val shadow = ResourcesCompat.getDrawable(
        view.context.resources,
        resId,
        view.context.theme
    )

    override fun onProvideShadowMetrics(size: Point, touch: Point) {
        val width: Int = view.width
        val height: Int = view.height
        shadow?.setBounds(0, 0, width, height)
        size.set(width, height)
        touch.set(width / 2, height / 2)
    }

    override fun onDrawShadow(canvas: Canvas) {
        shadow?.draw(canvas)
    }


}