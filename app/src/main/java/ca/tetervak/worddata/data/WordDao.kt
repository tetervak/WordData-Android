package ca.tetervak.worddata.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ca.tetervak.worddatalab.data.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getSortedWordEntities(): Flow<List<WordEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWordEntity(word: WordEntity)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}