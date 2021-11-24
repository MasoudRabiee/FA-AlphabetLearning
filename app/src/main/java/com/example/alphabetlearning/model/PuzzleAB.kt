package com.example.alphabetlearning.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PuzzleAB(var imagePuzzle: String ,var name : String) : Parcelable {

    fun splitName() : Array<Char>{
        return Array<Char>(name.length){
            name[it]
        }
    }
}