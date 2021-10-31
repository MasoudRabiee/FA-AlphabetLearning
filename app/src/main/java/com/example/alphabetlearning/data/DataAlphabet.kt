package com.example.alphabetlearning.data

import com.example.alphabetlearning.model.Alphabet
import com.example.alphabetlearning.model.AlphabetLetter

object DataAlphabet {
    private val AL = arrayListOf<AlphabetLetter>(
        DataAlphabetLetter.ALEF , DataAlphabetLetter.BE , DataAlphabetLetter.PE , DataAlphabetLetter.TE , DataAlphabetLetter.SE,
        DataAlphabetLetter.JIM , DataAlphabetLetter.CHE , DataAlphabetLetter.HE , DataAlphabetLetter.KHE , DataAlphabetLetter.DAL,
        DataAlphabetLetter.ZAL , DataAlphabetLetter.RE , DataAlphabetLetter.ZE , DataAlphabetLetter.ZHE , DataAlphabetLetter.SIN,
        DataAlphabetLetter.SHIN , DataAlphabetLetter.SAD , DataAlphabetLetter.ZAD , DataAlphabetLetter.TA , DataAlphabetLetter.ZA,
        DataAlphabetLetter.EYN , DataAlphabetLetter.GHYN , DataAlphabetLetter.FE , DataAlphabetLetter.QAF , DataAlphabetLetter.KAF,
        DataAlphabetLetter.GAF , DataAlphabetLetter.LAM , DataAlphabetLetter.MIM , DataAlphabetLetter.NOON , DataAlphabetLetter.VAV,
        DataAlphabetLetter.HEdo , DataAlphabetLetter.YE
    )
    val farsiAlphabet = Alphabet(AL)
}