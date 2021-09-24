package com.example.alphabetlearning.data

import com.example.alphabetlearning.model.AlphabetLetter
import java.io.Serializable

object DataAlphabetLetter : Serializable {
    val ALEF = AlphabetLetter("آ", DataSkeleton.ALEF_Skeleton_Cap, DataSkeleton.ALEF_Skeleton_Sm, "alpha")
    val BE = AlphabetLetter("ب", DataSkeleton.BE_Skeleton_Cap, DataSkeleton.BE_Skeleton_Sm, "be")
    val PE = AlphabetLetter("پ", DataSkeleton.PE_Skeleton_Cap, DataSkeleton.PE_Skeleton_Sm, "pe")
    val TE = AlphabetLetter("ت", DataSkeleton.TE_Skeleton_Cap, DataSkeleton.TE_Skeleton_Sm, "te")
    val SE = AlphabetLetter("ث", DataSkeleton.SE_Skeleton_Cap, DataSkeleton.SE_Skeleton_Sm, "se")
    val JIM = AlphabetLetter("ج", DataSkeleton.JIM_Skeleton_Cap, DataSkeleton.JIM_Skeleton_Sm, "jim")
    val CHE = AlphabetLetter("چ", DataSkeleton.Che_Skeleton_Cap, DataSkeleton.Che_Skeleton_Sm, "che")
    val HE = AlphabetLetter("ح", DataSkeleton.HE_Skeleton_Cap, DataSkeleton.HE_Skeleton_Sm, "he")
    val KHE = AlphabetLetter("خ", DataSkeleton.KHE_Skeleton_Cap, DataSkeleton.KHE_Skeleton_Sm, "khe")
    val DAL = AlphabetLetter("د", DataSkeleton.DAL_Skeleton_Cap, DataSkeleton.DAL_Skeleton_Sm, "dal")
    val ZAL = AlphabetLetter("ذ", DataSkeleton.ZAL_Skeleton_Cap, DataSkeleton.ZAL_Skeleton_Sm, "zal")


}