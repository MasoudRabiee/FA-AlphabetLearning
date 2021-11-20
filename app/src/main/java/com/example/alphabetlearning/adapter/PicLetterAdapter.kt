package com.example.alphabetlearning.adapter

import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.alphabetlearning.R
import com.example.alphabetlearning.model.LetterTranslator

class PicLetterAdapter(private val _context: Context, private val _listData: MutableList<LetterTranslator>) : RecyclerView.Adapter<PicLetterAdapter.PicHolder>() {

    inner class PicHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.image_drag)


        fun bindHolder(context: Context, listData: LetterTranslator) {
            val maskDragMessage = listData.letter.toString()
            val resourceId = context.resources.getIdentifier(
                listData.letterImage,
                "drawable",
                context.packageName
            )
            image.setImageResource(resourceId)
            image.setOnLongClickListener {
                val item = ClipData.Item(maskDragMessage)

                val dataToDrag = ClipData(
                    maskDragMessage,
                    arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                    item
                )
                val maskShadow = MaskDragShadowBuilder(it, listData, context)

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    //support pre-Nougat versions
                    @Suppress("DEPRECATION")
                    it.startDrag(dataToDrag, maskShadow, it, 0)
                } else {
                    //supports Nougat and beyond
                    it.startDragAndDrop(dataToDrag, maskShadow, it, 0)
                }

                it.visibility = View.INVISIBLE
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicHolder {
        val view = LayoutInflater.from(_context).inflate(R.layout.letter, parent, false)
        return PicHolder(view)
    }

    override fun onBindViewHolder(holder: PicHolder, position: Int) {
        holder.bindHolder(_context, _listData[position])
    }

    override fun getItemCount(): Int {
        return _listData.count()
    }
}