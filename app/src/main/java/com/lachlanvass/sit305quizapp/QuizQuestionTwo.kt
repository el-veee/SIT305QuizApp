package com.lachlanvass.sit305quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.forEach

class QuizQuestionTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question_two)

        val userName = intent.getStringExtra("USER_NAME")
        var totalScore = intent.getIntExtra("TOTAL_SCORE", 0)

        val welcomeMessage = findViewById<TextView>(R.id.question_welcome)
        welcomeMessage.text = "Welcome $userName !"

        val questionOne = Question(

            getString(R.string.question2_title),
            getString(R.string.question2_description),
            getString(R.string.question2_wrong_answer_1),
            getString(R.string.question2_wrong_answer_2),
            getString(R.string.question2_right_answer)
        )

        val submitButton = findViewById<Button>(R.id.submit_2)
        val nextButton = findViewById<Button>(R.id.question_2_next_button)

        submitButton.setOnClickListener {


            val rightAnswer = findViewById<RadioButton>(R.id.question_2_right_answer_button)

            val answerRadioGroup = findViewById<RadioGroup>(R.id.question_2_radio_group)

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

            val questionThreeIntent = Intent(this, QuizQuestionThree::class.java)

            passAppDataToIntent(questionThreeIntent, userName!!, totalScore)

            startActivity(questionThreeIntent)

        }
    }
}