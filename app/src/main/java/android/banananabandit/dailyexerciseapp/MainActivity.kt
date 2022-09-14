package android.banananabandit.dailyexerciseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frameLayoutStartButton : FrameLayout = findViewById(R.id.frame_layout_start)

        frameLayoutStartButton.setOnClickListener {
            Toast.makeText(this, "press", Toast.LENGTH_SHORT).show()
        }
    }
}