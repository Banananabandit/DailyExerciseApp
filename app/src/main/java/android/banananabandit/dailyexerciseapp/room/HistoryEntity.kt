package android.banananabandit.dailyexerciseapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dates-table")
data class HistoryEntity(

    @PrimaryKey
    var date: String
)
