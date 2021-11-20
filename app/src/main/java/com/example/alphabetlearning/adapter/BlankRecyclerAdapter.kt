package com.example.alphabetlearning.adapter

import android.content.ClipDescription
import android.content.Context
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.alphabetlearning.R
import com.example.alphabetlearning.model.LetterTranslator

class BlankRecyclerAdapter(private val _context: Context, private val _listData: Array<LetterTranslator>) : RecyclerView.Adapter<BlankRecyclerAdapter.BHolder>() {

    inner class BHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<ImageView>(R.id.image_drop)
        private val cons = itemView.findViewById<ConstraintLayout>(R.id.constraint_drop)
        fun bindHolder(context: Context, listData: LetterTranslator) {
            val maskDragListener = View.OnDragListener { view, dragEvent ->

                val draggableItem = dragEvent.localState as View

                when (dragEvent.action) {
                    DragEvent.ACTION_DRAG_STARTED -> {
                        true
                    }
                    DragEvent.ACTION_DRAG_ENTERED -> {
                        draggableItem.visibility = View.INVISIBLE
                        cons.alpha = 0.3f
                        true
                    }
                    DragEvent.ACTION_DRAG_LOCATION -> {
                        true
                    }
                    DragEvent.ACTION_DRAG_EXITED -> {
                        cons.alpha = 1.0f
                        view.invalidate()
                        true
                    }
                    DragEvent.ACTION_DROP -> {
                        cons.alpha = 1.0f
                        if (dragEvent.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                            val draggedData = dragEvent.clipData.getItemAt(0).text
                            println("draggedData $draggedData")
                        }

                        if (dragEvent.clipData.getItemAt(0).text == listData.letter.toString()) {
                            draggableItem.x = dragEvent.x - (draggableItem.width / 2)
                            draggableItem.y = dragEvent.y - (draggableItem.height / 2)

                            val parent = draggableItem.parent as ConstraintLayout
                            parent.removeView(draggableItem)

                            val dropArea = view as ConstraintLayout
                            dropArea.addView(draggableItem)
                        }
                        true
                    }
                    DragEvent.ACTION_DRAG_ENDED -> {
                        draggableItem.visibility = View.VISIBLE
                        view.invalidate()
                        true
                    }
                    else -> {
                        false
                    }

                }
            }

            val resourceId = context.resources.getIdentifier(
                "water",
                "drawable",
                context.packageName
            )
            imageView.setImageResource(resourceId)
            cons.setOnDragListener(maskDragListener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BHolder {
        val view = LayoutInflater.from(_context).inflate(R.layout.dash , parent , false)
        return BHolder(view)
    }

    override fun onBindViewHolder(holder: BHolder, position: Int) {
        holder.bindHolder(_context , _listData[position])
    }

    override fun getItemCount(): Int {
        return _listData.count()
    }
}