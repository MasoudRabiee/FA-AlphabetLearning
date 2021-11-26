package com.example.alphabetlearning.model

class LetterTranslator(var letter: Char, index: Int, count: Int) {
    lateinit var letterImage: String
    var isDrop: Boolean = false
    private var difference = count - index

    init {
        setLetterImage(letter)
    }

    private fun setLetterImage(letter: Char) {
        letterImage = when (letter) {
            'آ' -> "ic_alef"
            'ا' -> "ic_alef_k"
            'ب' -> if (difference == 1) {
                "ic_be"
            } else {
                "ic_be_k"
            }
            'پ' -> if (difference == 1) {
                "ic_pe_b"
            } else {
                "ic_pe_k"
            }
            'ت' -> if (difference == 1) {
                "ic_te_b"
            } else {
                "ic_te_k"
            }
            'ث' -> if (difference == 1) {
                "ic_se_b"
            } else {
                "ic_se_k"
            }
            'ج' -> if (difference == 1) {
                "ic_jim_b"
            } else {
                "ic_jim_k"
            }
            'چ' -> if (difference == 1) {
                "ic_che_b"
            } else {
                "ic_che_k"
            }
            'ح' -> if (difference == 1) {
                "ic_he_b"
            } else {
                "ic_he_k"
            }
            'خ' -> if (difference == 1) {
                "ic_khe_b"
            } else {
                "ic_khe_k"
            }
            'د' -> "ic_dal"
            'ذ' -> "ic_zal"
            'ر' -> "ic_re"
            'ز' -> "ic_ze"
            'ژ' -> "ic_zhe"
            'س' -> if (difference == 1) {
                "ic_sin_b"
            } else {
                "ic_sin_k"
            }
            'ش' -> if (difference == 1) {
                "ic_shin_b"
            } else {
                "ic_shin_k"
            }
            'ص' -> if (difference == 1) {
                "ic_sad_b"
            } else {
                "ic_sad_k"
            }
            'ض' -> if (difference == 1) {
                "ic_zad_b"
            } else {
                "ic_zad_k"
            }
            'ط' -> "ic_ta"
            'ظ' -> "ic_za"
            'ع' -> if (difference == 1) {
                "ic_eyn_b"
            } else {
                "ic_eyn_k"
            }
            'غ' -> if (difference == 1) {
                "ic_ghyn_b"
            } else {
                "ic_ghyn_k"
            }
            'ف' -> if (difference == 1) {
                "ic_fe_b"
            } else {
                "ic_fe_k"
            }
            'ق' -> if (difference == 1) {
                "ic_qaf_b"
            } else {
                "ic_qaf_k"
            }
            'ک' -> if (difference == 1) {
                "ic_kaf_b"
            } else {
                "ic_kaf_k"
            }
            'گ' -> if (difference == 1) {
                "ic_gaf_b"
            } else {
                "ic_gaf_k"
            }
            'ل' -> if (difference == 1) {
                "ic_le_b"
            } else {
                "ic_le_k"
            }
            'م' -> if (difference == 1) {
                "ic_mim_b"
            } else {
                "ic_mim_k"
            }
            'ن' -> if (difference == 1) {
                "ic_noon_b"
            } else {
                "ic_noon_k"
            }
            'و' -> "ic_vav"
            'ه' -> if (difference == 1) {
                "ic_hedo_b"
            } else {
                "ic_hedo_k"
            }
            'ی' -> if (difference == 1) {
                "ic_ye_b"
            } else {
                "ic_ye_k"
            }
            else -> "null"
        }
    }
}