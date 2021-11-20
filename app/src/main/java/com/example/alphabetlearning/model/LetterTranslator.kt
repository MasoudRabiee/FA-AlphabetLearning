package com.example.alphabetlearning.model

class LetterTranslator(var letter: Char) {
    lateinit var letterImage : String

    init {
        setLetterImage(letter)
    }

    private fun setLetterImage(letter: Char) {
        letterImage = when(letter){
            'آ' -> "ic_alef"
            'ب'-> "ic_be"
            'پ'-> "ic_pe"
            'ت'-> "ic_te"
            'ث'-> "ic_se"
            'ج'-> "ic_jim"
            'چ'-> "ic_che"
            'ح'-> "ic_he"
            'خ'-> "ic_khe"
            'د'-> "ic_dal"
            'ذ'-> "ic_zal"
            'ر'-> "ic_re"
            'ز'-> "ic_ze"
            'ژ'-> "ic_zhe"
            'س'-> "ic_sin"
            'ش'-> "ic_shin"
            'ص'-> "ic_sad"
            'ض'-> "ic_zad"
            'ط'-> "ic_ta"
            'ظ'-> "ic_za"
            'ع'-> "ic_eyn"
            'غ'-> "ic_ghyn"
            'ف'-> "ic_fe"
            'ق'-> "ic_qaf"
            'ک'-> "ic_kaf"
            'گ'-> "ic_gaf"
            'ل'-> "ic_lam"
            'م'-> "ic_mim"
            'ن'-> "ic_noon"
            'و'-> "ic_vav"
            'ه'-> "ic_hedo"
            'ی'-> "ic_ye"
            else -> "null"
        }
    }
}