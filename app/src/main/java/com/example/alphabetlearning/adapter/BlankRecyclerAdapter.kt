package com.example.alphabetlearning.adapter

import android.app.AlertDialog
import android.content.ClipDescription
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.media.MediaPlayer
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.alphabetlearning.R
import com.example.alphabetlearning.model.LetterTranslator

class BlankRecyclerAdapter(private val _context: Context, private val _listData: Array<LetterTranslator>) : RecyclerView.Adapter<BlankRecyclerAdapter.BHolder>() {

    inner class BHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cons = itemView.findViewById<ConstraintLayout>(R.id.constraint_drop)
        private lateinit var alertShow: AlertDialog
        private lateinit var gradientColor: GradientDrawable

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

                            gradientColor = GradientDrawable(GradientDrawable.Orientation.BR_TL, intArrayOf(0xFFA1FFCE.toInt(), 0xFFFAFFD1.toInt(), 0xFFFAFFD1.toInt(), 0xFFA1FFCE.toInt()))
                            gradientColor.cornerRadius = 0f
                            draggableItem.background = gradientColor

                            draggableItem.x = draggableItem.x
                            draggableItem.y = draggableItem.y

                            val parent = draggableItem.parent as ConstraintLayout
                            parent.removeView(draggableItem)

                            val dropArea = view as ConstraintLayout
                            dropArea.addView(draggableItem)
                            listData.isDrop = true
                            val endGame = checkMissionCompleted(_listData)
                            if (endGame) {
                                createAlert(context)
                                alertShow.show()
                                MediaPlayer.create(context , R.raw.vafarin).start()
                            }
                        } else {
                            MediaPlayer.create(context , R.raw.vretry).start()
                            Toast.makeText(context, "اشتباه کردی ! دوباره تلاش کن", Toast.LENGTH_SHORT).show()
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

//            val resourceId = context.resources.getIdentifier(
//                "water",
//                "drawable",
//                context.packageName
//            )
//            imageView.setImageResource(resourceId)
            cons.setOnDragListener(maskDragListener)
        }

        private fun checkMissionCompleted(translator: Array<LetterTranslator>): Boolean {
            translator.forEach {
                if (!it.isDrop) {
                    return false
                }
            }
            return true
        }

        private fun createAlert(context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setView(View.inflate(context, R.layout.fragment_success, null))
                .setNegativeButton(
                    R.string.back
                ) { dialog, _ ->
                    dialog.cancel()
                }

            alertShow = builder.create()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BHolder {
        val view = LayoutInflater.from(_context).inflate(R.layout.dash, parent, false)
        return BHolder(view)
    }

    override fun onBindViewHolder(holder: BHolder, position: Int) {
        holder.bindHolder(_context, _listData[position])
    }

    override fun getItemCount(): Int {
        return _listData.count()
    }
}