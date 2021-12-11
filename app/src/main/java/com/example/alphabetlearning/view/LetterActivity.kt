package com.example.alphabetlearning.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.alphabetlearning.adapter.LetterRecyclerAdapter
import com.example.alphabetlearning.data.DataAlphabet
import com.example.alphabetlearning.databinding.ActivityLetterBinding
import com.example.alphabetlearning.model.Alphabet

class LetterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLetterBinding
    private lateinit var adapter: LetterRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_letter)

        binding = ActivityLetterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val alphabet = DataAlphabet.farsiAlphabet
        var flag = 1
        if (intent.extras != null){
            flag = intent.extras?.getInt("PreActivity") as Int
        }

        adapter = LetterRecyclerAdapter(this, alphabet.alphabetLetters, flag)
        val numOfCols = 3
        val layoutManager = GridLayoutManager(this, numOfCols)
        binding.recyclerLetter.adapter = adapter
        binding.recyclerLetter.layoutManager = layoutManager
        binding.recyclerLetter.setHasFixedSize(true)


    }
}