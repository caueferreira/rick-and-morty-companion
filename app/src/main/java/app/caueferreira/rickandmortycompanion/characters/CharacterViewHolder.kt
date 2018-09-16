package app.caueferreira.rickandmortycompanion.characters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import app.caueferreira.rickandmortycompanion.databinding.CharacterViewBinding

typealias Holder = RecyclerView.ViewHolder

interface CharacterHolder {
    fun bindViews(characterViewState: CharacterViewState)
}

class CharacterViewHolder(itemView: View?) : Holder(itemView), CharacterHolder {
    override fun bindViews(characterViewState: CharacterViewState) {
        DataBindingUtil.bind<CharacterViewBinding>(itemView)?.apply {
            character = characterViewState
        }
    }
}
