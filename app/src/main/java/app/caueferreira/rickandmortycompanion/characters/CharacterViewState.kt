package app.caueferreira.rickandmortycompanion.characters

import app.caueferreira.domain.Character
import app.caueferreira.rickandmortycompanion.R

class CharacterViewState(val id: Int, val name: String, val status: String, val species: String,
                         val type: String, val gender: String, val origin: String, val imageUrl: String,
                         val statusColor: Int) {

    companion object {
        fun fromCharacter(character: Character): CharacterViewState {
            return CharacterViewState(character.id, character.name, character.status.name, "Species: ${character.species}",
                    if (character.type != null) character.type!! else "",
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
}