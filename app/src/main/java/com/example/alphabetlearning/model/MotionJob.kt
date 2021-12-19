package com.example.alphabetlearning.model

import android.widget.ImageButton
import kotlinx.coroutines.*

class MotionJob(private var btn: ImageButton) {

    companion object {
        private var screenWidth: Int = 0
        private var screenHeight: Int = 0

        fun configure(width: Int, height: Int) {
            screenWidth = width
            screenHeight = height
        }
    }

    var jobID: Int = btn.id
    var job: Job = Job()


    fun launchJob() {
        job = GlobalScope.launch(Dispatchers.Main) {
            var xIndex = 1
            var yIndex = 1
            while (true) {
                when {
                    btn.x > screenWidth - btn.width -> xIndex = -1
                    btn.x < 0 -> xIndex = 1
                    btn.y > screenHeight - btn.height -> yIndex = -1
                    btn.y < 0 -> yIndex = 1
                }
                btn.x += xIndex
                btn.y += yIndex
                delay(1)
            }
        }
    }

    fun stopJob() {
        this.job.cancel()
    }
}