package app.caueferreira.data.network

import app.caueferreira.data.character.CharacterListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyApi {

    @GET("character")
    fun characters(@Query("page") page: Int): Observable<CharacterListResponse>

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}