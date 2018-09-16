package app.caueferreira.data.character

import app.caueferreira.domain.Character

class CharacterListResponse(val results: List<CharacterResponse>)

class CharacterResponse(val id: Int, val name: String, val status: String, val gender: String,
                        val type: String, val species: String, val origin: OriginResponse, val image: String)

class OriginResponse(val name: String)

fun CharacterResponse.toCharacter(): Character {
    return Character(id, name, Character.Status.valueOf(status.toUpperCase()),
            species, if (type == "") null else type,
            Character.Gender.valueOf(gender.toUpperCase()), origin.name, image)
}