package sinatrasites.com.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/sinatra-mintic/backend/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }

}