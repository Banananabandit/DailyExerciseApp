package android.banananabandit.dailyexerciseapp

import android.banananabandit.dailyexerciseapp.databinding.ActivityFinishBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FinishActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarFinishActivity)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding.toolbarFinishActivity.setOnClickListener {
            onBackPressed()
        }

        binding.buttonFinish.setOnClickListener {
            finish()
        }

    }

}