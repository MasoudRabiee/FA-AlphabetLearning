package com.example.alphabetlearning.view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.Path
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.alphabetlearning.databinding.ActivityMotionGameBinding
import com.example.alphabetlearning.model.MotionJob
import kotlinx.coroutines.*

class MotionGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMotionGameBinding
    private var width = 0
    private var height = 0
    private var job: Job? = null
    private lateinit var dataMotion: Array<MotionJob>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMotionGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        height = displayMetrics.heightPixels
        width = displayMetrics.widthPixels

        binding.pBarResult.progressTintList = ColorStateList.valueOf(Color.CYAN)

        startAction(binding.pBarResult)

        val imageView = binding.imageHadaf
        val xSize = imageView.x
        val ySize = height - imageView.y
        val text = binding.textView

        MotionJob.configure(width, height)
        val zalo = MotionJob(binding.btnWrong)
        val dalo = MotionJob(binding.btnCorrect)

        dataMotion = arrayOf(
            zalo, dalo
        )

        startMotion(dataMotion)
        binding.btnWrong.setOnClickListener {
            if (text.text == binding.btnWrong.text) {
                zalo.job.cancel()
            }
        }
        binding.btnCorrect.setOnClickListener {
            if (text.text == binding.btnCorrect.text) {
                dalo.job.cancel()
                animatePath(binding.btnCorrect, xSize, ySize)
                binding.pBarResult.progress += 12
                reviveButton(binding.btnCorrect)
                createNewButton(binding.constraintGames)
                dalo.launchJob()
            }
        }


    }

    private fun startAction(prgBar: ProgressBar) {
        GlobalScope.launch(Dispatchers.Main) {
            while (true) {
                when {
                    prgBar.progress < 25 -> prgBar.progressDrawable.colorFilter =
                        BlendModeColorFilter(Color.RED, BlendMode.SRC_IN)
                    prgBar.progress in 25..50 -> prgBar.progressDrawable.colorFilter =
                        BlendModeColorFilter(Color.argb(255, 255, 242, 0), BlendMode.SRC_IN)
                    prgBar.progress == 100 -> {
                        Toast.makeText(this@MotionGameActivity, "ez pz", Toast.LENGTH_SHORT).show()
                        cancel()
                    }
                    else -> prgBar.progressDrawable.colorFilter =
                        BlendModeColorFilter(Color.argb(255, 30, 150, 0), BlendMode.SRC_IN)
                }
                delay(1000)
            }

        }
    }

    private fun startMotion(data: Array<MotionJob>) {
        data.forEach {
            it.launchJob()
        }
    }

    private fun createNewButton(cons : ConstraintLayout) {
        val button = Button(this)
        button.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        button.text = "Click"
        button.x = (100..width).random().toFloat()
        button.y = (100..height).random().toFloat()
        button.setOnClickListener {
            button.text = "You just clicked me"
        }
        button.setBackgroundColor(Color.GREEN)
        button.setTextColor(Color.RED)
        cons.addView(button)
        val newJob = MotionJob(button).apply {
            launchJob()
        }
    }

    private fun reviveButton(button: Button) {
        GlobalScope.launch(Dispatchers.Main) {
            delay(1500)
            val randomX = (100..width).random()
            val randomY = (100..height).random()
            val newPath = Path().apply {
                moveTo(randomX.toFloat(), randomY.toFloat())
            }
            val transferObj = ObjectAnimator.ofFloat(button, View.X, View.Y, newPath)
            val fadeObj = ObjectAnimator.ofFloat(button, "alpha", 0f, 1f)
            AnimatorSet().apply {
                playTogether(transferObj, fadeObj)
                duration = 2000
                start()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        dataMotion.forEach {
            it.job.cancel()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    private fun animatePath(button: Button, width: Float, height: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val path = Path().apply {
                moveTo(button.x, button.y)
                lineTo(width, height)
            }
            val animationSet = AnimatorSet()

            val animator = ObjectAnimator.ofFloat(button, View.X, View.Y, path)
            val animator2 = ObjectAnimator.ofFloat(button, "alpha", 1f, 0f)
            animationSet.apply {
                playTogether(animator, animator2)
                duration = 1500L
                start()
            }
        } else {
            // Create animator without using curved path
        }


    }

    private fun setup(hello: Button) {
        job = GlobalScope.launch(Dispatchers.Main) {
            val buttonWidth = hello.width
            val buttonHeight = hello.height
            var xIndex = 1
            var yIndex = 1
            while (true) {
                when {
                    hello.x > width - buttonWidth -> xIndex = -1
                    hello.x < 0 -> xIndex = 1
                    hello.y > height - buttonHeight -> yIndex = -1
                    hello.y < 0 -> yIndex = 1
                }
                hello.x += xIndex
                hello.y += yIndex
                delay(1)
            }
        }
    }
}
