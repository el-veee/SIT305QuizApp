package com.lachlanvass.sit305quizapp

import android.content.Intent

/**
 * Util fun to simplify passing app data through intents
 */
fun passAppDataToIntent(to: Intent, userName: String, totalScore: Int) {

    to.putExtra("USER_NAME", userName)
    to.putExtra("TOTAL_SCORE", totalScore)
}
