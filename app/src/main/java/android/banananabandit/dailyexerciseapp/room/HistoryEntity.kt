package android.banananabandit.dailyexerciseapp.room

import androidx.room.Entity

@Entity(tableName = "dates-table")
data class HistoryEntity(
    var date: String
)
