package sinatrasites.com.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sinatrasites.com.data.Repository

class SharedViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
     return SharedViewModel(repository) as T
    }
}