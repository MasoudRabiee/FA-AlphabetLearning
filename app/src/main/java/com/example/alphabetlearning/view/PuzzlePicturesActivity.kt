package com.example.alphabetlearning.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alphabetlearning.adapter.PicListAdapter
import com.example.alphabetlearning.data.DataPuzzle
import com.example.alphabetlearning.databinding.ActivityPuzzlePicturesBinding

class PuzzlePicturesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPuzzlePicturesBinding
    private lateinit var adapter: PicListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_puzzle_pictures)
        binding = ActivityPuzzlePicturesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = DataPuzzle.data
        adapter = PicListAdapter(this , data)
        val numOfCols = 3
        binding.recyclerPictures.adapter = adapter
        binding.recyclerPictures.layoutManager = GridLayoutManager(this , numOfCols)
        binding.recyclerPictures.setHasFixedSize(true)

    }
}