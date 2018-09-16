package app.caueferreira.rickandmortycompanion.characters

import app.caueferreira.rickandmortycompanion.base.BaseView

interface ListCharacterView : BaseView {

    fun loadCharacter(character: CharacterViewState)

    fun showError(error: String)
    fun showLoading()
    fun hideLoading()
}
