package ca.tetervak.worddata.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
class WordEntity (
    @PrimaryKey
    @ColumnInfo(name = "word")
    val value: String
)