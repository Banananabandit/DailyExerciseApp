package android.banananabandit.dailyexerciseapp

import android.banananabandit.dailyexerciseapp.databinding.ActivityExerciseBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast

class ExerciseActivity : AppCompatActivity() {
    private lateinit var binding : ActivityExerciseBinding

    private var restTimer : CountDownTimer? = null
    private var restProgress = 0

    // Most likely I will not need this functionality in my version of the app
    private var exerciseTimer : CountDownTimer? = null
    private var exerciseProgress = 0

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

    private fun setRestProgressBar() {
//        binding.progressBar.progress = restProgress
        restTimer = object : CountDownTimer(25000, 1000) {
            override fun onTick(p0: Long) {
                restProgress++
                binding.progressBar.progress = 25 - restProgress
                binding.restTimer.text = (25 - restProgress).toString()
            }

            override fun onFinish() {
                setUpExerciseView()
            }

        }.start()
    }

    //Most likely not going to need this functionality for my version of the app
    private fun setExerciseProgressBar() {
        binding.progressBarExercise.progress = exerciseProgress
        exerciseTimer = object : CountDownTimer(25000, 1000) {
            override fun onTick(p0: Long) {
                exerciseProgress++
                binding.progressBarExercise.progress = 25 - exerciseProgress
                binding.exerciseTimer.text = (25 - exerciseProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@ExerciseActivity, "Exercise is finished", Toast.LENGTH_SHORT).show()
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
    private fun setUpExerciseView() {
        binding.progressBar.visibility = View.INVISIBLE
        binding.exerciseName.text = "Exercise name here"
        binding.frameLayoutExercise.visibility = View.VISIBLE

        if (exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }

        setExerciseProgressBar()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }
        if (exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
        //Set binding to null if we make it nullable
    }
}