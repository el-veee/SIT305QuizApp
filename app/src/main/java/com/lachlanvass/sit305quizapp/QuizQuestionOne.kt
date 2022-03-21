package com.lachlanvass.sit305quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.forEach

class QuizQuestionOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question_one)

        val userName = intent.getStringExtra("USER_NAME")
        var totalScore = intent.getIntExtra("TOTAL_SCORE", 0)

        val welcomeMessage = findViewById<TextView>(R.id.question_1_welcome)
        welcomeMessage.text = "Welcome $userName !"

        val questionOne = Question(

            getString(R.string.question1_title),
            getString(R.string.question1_description),
            getString(R.string.question1_wrong_answer_1),
            getString(R.string.question1_wrong_answer_2),
            getString(R.string.question1_right_answer)
        )

        val submitButton = findViewById<Button>(R.id.submit_1)
        val nextButton = findViewById<Button>(R.id.question_1_next_button)

        submitButton.setOnClickListener {


            val wrongAnswer1 = findViewById<RadioButton>(R.id.question_1_wrong_answer_button_1)
            val wrongAnswer2 = findViewById<RadioButton>(R.id.question_1_wrong_answer_button_2)
            val rightAnswer = findViewById<RadioButton>(R.id.question_1_right_answer_button)

            val answerRadioGroup = findViewById<RadioGroup>(R.id.question_1_radio_group)

            // Do nothing if no button is checked
            if (answerRadioGroup.checkedRadioButtonId == -1) {return@setOnClickListener}

            val selectedAnswer = findViewById<RadioButton>(answerRadioGroup.checkedRadioButtonId)
            val selectedAnswerText = selectedAnswer.text

            rightAnswer.setBackgroundColor(resources.getColor(R.color.teal_200))

            if (!selectedAnswerText.equals(questionOne.rightAnswer)) {

                selectedAnswer.setBackgroundColor(resources.getColor(R.color.red))
            } else {

                totalScore++
            }

            answerRadioGroup.forEach {

                it.isClickable = false
            }

            nextButton.visibility = View.VISIBLE
            submitButton.visibility = View.INVISIBLE
        }

        nextButton.setOnClickListener {

            val questionTwoIntent = Intent(this, QuizQuestionTwo::class.java)

            passAppDataToIntent(questionTwoIntent, userName!!, totalScore)

            startActivity(questionTwoIntent)

        }

    }
}

