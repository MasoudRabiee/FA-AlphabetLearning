package com.example.alphabetlearning.data

import com.example.alphabetlearning.model.Alphabet
import com.example.alphabetlearning.model.AlphabetLetter

object DataAlphabet {
    private val AL = arrayListOf<AlphabetLetter>(
        DataAlphabetLetter.ALEF , DataAlphabetLetter.ALEF , DataAlphabetLetter.ALEF , DataAlphabetLetter.ALEF
    )
    val farsiAlphabet = Alphabet(AL)
}