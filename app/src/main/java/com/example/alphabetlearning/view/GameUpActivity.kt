package com.example.alphabetlearning.view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Path
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.example.alphabetlearning.R
import com.example.alphabetlearning.data.DataPersianLetter
import com.example.alphabetlearning.databinding.ActivityGameUpBinding
import com.example.alphabetlearning.model.ConvertVoice
import com.example.alphabetlearning.model.LetterTranslator
import kotlinx.coroutines.*

class GameUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameUpBinding
    private var _width = 0
    private var _height = 0
    private var flag = false
    private lateinit var nameLetter: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_game_up)
        binding = ActivityGameUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        _height = displayMetrics.heightPixels
        _width = displayMetrics.widthPixels

        nameLetter = intent.extras?.getString("id") as String
        val key = setResID(this , nameLetter[0]).toString()
        val alertShow = createBuilder(this).create()

        binding.pBarUpResult.progressTintList = ColorStateList.valueOf(Color.CYAN)
        val viewArray = arrayListOf<View>(binding.imageButtonFirst, binding.imageButtonSecond, binding.imageButtonMain)

        startAction(binding.pBarUpResult, alertShow)
        configureContentButtons(binding, this)

        binding.imageButtonMain.setOnClickListener {
            if (flag) {
                if (it.contentDescription == key){
                    startGameUp(this, it, binding.imageAstronaut, nameLetter[0], viewArray)
                    binding.pBarUpResult.progress += 10
                }
                else {
                    playSound('N')
                    Toast.makeText(this , "اشتباه کردی ! دوباره تلاش کن" , Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.imageButtonFirst.setOnClickListener {
            if (it.contentDescription == key){
                startGameUp(this, it, binding.imageAstronaut, nameLetter[0], viewArray)
                binding.pBarUpResult.progress += 10
            }
            else {
                playSound('N')
                Toast.makeText(this , "اشتباه کردی ! دوباره تلاش کن" , Toast.LENGTH_SHORT).show()
            }
        }
        binding.imageButtonSecond.setOnClickListener {
            if (it.contentDescription == key){
                startGameUp(this, it, binding.imageAstronaut, nameLetter[0], viewArray)
                binding.pBarUpResult.progress += 10
            }
            else {
                playSound('N')
                Toast.makeText(this , "اشتباه کردی ! دوباره تلاش کن" , Toast.LENGTH_SHORT).show()
            }
        }
        binding.imgbtnBack.setOnClickListener {
            finish()
        }
    }

    private fun configureContentButtons(binding: ActivityGameUpBinding, context: Context) {
        binding.imageButtonMain.apply {
            val resId = setResID(context, nameLetter[0])
            setImageResource(resId)
            contentDescription = resId.toString()
        }
        binding.imageButtonFirst.apply {
            val resId = setResID(context, nameLetter[0])
            setImageResource(resId)
            contentDescription = resId.toString()
        }
        binding.imageButtonSecond.apply {
            val resId = setResID(context, getRandomLetter())
            setImageResource(resId)
            contentDescription = resId.toString()
        }
    }

    private fun createBuilder(context: Context): AlertDialog.Builder {
        val builder = AlertDialog.Builder(context)
        builder.setView(View.inflate(context, R.layout.fragment_success, null))
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
                val backActivity = Intent(context, GameUpActivity::class.java).apply {
                    putExtra("id", nameLetter)
                }
                startActivity(backActivity)
                finish()
            }
        return builder
    }

    private fun startAction(prgBar: ProgressBar, alertShow: AlertDialog) {
        GlobalScope.launch(Dispatchers.Main) {
            while (true) {
                when {
                    prgBar.progress < 25 -> prgBar.progressDrawable.colorFilter =
                        BlendModeColorFilterCompat.createBlendModeColorFilterCompat(Color.RED, BlendModeCompat.SRC_IN)
                    prgBar.progress in 25..50 -> prgBar.progressDrawable.colorFilter =
                        BlendModeColorFilterCompat.createBlendModeColorFilterCompat(Color.argb(255, 255, 242, 0), BlendModeCompat.SRC_IN)
                    prgBar.progress == 100 -> {
                        alertShow.show()
                        playSound('Y')
                        cancel()
                    }
                    else -> prgBar.progressDrawable.colorFilter =
                        BlendModeColorFilterCompat.createBlendModeColorFilterCompat(Color.argb(255, 30, 150, 0), BlendModeCompat.SRC_IN)
                }
                delay(1000)
            }

        }
    }

    private fun startGameUp(context: Context, it: View, rockImage: ImageView, desChar: Char, array: ArrayList<View>) {
        flag = true
        playSound(nameLetter[0])
        animatePath(rockImage, it.x, it.y - (it.height * 1.1f))
        fadeOtherView(array, it)
        backAnimate(it, rockImage, _width, _height)
        reviveViews(context, desChar, array, it)
    }

    private fun playSound(alphabetLetter: Char) {
        when(alphabetLetter){
            'N' -> MediaPlayer.create(this , R.raw.vretry).start()
            'Y' -> MediaPlayer.create(this , R.raw.vafarin).start()
            else -> {
                val letterSound = ConvertVoice(alphabetLetter).voiceId
                MediaPlayer.create(this , letterSound).start()
            }
        }
    }

    private fun reviveViews(context: Context, charLetter: Char, viewArray: ArrayList<View>, noReviveView: View) {
        GlobalScope.launch(Dispatchers.Main) {
            delay(3500)
            var resId: Int
            var index = 0
            val charArr = arrayListOf(charLetter, getRandomLetter()).apply { shuffle() }
            val path = Path()
            var w = _width * 9f / 20
            val h = _height * 2.2f / 5
            val h2 = _height * 1.7f / 5
            viewArray.forEach {
                if (noReviveView.id != it.id) {
                    delay(650)
                    path.apply {
                        moveTo(_width.toFloat(), h2)
                        lineTo(w, h)
                    }
                    val ib = it as ImageButton
                    resId = setResID(context, charArr[index])
                    ib.setImageResource(resId)
                    ib.contentDescription = resId.toString()
                    it.visibility = View.VISIBLE
                    val anim1 = ObjectAnimator.ofFloat(it, View.X, View.Y, path)
                    val anim2 = ObjectAnimator.ofFloat(it, "alpha", 0f, 1f)
                    AnimatorSet().apply {
                        playTogether(anim1, anim2)
                        duration = 1000
                        start()
                    }
                    w += _width * 2.5f / 10
                    index++
                    path.reset()
                }
            }
        }
    }

    private fun fadeOtherView(viewArray: ArrayList<View>, noAnimView: View) {
        GlobalScope.launch(Dispatchers.Main) {
            delay(1500)
            viewArray.forEach {
                if (noAnimView.id != it.id) {
                    ObjectAnimator.ofFloat(it, "alpha", 1f, 0f).apply {
                        duration = 500
                        start()
                    }
                    it.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun backAnimate(
        button: View,
        imageView: ImageView,
        width: Int,
        height: Int
    ) {
        GlobalScope.launch(Dispatchers.Main) {
            delay(2000)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val pathBtn = Path().apply {
                    moveTo(button.x, button.y)
                    lineTo(width * 3f / 20, height * 2.75f / 5)
                }
                val pathImg = Path().apply {
                    moveTo(imageView.x, imageView.y)
                    lineTo(width * 3.1f / 20, (height * 2.75f / 5.1f) - imageView.height)
                }
                val animationSet = AnimatorSet()

                val animatorImg = ObjectAnimator.ofFloat(imageView, View.X, View.Y, pathImg)
                val animatorBtn = ObjectAnimator.ofFloat(button, View.X, View.Y, pathBtn)
                animationSet.apply {
                    playTogether(animatorImg, animatorBtn)
                    duration = 1500L
                    start()
                }
            } else {
                // Create animator without using curved path
            }
        }

    }

    private fun animatePath(imageView: ImageView, width: Float, height: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val path = Path().apply {
                moveTo(imageView.x, imageView.y)
//                lineTo(width, height)
                cubicTo(
                    imageView.x,
                    imageView.y,
                    _width * 2f / 10,
                    _height * 2f / 10,
                    width,
                    height
                )
            }
            val animationSet = AnimatorSet()

            val animator = ObjectAnimator.ofFloat(imageView, View.X, View.Y, path)
            animationSet.apply {
                playTogether(animator)
                duration = 1500L
                start()
            }
        } else {
            // Create animator without using curved path
        }
    }

    private fun getRandomLetter(): Char {
        val letters = DataPersianLetter.LETTER.apply {
            shuffle()
        }
        return letters[0][0]
    }

    private fun setResID(context: Context, charTranslator: Char): Int {
        val translator = LetterTranslator(charTranslator, 0, 1).letterImage
        return context.resources.getIdentifier(translator, "drawable", context.packageName)
    }
}
