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
import com.example.alphabetlearning.view.GameUpActivity
import com.example.alphabetlearning.view.MotionGameActivity

class LetterRecyclerAdapter(
    private val _context: Context,
    private val _letterList: ArrayList<AlphabetLetter>,
    private val option : Int
) : RecyclerView.Adapter<LetterRecyclerAdapter.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageCategory = itemView.findViewById<ImageView>(R.id.image_view1)

        fun bindHolder(context: Context, letter:AlphabetLetter , setClickKind : Int) {
            val resourceId = context.resources.getIdentifier(letter.imageName , "drawable" , context.packageName)
            imageCategory.setImageResource(resourceId)
            if (setClickKind == 1){
                imageCategory.setOnClickListener {
                    val nextActivity = Intent(context , MotionGameActivity::class.java).apply {
                        putExtra("id" , letter.letter)
                    }
                    context.startActivity(nextActivity)
                }
            }
            else if (setClickKind == 2) {
                imageCategory.setOnClickListener{
                    val nextActivity = Intent(context , DrawingActivity::class.java)
                    nextActivity.putExtra("shape" , letter)
                    context.startActivity(nextActivity)
                }
            }
            else {
                imageCategory.setOnClickListener {
                    val nextActivity = Intent(context, GameUpActivity::class.java).apply {
                        putExtra("id", letter.letter)
                    }
                    context.startActivity(nextActivity)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(_context).inflate(R.layout.category_alphabet_letter , parent , false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindHolder(_context , _letterList[position] , option)
    }

    override fun getItemCount(): Int {
        return _letterList.count()
    }
}