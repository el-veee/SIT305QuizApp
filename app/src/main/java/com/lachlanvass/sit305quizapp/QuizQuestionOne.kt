package com.lachlanvass.sit305quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton

class QuizQuestionOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question_one)

        val questionOne = Question(

            getString(R.string.question1_title),
            getString(R.string.question1_description),
            getString(R.string.question1_wrong_answer_1),
            getString(R.string.question1_wrong_answer_2),
            getString(R.string.question1_right_answer)
        )

        val questionTitle = findViewById<TextView>(R.id.question_title)
        val questionDetails = findViewById<TextView>(R.id.question_details)

        val answerButton1 = findViewById<ToggleButton>(R.id.question_1_wrong_answer_button_1)

        answerButton1.text = questionOne.wrongAnswer1

        questionTitle.text = questionOne.questionTitle
        questionDetails.text = questionOne.questionDetails


    }
}

