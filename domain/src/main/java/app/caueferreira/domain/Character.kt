package app.caueferreira.domain

class Character(val id: Int, val name: String, val status: Status, val species: String,
                val type: String?, val gender: Gender, val origin: String, val imageUrl: String) {

    enum class Status {
        ALIVE, DEAD, UNKNOWN
    }

    enum class Gender {
        FEMALE, MALE, GENDERLESS, UNKNOWN
    }
}