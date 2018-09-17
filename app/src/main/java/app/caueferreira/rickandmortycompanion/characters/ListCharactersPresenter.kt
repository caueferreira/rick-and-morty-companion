package app.caueferreira.rickandmortycompanion.characters

import app.caueferreira.data.RickAndMorty
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
                        { character -> view.loadCharacter(CharacterViewState.fromCharacter(character)) },
                        { error -> view.showError(error.localizedMessage) }
                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}