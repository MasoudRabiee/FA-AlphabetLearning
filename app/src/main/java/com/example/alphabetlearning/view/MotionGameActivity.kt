package com.example.alphabetlearning.view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Path
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.example.alphabetlearning.R
import com.example.alphabetlearning.data.DataPersianLetter
import com.example.alphabetlearning.databinding.ActivityMotionGameBinding
import com.example.alphabetlearning.model.MotionJob
import kotlinx.coroutines.*

class MotionGameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMotionGameBinding
    private var width = 0
    private var height = 0
    private var xSize = 0f
    private var ySize = 0f
    private lateinit var nameLetter: String
    private var resFlag = true
    private lateinit var dataMotion: Array<MotionJob>
    private lateinit var alertShow: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMotionGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        height = displayMetrics.heightPixels
        width = displayMetrics.widthPixels

        nameLetter = intent.extras?.getString("id") as String
        binding.btnCorrect.text = nameLetter
        binding.btnWrong.text = randomLetter(nameLetter)
        binding.btnCorrect.setBackgroundColor(randomColor())
        binding.btnWrong.setBackgroundColor(randomColor())
        binding.textView.text = nameLetter

        binding.pBarResult.progressTintList = ColorStateList.valueOf(Color.CYAN)

        val builder = AlertDialog.Builder(this)
        builder.setView(View.inflate(this, R.layout.fragment_success, null))
            .setNegativeButton(
                R.string.back
            ) { dialog, _ ->
                dialog.cancel()
                finish()
            }
            .setPositiveButton(
                R.string.retry
            ) { dialog, _ ->
                dialog.cancel()
                val backActivity = Intent(this , MotionGameActivity::class.java).apply {
                    putExtra("id" , nameLetter)
                }
                startActivity(backActivity)
                finish()
            }
        alertShow = builder.create()

        startAction(binding.pBarResult)

        xSize = binding.imageHadaf.x
        ySize = height - binding.imageHadaf.y

        MotionJob.configure(width, height)
        val firstJob = MotionJob(binding.btnWrong)
        val secondJob = MotionJob(binding.btnCorrect)

        dataMotion = arrayOf(
            firstJob, secondJob
        )

        startMotion(dataMotion)
        binding.btnWrong.setOnClickListener {
            checkCorrectPick(binding.btnWrong , firstJob)
        }
        binding.btnCorrect.setOnClickListener {
            checkCorrectPick(binding.btnCorrect , secondJob)
        }
    }

    private fun startAction(prgBar: ProgressBar) {
        GlobalScope.launch(Dispatchers.Main) {
            while (true) {
                when {
                    prgBar.progress < 25 -> prgBar.progressDrawable.colorFilter =
                        BlendModeColorFilterCompat.createBlendModeColorFilterCompat(Color.RED, BlendModeCompat.SRC_IN)
                    prgBar.progress in 25..50 -> prgBar.progressDrawable.colorFilter =
                        BlendModeColorFilterCompat.createBlendModeColorFilterCompat(Color.argb(255, 255, 242, 0), BlendModeCompat.SRC_IN)
                    prgBar.progress == 100 -> {
                        alertShow.show()
                        cancel()
                    }
                    else -> prgBar.progressDrawable.colorFilter =
                        BlendModeColorFilterCompat.createBlendModeColorFilterCompat(Color.argb(255, 30, 150, 0), BlendModeCompat.SRC_IN)
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

    private fun checkCorrectPick(button: Button , job: MotionJob) {
        if (nameLetter == button.text) {
            job.job.cancel()
            animatePath(button, xSize, ySize)
            binding.pBarResult.progress += 12
            reviveButton(button)
            createNewButton(binding.constraintGames)
            job.launchJob()
        }
    }

    private fun createNewButton(cons: ConstraintLayout) {
        val button = Button(this)
        button.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        button.x = (100..width).random().toFloat()
        button.y = (100..height).random().toFloat()
        button.setBackgroundColor(randomColor())
        button.textSize = 30f
        button.setTextColor(Color.WHITE)
        if (resFlag) {
            button.text = randomLetter(nameLetter)
        } else {
            button.text = nameLetter
            resFlag = true
        }
        val newJob = MotionJob(button).apply {
            launchJob()
        }
        cons.addView(button)
        button.setOnClickListener {
            checkCorrectPick(button , newJob)
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
            button.setBackgroundColor(randomColor())
            if (resFlag) {
                button.text = randomLetter(nameLetter)
            } else {
                button.text = nameLetter
                resFlag = true
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

    private fun randomColor(): Int {
        val colors = arrayListOf(
            Color.rgb(246, 79, 89),
            Color.rgb(249, 83, 198),
            Color.rgb(18, 194, 233),
            Color.rgb(56, 239, 125)
        )
        return colors.random()
    }

    private fun getSomeLetter(deleteLetter: String): List<String> {
        val letters = DataPersianLetter.LETTER.apply {
            remove(deleteLetter)
            shuffle()
        }
        return letters.slice(0..3)
    }

    private fun randomLetter(nameLetter: String): String {
        val letters = getSomeLetter(nameLetter).toMutableList().apply {
            for (i in 0..3)
                add(nameLetter)
        }
        val result = letters.random()
        if (result != nameLetter) {
            resFlag = false
        }
        return result
    }
}
