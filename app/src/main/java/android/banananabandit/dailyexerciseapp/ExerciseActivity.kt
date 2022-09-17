package android.banananabandit.dailyexerciseapp

import android.banananabandit.dailyexerciseapp.databinding.ActivityExerciseBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast

class ExerciseActivity : AppCompatActivity() {
    private lateinit var binding : ActivityExerciseBinding

    // 1.
    private var restTimer : CountDownTimer? = null
    private var restProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.exerciseActionBar)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }


        binding.exerciseActionBar.setNavigationOnClickListener {
            onBackPressed()
        }
        setUpRestView()

    }

    // 2. Add a couple of methods
    private fun setRestProgressBar() {
        binding.progressBar.progress = restProgress
        restTimer = object : CountDownTimer(25000, 1000) {
            override fun onTick(p0: Long) {
                restProgress++
                binding.progressBar.progress = 25 - restProgress
                binding.timer.text = (25 - restProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@ExerciseActivity, "Wooba", Toast.LENGTH_SHORT).show()
            }

        }.start()
    }

    private fun setUpRestView() {
        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }
        setRestProgressBar()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }
        //Set binding to null if we make it nullable
    }
}