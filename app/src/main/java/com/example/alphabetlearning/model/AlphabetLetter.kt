package com.example.alphabetlearning.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlphabetLetter(var letter: String, var capitalShape: SkeletonShape, var smallShape: SkeletonShape, var imageName: String) : Parcelable {
    fun totalPath(): Int {
        return this.capitalShape.pathRequireCount() + this.smallShape.pathRequireCount()
    }
}