package com.lachlanvass.sit305quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class QuizQuestionOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question_one)

        val questionOne = Question(
            "What Operating System are you using?",
            "There are many handheld operating systems in the world",
            "IOS",
            "Windows",
            "Android"

        )

        val questionTitle = findViewById<TextView>(R.id.question_title)
        val questionDetails = findViewById<TextView>(R.id.question_details)

        questionTitle.text = questionOne.questionTitle
        questionDetails.text = questionOne.questionDetails


    }
}