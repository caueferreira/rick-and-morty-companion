package app.caueferreira.data

import app.caueferreira.data.character.CharacterListResponse
import app.caueferreira.data.character.CharacterResponse
import app.caueferreira.data.character.toCharacter
import app.caueferreira.data.network.RickMortyApi
import app.caueferreira.domain.Character
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RickAndMorty(private val rickMortyApi: RickMortyApi) {

    fun characters(page: Int, filter: String?): Observable<Character>? {
        return rickMortyApi
                .characters(page, filter)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map { characterListResponse: CharacterListResponse ->
                    characterListResponse.results
                }
                .flatMapIterable { x -> x }
                .map { characterResponse : CharacterResponse ->
                    characterResponse.toCharacter()
                }
    }
}