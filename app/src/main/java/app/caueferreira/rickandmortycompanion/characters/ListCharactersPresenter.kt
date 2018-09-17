package app.caueferreira.rickandmortycompanion.characters

import app.caueferreira.data.RickAndMorty
import app.caueferreira.rickandmortycompanion.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListCharactersPresenter(listCharacterView: ListCharacterView) : BasePresenter<ListCharacterView>(listCharacterView) {

    private var FIRST_PAGE = 1
    private var page = FIRST_PAGE

    @Inject
    lateinit var rickAndMorty: RickAndMorty
    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadCharacters()
    }

    fun loadCharacters() {
        loadCharacters(page)
    }

    fun clear() {
        page = FIRST_PAGE
        view.clear()
    }

    fun filter(filter: String?) {
        filter?.let {
            clear()
            loadCharacters(page, filter)
        }
    }


    private fun loadCharacters(page: Int, filter: String){
        this.page++
        view.showLoading()
        subscription = rickAndMorty
                .characters(page, filter)!!
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { character -> view.loadCharacter(CharacterViewState.fromCharacter(character)) },
                        { error -> view.showError(error.localizedMessage) }
                )
    }

    private fun loadCharacters(page: Int) {
        loadCharacters(page, "")
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}