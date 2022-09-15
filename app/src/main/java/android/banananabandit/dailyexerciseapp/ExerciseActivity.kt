package android.banananabandit.dailyexerciseapp

import android.banananabandit.dailyexerciseapp.databinding.ActivityExerciseBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ExerciseActivity : AppCompatActivity() {
    private lateinit var binding : ActivityExerciseBinding

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

    }
}