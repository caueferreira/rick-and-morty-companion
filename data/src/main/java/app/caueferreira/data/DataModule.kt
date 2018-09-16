package app.caueferreira.data

import app.caueferreira.data.network.ApiClient
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object DataModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRickAndMorty(): RickAndMorty {
        return RickAndMorty(ApiClient.create())
    }
}