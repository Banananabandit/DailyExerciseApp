package android.banananabandit.dailyexerciseapp

import android.banananabandit.dailyexerciseapp.databinding.ActivityHistoryBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.historyActionBar)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "HISTORY"
        }


        binding.historyActionBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}