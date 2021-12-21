package sinatrasites.com.data
import sinatrasites.com.model.CharacterList
class Repository {
    suspend fun getCharacters(): CharacterList {
        return RetrofitInstance.api.getCharacters()
    }

}