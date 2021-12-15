package com.example.alphabetlearning.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.alphabetlearning.R
import com.example.alphabetlearning.model.PuzzleAB
import com.example.alphabetlearning.view.PuzzleActivity

class PicListAdapter(private var _context: Context, private var _listData: ArrayList<PuzzleAB>) : RecyclerView.Adapter<PicListAdapter.Holder>() {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imagePic = itemView.findViewById<ImageView>(R.id.image_view13)

        fun bindHolder(context: Context, data: PuzzleAB) {
            val resourceId = context.resources.getIdentifier(data.imagePuzzle, "drawable" , context.packageName)
            imagePic.apply {
                setImageResource(resourceId)
                setOnClickListener {
                    val nextActivity = Intent(context , PuzzleActivity::class.java)
                    nextActivity.putExtra("pic" , data)
                    context.startActivity(nextActivity)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(_context).inflate(R.layout.category_pic_letter , parent , false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindHolder(_context , _listData[position])
    }

    override fun getItemCount(): Int {
        return _listData.count()
    }
}