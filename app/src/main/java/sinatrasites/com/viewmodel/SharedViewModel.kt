package sinatrasites.com.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import sinatrasites.com.data.Repository
import sinatrasites.com.model.Character
import kotlinx.coroutines.launch

class SharedViewModel(private val repository: Repository) : ViewModel() {
    var listCharactersInEpisode = MutableLiveData<List<Character>>()
    fun getCharacters() {
        viewModelScope.launch {
            val characters = repository.getCharacters()
            listCharactersInEpisode.value = characters.results
        }
    }

}