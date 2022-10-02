package ca.tetervak.worddata

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import ca.tetervak.worddata.data.WordRepository
import ca.tetervak.worddata.model.Word
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: WordRepository
    ) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val liveAllWords: LiveData<List<Word>> = repository.allWordsFlow.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insertWord(word: Word) = viewModelScope.launch {
        repository.insertWord(word)
    }
}