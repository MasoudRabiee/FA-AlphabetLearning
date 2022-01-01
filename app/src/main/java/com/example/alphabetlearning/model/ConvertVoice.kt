package com.example.alphabetlearning.model

import com.example.alphabetlearning.R

class ConvertVoice(alphabetLetter: Char) {
    var voiceId = 0
    init {
        setVoiceId(alphabetLetter)
    }

    private fun setVoiceId(alphabetLetter: Char) {
        voiceId = when(alphabetLetter){
            'آ' -> R.raw.valef
            'ا' -> R.raw.valef
            'ب' -> R.raw.vbe
            'پ' -> R.raw.vpe
            'ت' -> R.raw.vte
            'ث' -> R.raw.vse
            'ج' -> R.raw.vjim
            'چ' -> R.raw.vche
            'ح' -> R.raw.vhe
            'خ' -> R.raw.vkhe
            'د' -> R.raw.vdal
            'ذ' -> R.raw.vzal
            'ر' -> R.raw.vre
            'ز' -> R.raw.vze
            'ژ' -> R.raw.vzhe
            'س' -> R.raw.vsin
            'ش' -> R.raw.vshin
            'ص' -> R.raw.vsad
            'ض' -> R.raw.vzad
            'ط' -> R.raw.vta
            'ظ' -> R.raw.vza
            'ع' -> R.raw.veyn
            'غ' -> R.raw.vghayn
            'ف' -> R.raw.vfe
            'ق' -> R.raw.vqaf
            'ک' -> R.raw.vkaf
            'گ' -> R.raw.vgaf
            'ل' -> R.raw.vlam
            'م' -> R.raw.vmim
            'ن' -> R.raw.vnoon
            'و' -> R.raw.vvav
            'ه' -> R.raw.vhedo
            'ی' -> R.raw.vye
            else -> -1
        }
    }
}