package com.example.alphabetlearning.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alphabetlearning.R
import com.example.alphabetlearning.data.DataAlphabet
import com.example.alphabetlearning.databinding.ActivityMainBinding
import com.example.alphabetlearning.model.Alphabet
import com.example.alphabetlearning.model.AlphabetLetter
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var farsiAlphabet : Alphabet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        farsiAlphabet = DataAlphabet.farsiAlphabet
        binding.btnDrawLetter.setOnClickListener {
            val secondActivity = Intent(this , LetterActivity::class.java)
            secondActivity.putExtra("alphabet", farsiAlphabet)
            startActivity(secondActivity)
        }
        binding.btnPuzzle.setOnClickListener {
            val secondActivity = Intent(this , PuzzlePicturesActivity::class.java)
            startActivity(secondActivity)
        }
    }
}