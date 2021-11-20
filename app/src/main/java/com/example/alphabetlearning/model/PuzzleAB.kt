package com.example.alphabetlearning.model

class PuzzleAB(var imagePuzzle: String ,var name : String) {

    fun splitName() : Array<Char>{
        return Array<Char>(name.length){
            name[it]
        }
    }
}