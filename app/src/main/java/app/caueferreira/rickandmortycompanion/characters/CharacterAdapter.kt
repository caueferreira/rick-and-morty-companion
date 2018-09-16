package app.caueferreira.rickandmortycompanion.characters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import app.caueferreira.rickandmortycompanion.R


class CharacterAdapter : RecyclerView.Adapter<Holder>() {

    private var characters: ArrayList<CharacterViewState> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(layoutInflater.inflate(R.layout.character_view, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        (holder as CharacterHolder).bindViews(characters[position])
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    fun addCharacter(character: CharacterViewState) {
        characters.add(character)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return characters[position].id
    }
}