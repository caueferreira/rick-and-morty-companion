package app.caueferreira.data.character

import app.caueferreira.domain.Character
import junit.framework.Assert.assertEquals
import org.junit.Test

class CharacterResponseTest{

    @Test
    fun expectedCharactersCast(){
        val rickSanchezResponse = CharacterResponse(1, "Rick Sanchez", "Alive", "Male", "", "Human",
                OriginResponse("Earth (C-137)"), "https://rickandmortyapi.com/api/character/avatar/1.jpeg")
        val summerSmithResponse = CharacterResponse(3, "Summer Smith", "Alive", "Female", "", "Human",
                OriginResponse("Earth (Replacement Dimension)"), "https://rickandmortyapi.com/api/character/avatar/3.jpeg")
        val alanRailsResponse = CharacterResponse(10, "Alan Rails", "Dead", "Male", "Superhuman (Ghost trains summoner)",
                "Human", OriginResponse("unknown"), "https://rickandmortyapi.com/api/character/avatar/10.jpeg")
        val alienMortyResponse = CharacterResponse(14, "Alien Morty", "Unknown", "Male", "", "Alien",
                OriginResponse("Citadel of Ricks"), "https://rickandmortyapi.com/api/character/avatar/14.jpeg")
        val blamphResponse = CharacterResponse(49, "Blamph", "Alive", "Unknown", "", "Alien",
                OriginResponse("Interdimensional Cable"), "https://rickandmortyapi.com/api/character/avatar/49.jpeg")
        val holeInTheWallWhereTheMenCanSeeItAllResponse = CharacterResponse(157, "Hole in the Wall Where the Men Can See it All",
                "Unknown", "Genderless", "Hole", "Unknown",  OriginResponse("Interdimensional Cable"),
                "https://rickandmortyapi.com/api/character/avatar/157.jpeg")

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
                "Unknown",  "Hole", Character.Gender.GENDERLESS, "Interdimensional Cable",
                "https://rickandmortyapi.com/api/character/avatar/157.jpeg")


        isEquals(rickSanchez, rickSanchezResponse.toCharacter())
        isEquals(summerSmith, summerSmithResponse.toCharacter())
        isEquals(alanRails, alanRailsResponse.toCharacter())
        isEquals(alienMorty, alienMortyResponse.toCharacter())
        isEquals(blamph, blamphResponse.toCharacter())
        isEquals(holeInTheWallWhereTheMenCanSeeItAll, holeInTheWallWhereTheMenCanSeeItAllResponse.toCharacter())
    }

    fun isEquals(character: Character, clone: Character){
        assertEquals(character.id, clone.id)
        assertEquals(character.name, clone.name)
        assertEquals(character.gender, clone.gender)
        assertEquals(character.species, clone.species)
        assertEquals(character.status, clone.status)
        assertEquals(character.imageUrl, clone.imageUrl)
        assertEquals(character.origin, clone.origin)
        assertEquals(character.type, clone.type)
    }
}
