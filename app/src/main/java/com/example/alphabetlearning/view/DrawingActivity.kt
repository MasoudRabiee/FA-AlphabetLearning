package com.example.alphabetlearning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet
import com.example.alphabetlearning.R
import com.example.alphabetlearning.databinding.ActivityDrawingBinding
import com.example.alphabetlearning.model.Alphabet
import com.example.alphabetlearning.model.AlphabetLetter
import com.example.alphabetlearning.model.SkeletonShape

class DrawingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDrawingBinding
    private lateinit var letterShape : AlphabetLetter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_drawing)

        val data = intent.extras
        if (data != null) {
            letterShape = data.getParcelable<AlphabetLetter>("shape") as AlphabetLetter
        }
        else{
            Toast.makeText(this , "داده دریافت نشد" , Toast.LENGTH_LONG).show()
        }



        binding = ActivityDrawingBinding.inflate(layoutInflater)
        val setConstraint = ConstraintSet()
        val viewDrawer = DrawView(this , letterShape)
        viewDrawer.id = View.generateViewId()
        binding.constraintDraw.addView(viewDrawer)
        setConstraint.clone(binding.constraintDraw)
        setConstraint.connect(viewDrawer.id , ConstraintSet.TOP , binding.constraintDraw.id , ConstraintSet.TOP , 5)
        setConstraint.applyTo(binding.constraintDraw)
        setContentView(binding.root)

    }
}