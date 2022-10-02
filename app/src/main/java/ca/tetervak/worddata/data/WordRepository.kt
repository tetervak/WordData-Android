package ca.tetervak.worddata.data

import ca.tetervak.worddata.model.Word
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WordRepository(private val wordDao: WordDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allWordsFlow: Flow<List<Word>> =
        wordDao.getSortedWordEntities().map { entityList ->
            entityList.map { entity -> Word(entity.value) }
        }

    suspend fun insertWord(word: Word) {
        wordDao.insertWordEntity(WordEntity(word.value))
    }

    private suspend fun insertWordList(wordList: List<Word>) {
        wordDao.insertWordEntityList(wordList.map { word -> WordEntity(word.value) })
    }

    suspend fun insertSampleData(){
        insertWordList(listOf(Word("Google"), Word("Apple"), Word("Microsoft")))
    }

    suspend fun deleteAllWords(){
        wordDao.deleteAllWordEntities()
    }
}
