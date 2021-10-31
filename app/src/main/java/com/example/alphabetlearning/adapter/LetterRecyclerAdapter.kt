package com.example.alphabetlearning.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.alphabetlearning.R
import com.example.alphabetlearning.model.AlphabetLetter
import com.example.alphabetlearning.view.DrawingActivity

class LetterRecyclerAdapter(
    private val _context: Context,
    private val _letterList: ArrayList<AlphabetLetter>
) : RecyclerView.Adapter<LetterRecyclerAdapter.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageCategory = itemView.findViewById<ImageView>(R.id.image_view1)

        fun bindHolder(context: Context, letter:AlphabetLetter): Unit {
            val resourceId = context.resources.getIdentifier(letter.imageName , "drawable" , context.packageName)
            imageCategory.setImageResource(resourceId)
            imageCategory.setOnClickListener{
                val nextActivity = Intent(_context , DrawingActivity::class.java)
                nextActivity.putExtra("shape" , letter)
                _context.startActivity(nextActivity)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(_context).inflate(R.layout.category_alphabet_letter , parent , false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindHolder(_context , _letterList[position])
    }

    override fun getItemCount(): Int {
        return _letterList.count()
    }
}