package com.example.alphabetlearning.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.ArrayList

@Parcelize
class Alphabet(var alphabetLetters: ArrayList<AlphabetLetter>) : Parcelable