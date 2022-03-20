package com.lachlanvass.sit305quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

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

        val submitButton = findViewById<Button>(R.id.submit_1)

        submitButton.setOnClickListener {

            val wrongAnswer1 = findViewById<RadioButton>(R.id.question_1_wrong_answer_button_1)
            val wrongAnswer2 = findViewById<RadioButton>(R.id.question_1_wrong_answer_button_2)
            val rightAnswer = findViewById<RadioButton>(R.id.question_1_right_answer_button)

            val answerRadioGroup = findViewById<RadioGroup>(R.id.question_1_radio_group)

            val selectedAnswer = findViewById<RadioButton>(answerRadioGroup.checkedRadioButtonId)
            val selectedAnswerText = selectedAnswer.text

            rightAnswer.setBackgroundColor(resources.getColor(R.color.teal_200))

            if (!selectedAnswerText.equals(questionOne.rightAnswer)) {

                selectedAnswer.setBackgroundColor(resources.getColor(R.color.red))
            }

        }

    }
}

