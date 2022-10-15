package android.banananabandit.dailyexerciseapp

import android.banananabandit.dailyexerciseapp.databinding.ActivityFinishBinding
import android.banananabandit.dailyexerciseapp.room.DateApp
import android.banananabandit.dailyexerciseapp.room.HistoryDao
<<<<<<< HEAD
import android.banananabandit.dailyexerciseapp.room.HistoryEntity
=======
>>>>>>> 8a06e9e33bcb29f6b2e0b3e729a613fc9af33d3f
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFinishBinding
    lateinit var date : String
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
        addDateToHistory(historyDao)
        Toast.makeText(applicationContext, "Date added: $date", Toast.LENGTH_SHORT).show()

    }

    private fun addDateToHistory(historyDao: HistoryDao) {
        val c = Calendar.getInstance().time
        // Simple Date Format
        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault())
        date = sdf.format(c)

        lifecycleScope.launch {
            historyDao.insert(HistoryEntity(date))
        }

    }

    private fun addDateToHistory(historyDao: HistoryDao) {

    }

}