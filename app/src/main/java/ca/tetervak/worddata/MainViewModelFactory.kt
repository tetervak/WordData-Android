package ca.tetervak.worddata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ca.tetervak.worddata.data.WordRepository

class MainViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}