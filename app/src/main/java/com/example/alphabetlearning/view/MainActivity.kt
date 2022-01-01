package com.example.alphabetlearning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import com.example.alphabetlearning.databinding.ActivityMainBinding
import com.example.alphabetlearning.model.ScreenTool

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var secondActivity : Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        // set screen tool fields :
        ScreenTool.initTool(displayMetrics.widthPixels,displayMetrics.heightPixels)

        binding.btnDrawLetter.setOnClickListener {
            secondActivity = Intent(this , LetterActivity::class.java).apply {
                putExtra("PreActivity" , 2)
            }
            startActivity(secondActivity)
        }
        binding.btnPuzzle.setOnClickListener {
            secondActivity = Intent(this , PuzzlePicturesActivity::class.java)
            startActivity(secondActivity)
        }
        binding.btnGame.setOnClickListener {
            secondActivity = Intent(this , LetterActivity::class.java).apply {
                putExtra("PreActivity" , 1)
            }
            startActivity(secondActivity)
        }
        binding.btnPickGame.setOnClickListener {
            secondActivity = Intent(this , LetterActivity::class.java).apply {
                putExtra("PreActivity" , 3)
            }
            startActivity(secondActivity)
        }
    }
}