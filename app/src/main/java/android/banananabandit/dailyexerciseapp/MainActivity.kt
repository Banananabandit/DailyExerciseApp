package android.banananabandit.dailyexerciseapp

import android.banananabandit.dailyexerciseapp.databinding.ActivityMainBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.frameLayoutStart.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        // how much code is reduced through viewBinding
//        val frameLayoutStartButton : FrameLayout = findViewById(R.id.frame_layout_start)
//        frameLayoutStartButton.setOnClickListener {
//            Toast.makeText(this, "press", Toast.LENGTH_SHORT).show()
//        }
    }

}