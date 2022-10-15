package android.banananabandit.dailyexerciseapp

import android.banananabandit.dailyexerciseapp.databinding.ActivityFinishBinding
import android.banananabandit.dailyexerciseapp.room.DateApp
import android.banananabandit.dailyexerciseapp.room.HistoryDao
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FinishActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarFinishActivity)

        // This is how we get the DAO
        val historyDao = (application as DateApp).db.getHistoryDao()

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

    private fun addDateToHistory(historyDao: HistoryDao) {

    }

}