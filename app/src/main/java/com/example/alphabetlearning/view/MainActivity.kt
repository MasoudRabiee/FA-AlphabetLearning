package com.example.alphabetlearning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alphabetlearning.data.DataAlphabet
import com.example.alphabetlearning.databinding.ActivityMainBinding
import com.example.alphabetlearning.model.Alphabet

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var secondActivity : Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
    }
}