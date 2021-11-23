package com.example.alphabetlearning.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.alphabetlearning.adapter.BlankRecyclerAdapter
import com.example.alphabetlearning.adapter.PicLetterAdapter
import com.example.alphabetlearning.data.DataPuzzle
import com.example.alphabetlearning.databinding.ActivityPuzzleBinding
import com.example.alphabetlearning.model.LetterTranslator

class PuzzleActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPuzzleBinding
    private lateinit var blankAdapter : BlankRecyclerAdapter
    private lateinit var picAdapter : PicLetterAdapter
    private lateinit var dataTranslators : Array<LetterTranslator>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_puzzle)
        binding = ActivityPuzzleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = DataPuzzle.temp

        val dataImageRes = data.splitName()
        val dataImageCount = dataImageRes.count()
        dataTranslators = Array(dataImageCount){
            LetterTranslator(dataImageRes[it] , it , dataImageCount)
        }

        dataTranslators.toMutableList().shuffle()

        blankAdapter = BlankRecyclerAdapter(this , dataTranslators)
        val numOfCols = dataImageRes.count()
        binding.recyclerBlank.run {
            adapter = blankAdapter
            layoutManager = GridLayoutManager(this@PuzzleActivity , numOfCols)
            setHasFixedSize(true)
        }

        val randomDataTranslator = dataTranslators.toMutableList()
        randomDataTranslator.shuffle()

        picAdapter = PicLetterAdapter(this , randomDataTranslator)
        binding.recyclerLetter.run {
            adapter = picAdapter
            layoutManager = GridLayoutManager(this@PuzzleActivity , numOfCols)
            setHasFixedSize(true)
        }
        
    }
}