package com.lachlanvass.sit305quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Conclusion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conclusion)

        val totalScore = intent.getIntExtra("TOTAL_SCORE", 0)

        val scoreDisplay = findViewById<TextView>(R.id.score_display)
        scoreDisplay.text = "$totalScore / 5"
    }
}