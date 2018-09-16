package app.caueferreira.rickandmortycompanion.base

import app.caueferreira.data.DataModule
import app.caueferreira.rickandmortycompanion.ContextModule
import app.caueferreira.rickandmortycompanion.characters.ListCharactersPresenter

abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(DataModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is ListCharactersPresenter -> injector.inject(this)
        }
    }

    abstract fun onViewCreated()
    abstract fun onViewDestroyed()
}
