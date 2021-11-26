package com.example.alphabetlearning.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.alphabetlearning.adapter.BlankRecyclerAdapter
import com.example.alphabetlearning.adapter.PicLetterAdapter
import com.example.alphabetlearning.databinding.ActivityPuzzleBinding
import com.example.alphabetlearning.model.LetterTranslator
import com.example.alphabetlearning.model.PuzzleAB

class PuzzleActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPuzzleBinding
    private lateinit var blankAdapter : BlankRecyclerAdapter
    private lateinit var picAdapter : PicLetterAdapter
    private lateinit var dataTranslators : Array<LetterTranslator>
    private lateinit var dataPuzzle: PuzzleAB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_puzzle)
        binding = ActivityPuzzleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.extras
        if (data != null) {
            dataPuzzle = data.getParcelable<PuzzleAB>("pic") as PuzzleAB
        }
        else{
            Toast.makeText(this , "داده ها دریافت نشدند" , Toast.LENGTH_LONG).show()
        }

        val resourceId = this.resources.getIdentifier(dataPuzzle.imagePuzzle , "drawable" , this.packageName)
        binding.imagePuzzle.setImageResource(resourceId)

        val dataImageRes = dataPuzzle.splitName()
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

        binding.buttonPuzzleBack.setOnClickListener {
            finish()
        }
        
    }
}