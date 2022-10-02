package ca.tetervak.worddata.data

import ca.tetervak.worddata.model.Word
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WordRepository(private val wordDao: WordDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allWordsFlow: Flow<List<Word>> =
        wordDao.getSortedWordEntities().map { entityList ->
            entityList.map { entity -> Word(value = entity.value) }
        }

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    //@Suppress("RedundantSuspendModifier")
    //@WorkerThread
    suspend fun insertWord(word: Word) {
        wordDao.insertWordEntity(WordEntity(value = word.value))
    }
}
