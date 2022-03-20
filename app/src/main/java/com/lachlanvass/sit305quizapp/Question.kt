package com.lachlanvass.sit305quizapp

/**
 * Represents the data model for a question
 * @model
 */
data class Question(
    val questionTitle: String,
    val questionDetails: String,
    val wrongAnswer1: String,
    val wrongAnswer2: String,
    val rightAnswer: String
)