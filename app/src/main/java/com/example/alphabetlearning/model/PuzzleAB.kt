package com.example.alphabetlearning.model

class PuzzleAB(var name : String , var imagePuzzle: String) {

    fun splitName() : Array<Char>{
        return Array<Char>(name.length){
            name[it]
        }
    }
}