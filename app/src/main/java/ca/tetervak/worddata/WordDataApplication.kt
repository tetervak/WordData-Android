package ca.tetervak.worddata

import android.app.Application
import ca.tetervak.worddata.data.WordDatabase
import ca.tetervak.worddata.data.WordRepositoryRoom
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class WordDataApplication : Application()