package android.banananabandit.dailyexerciseapp

import android.app.Dialog
import android.banananabandit.dailyexerciseapp.databinding.ActivityExerciseBinding
import android.banananabandit.dailyexerciseapp.databinding.BackNavConfirmationDialogBinding
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.MediaStore
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

class ExerciseActivity : AppCompatActivity() {
    private lateinit var binding : ActivityExerciseBinding

    private var restTimerDuration : Long = 1
    private var exerciseTimerDuration : Long = 1

    private var restTimer : CountDownTimer? = null
    private var restProgress = 0

    private var exerciseTimer : CountDownTimer? = null
    private var exerciseProgress = 0

    private var exerciseList : ArrayList<ExerciseModel>? = null
    private var currentExercise = 0

    private lateinit var player : MediaPlayer

    private lateinit var exerciseAdapter : ExerciseStatusAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exerciseList = Constants.getExercises()

        setSupportActionBar(binding.exerciseActionBar)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }


        binding.exerciseActionBar.setNavigationOnClickListener {
            showBackButtonConfirmationDialog()
        }
        setUpRestView()
        setUpExerciseRecyclerView()

    }

    override fun onBackPressed() {
        showBackButtonConfirmationDialog()
    }

    private fun showBackButtonConfirmationDialog() {
        val customDialog = Dialog(this)
        //data binding to prepare this dialog. We need to use it because this layout is not included in our initial binding duh
        val dialogBinding = BackNavConfirmationDialogBinding.inflate(layoutInflater)
        customDialog.setContentView(dialogBinding.root)
        customDialog.setCanceledOnTouchOutside(false)
        dialogBinding.backConfirmationYes.setOnClickListener {
            this@ExerciseActivity.finish()
            customDialog.dismiss()
        }
        dialogBinding.backConfirmationNo.setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()
    }

    private fun setUpExerciseRecyclerView() {
        binding.exerciseStatus.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        exerciseAdapter = ExerciseStatusAdapter(exerciseList!!)
        binding.exerciseStatus.adapter = exerciseAdapter
    }

    // These two methods are the best places to trigger notify adapter to change the color of the current exercise
    private fun setRestProgressBar() {
        restTimer = object : CountDownTimer(restTimerDuration * 1000, 1000) {
            override fun onTick(p0: Long) {
                restProgress++
                binding.progressBar.progress = 25 - restProgress
                binding.restTimer.text = (25 - restProgress).toString()
            }

            override fun onFinish() {
                exerciseList!![currentExercise].setExerciseSelected(true)
                // using this insetead datasetchanged- which is lazy
                exerciseAdapter.notifyItemChanged(currentExercise)
                setUpExerciseView()
            }

        }.start()
    }

    private fun setExerciseProgressBar() {
        binding.progressBarExercise.progress = exerciseProgress
        exerciseTimer = object : CountDownTimer(exerciseTimerDuration * 1000, 1000) {
            override fun onTick(p0: Long) {
                exerciseProgress++
                binding.progressBarExercise.progress = 25 - exerciseProgress
                binding.exerciseTimer.text = (25 - exerciseProgress).toString()
            }

            override fun onFinish() {

                if (currentExercise < exerciseList?.size!! - 1) {
                    exerciseList!![currentExercise].setExerciseSelected(false)
                    exerciseList!![currentExercise].setExerciseCompleted(true)
                    // using this insetead datasetchanged- which is lazy
                    exerciseAdapter.notifyItemChanged(currentExercise)
                    currentExercise++
                    setUpRestView()
                }else {
                    Toast.makeText(this@ExerciseActivity, "Workout is finished!", Toast.LENGTH_SHORT).show()
                    finish()
                    val intent = Intent(this@ExerciseActivity, FinishActivity::class.java)
                    startActivity(intent)
                }


            }

        }.start()
    }

    private fun setUpRestView() {
        try {
            val soundURI = Uri.parse("android.resource://android.banananabandit.dailyexerciseapp/" + R.raw.fart)
            player = MediaPlayer.create(applicationContext, soundURI)
            player.isLooping = false
            player.start()
        } catch (e : Exception) {
            e.printStackTrace()
        }


        binding.progressBar.visibility = View.VISIBLE
        binding.restText.visibility = View.VISIBLE
        binding.exerciseName.visibility = View.INVISIBLE
        binding.frameLayoutExercise.visibility = View.INVISIBLE
        binding.nextExercise.visibility = View.VISIBLE
        binding.nextExerciseLabel.visibility = View.VISIBLE

        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }
        binding.nextExercise.text = exerciseList!![currentExercise].getName()
        setRestProgressBar()
    }
    private fun setUpExerciseView() {
        binding.progressBar.visibility = View.INVISIBLE
        binding.restText.visibility = View.INVISIBLE
        binding.exerciseName.visibility = View.VISIBLE
        binding.frameLayoutExercise.visibility = View.VISIBLE
        binding.nextExercise.visibility = View.INVISIBLE
        binding.nextExerciseLabel.visibility = View.INVISIBLE

        if (exerciseTimer != null) {
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }

        binding.exerciseName.text = exerciseList!![currentExercise].getName()


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

        player.stop()
    }
}