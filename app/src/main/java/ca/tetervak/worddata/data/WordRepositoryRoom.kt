package ca.tetervak.worddata.data

import ca.tetervak.worddata.model.Word
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WordRepositoryRoom @Inject constructor(
    private val wordDao: WordDao
    ) : WordRepository {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    override val allWordsFlow: Flow<List<Word>> =
        wordDao.getSortedWordEntities().map { entityList ->
            entityList.map { entity -> Word(entity.value) }
        }

    override suspend fun insertWord(word: Word) {
        wordDao.insertWordEntity(WordEntity(word.value))
    }

    private suspend fun insertWordList(wordList: List<Word>) {
        wordDao.insertWordEntityList(wordList.map { word -> WordEntity(word.value) })
    }

    override suspend fun insertSampleData(){
        insertWordList(listOf(Word("Google"), Word("Apple"), Word("Microsoft")))
    }

    override suspend fun deleteAllWords(){
        wordDao.deleteAllWordEntities()
    }
}
