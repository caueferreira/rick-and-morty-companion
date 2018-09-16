package app.caueferreira.rickandmortycompanion.characters

import app.caueferreira.data.RickAndMorty
import app.caueferreira.domain.Character
import app.caueferreira.rickandmortycompanion.R
import app.caueferreira.rickandmortycompanion.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListCharactersPresenter(listCharacterView: ListCharacterView) : BasePresenter<ListCharacterView>(listCharacterView) {

    private var page = 1

    @Inject
    lateinit var rickAndMorty: RickAndMorty
    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadCharacters()
    }

    fun loadCharacters() {
        loadCharacters(page)
        page++
    }

    private fun loadCharacters(page: Int) {
        view.showLoading()

        subscription = rickAndMorty
                .characters(page)!!
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { character -> view.loadCharacter(toViewState(character)) },
                        { error -> view.showError(error.toString()) }
                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }

    private fun toViewState(character: Character): CharacterViewState {
        return CharacterViewState(character.id, character.name, character.status.name, "Species: ${character.species}",
                if (character.type != null) character.type!! else " ",
                "Gender: ${character.gender.name}", "Origin: ${character.origin}", character.imageUrl,
                colorFromStatus(character.status))
    }

    private fun colorFromStatus(status: Character.Status): Int {
        return when (status) {
            Character.Status.ALIVE -> R.color.alive
            Character.Status.DEAD -> R.color.dead
            else -> R.color.unknown
        }
    }
}