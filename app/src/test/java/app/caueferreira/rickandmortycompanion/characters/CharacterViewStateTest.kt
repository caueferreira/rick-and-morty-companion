package app.caueferreira.rickandmortycompanion.characters

import app.caueferreira.domain.Character
import app.caueferreira.rickandmortycompanion.R
import junit.framework.Assert
import org.junit.Test

class CharacterViewStateTest {

    @Test
    fun expectedCharactersViewCast() {
        val rickSanchez = Character(1, "Rick Sanchez", Character.Status.ALIVE, "Human",
                null, Character.Gender.MALE, "Earth (C-137)", "https://rickandmortyapi.com/api/character/avatar/1.jpeg")
        val summerSmith = Character(3, "Summer Smith", Character.Status.ALIVE, "Human",
                null, Character.Gender.FEMALE, "Earth (Replacement Dimension)", "https://rickandmortyapi.com/api/character/avatar/3.jpeg")
        val alanRails = Character(10, "Alan Rails", Character.Status.DEAD, "Human",
                "Superhuman (Ghost trains summoner)", Character.Gender.MALE, "unknown",
                "https://rickandmortyapi.com/api/character/avatar/10.jpeg")
        val alienMorty = Character(14, "Alien Morty", Character.Status.UNKNOWN, "Alien",
                null, Character.Gender.MALE, "Citadel of Ricks", "https://rickandmortyapi.com/api/character/avatar/14.jpeg")
        val blamph = Character(49, "Blamph", Character.Status.ALIVE, "Alien",
                null, Character.Gender.UNKNOWN, "Interdimensional Cable", "https://rickandmortyapi.com/api/character/avatar/49.jpeg")
        val holeInTheWallWhereTheMenCanSeeItAll = Character(157, "Hole in the Wall Where the Men Can See it All", Character.Status.UNKNOWN,
                "Unknown", "Hole", Character.Gender.GENDERLESS, "Interdimensional Cable",
                "https://rickandmortyapi.com/api/character/avatar/157.jpeg")

        val rickSanchezViewState = CharacterViewState(1, "Rick Sanchez", "ALIVE", "Species: Human",
                "", "Gender: MALE", "Origin: Earth (C-137)", "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                R.color.alive)
        val summerSmithViewState = CharacterViewState(3, "Summer Smith", "ALIVE", "Species: Human",
                "", "Gender: FEMALE", "Origin: Earth (Replacement Dimension)", "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
                R.color.alive)
        val alanRailsViewState = CharacterViewState(10, "Alan Rails", "DEAD", "Species: Human",
                "Superhuman (Ghost trains summoner)", "Gender: MALE", "Origin: unknown",
                "https://rickandmortyapi.com/api/character/avatar/10.jpeg", R.color.dead)
        val alienMortyViewState = CharacterViewState(14, "Alien Morty", "UNKNOWN", "Species: Alien",
                "", "Gender: MALE", "Origin: Citadel of Ricks", "https://rickandmortyapi.com/api/character/avatar/14.jpeg",
                R.color.unknown)
        val blamphViewState = CharacterViewState(49, "Blamph", "ALIVE", "Species: Alien",
                "", "Gender: UNKNOWN", "Origin: Interdimensional Cable", "https://rickandmortyapi.com/api/character/avatar/49.jpeg",
                R.color.alive)
        val holeInTheWallWhereTheMenCanSeeItAllViewState = CharacterViewState(157, "Hole in the Wall Where the Men Can See it All",
                "UNKNOWN", "Species: Unknown", "Hole", "Gender: GENDERLESS", "Origin: Interdimensional Cable",
                "https://rickandmortyapi.com/api/character/avatar/157.jpeg", R.color.unknown)

        isEquals(rickSanchezViewState, CharacterViewState.fromCharacter(rickSanchez))
        isEquals(summerSmithViewState, CharacterViewState.fromCharacter(summerSmith))
        isEquals(alanRailsViewState, CharacterViewState.fromCharacter(alanRails))
        isEquals(alienMortyViewState, CharacterViewState.fromCharacter(alienMorty))
        isEquals(blamphViewState, CharacterViewState.fromCharacter(blamph))
        isEquals(holeInTheWallWhereTheMenCanSeeItAllViewState, CharacterViewState.fromCharacter(holeInTheWallWhereTheMenCanSeeItAll))
    }

    fun isEquals(character: CharacterViewState, clone: CharacterViewState) {
        Assert.assertEquals(character.id, clone.id)
        Assert.assertEquals(character.name, clone.name)
        Assert.assertEquals(character.gender, clone.gender)
        Assert.assertEquals(character.species, clone.species)
        Assert.assertEquals(character.status, clone.status)
        Assert.assertEquals(character.imageUrl, clone.imageUrl)
        Assert.assertEquals(character.origin, clone.origin)
        Assert.assertEquals(character.type, clone.type)
        Assert.assertEquals(character.statusColor, clone.statusColor)
    }
}