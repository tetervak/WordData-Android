package ca.tetervak.worddata.data

import ca.tetervak.worddata.model.Word
import kotlinx.coroutines.flow.Flow

interface WordRepository {
    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allWordsFlow: Flow<List<Word>>

    suspend fun insertWord(word: Word)

    suspend fun insertSampleData()
    suspend fun deleteAllWords()
}