package com.example.alphabetlearning.model

class ScreenTool {
    companion object{
        var width = 0f
        var height = 0f

        fun initTool(screenWidth:Int , screenHeight:Int){
            width = screenWidth.toFloat()
            height = screenHeight.toFloat()
        }
    }
}