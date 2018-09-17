package app.caueferreira.rickandmortycompanion.characters

import app.caueferreira.rickandmortycompanion.base.BaseView

interface ListCharacterView : BaseView {

    fun clear()
    fun loadCharacter(character: CharacterViewState)

    fun showError(error: String)
    fun showLoading()
    fun hideLoading()
}
