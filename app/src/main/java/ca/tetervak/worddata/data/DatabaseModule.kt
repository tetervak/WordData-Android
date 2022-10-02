package ca.tetervak.worddata.data

import android.content.Context
import android.util.Log
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideWordDao(database: WordDatabase): WordDao {
        Log.d("DependencyInjection", "provide WordDao")
        return database.wordDao()
    }

    @Singleton
    @Provides
    fun provideWordDatabase(@ApplicationContext context: Context): WordDatabase {
        Log.d("DependencyInjection","provide TipDatabase")
        return Room.databaseBuilder(
            context.applicationContext,
            WordDatabase::class.java,
            "word_database"
        ).build()
    }
}