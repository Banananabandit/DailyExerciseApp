package android.banananabandit.dailyexerciseapp.room

import android.app.Application

class DateApp: Application() {
    val db by lazy {
        HistoryDatabase.getInstance(this)
    }
}