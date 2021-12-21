package sinatrasites.com.data
import sinatrasites.com.model.CharacterList
import retrofit2.http.GET

interface SimpleApi {
    @GET("db")
    suspend fun getCharacters(): CharacterList
}