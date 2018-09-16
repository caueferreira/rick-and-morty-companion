package app.caueferreira.rickandmortycompanion.base

import app.caueferreira.data.DataModule
import app.caueferreira.rickandmortycompanion.ContextModule
import app.caueferreira.rickandmortycompanion.characters.ListCharactersPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (DataModule::class)])
interface PresenterInjector {

    fun inject(listCharactersPresenter: ListCharactersPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: DataModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}
