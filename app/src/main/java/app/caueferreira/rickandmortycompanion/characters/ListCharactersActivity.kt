package app.caueferreira.rickandmortycompanion.characters

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View
import android.widget.Toast
import app.caueferreira.core.view.EndlessRecyclerOnScrollListener
import app.caueferreira.rickandmortycompanion.R
import app.caueferreira.rickandmortycompanion.base.BaseActivity
import app.caueferreira.rickandmortycompanion.databinding.ActivityListCharactersBinding
import kotlinx.android.synthetic.main.activity_list_characters.view.*


class ListCharactersActivity : BaseActivity<ListCharactersPresenter>(), ListCharacterView, SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityListCharactersBinding
    private val characterAdapter = CharacterAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_characters)
        binding.adapter = characterAdapter
        binding.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.recyclerView.addOnScrollListener(object : EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                presenter.loadCharacters()
            }
        })

        presenter.onViewCreated()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search, menu)

        val searchItem = menu.findItem(R.id.searchBar)

        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        searchView.isIconified = false
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        presenter.filter(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if(newText == ""){
            presenter.filter(newText)
        }
        return true
    }


    override fun loadCharacter(character: CharacterViewState) {
        characterAdapter.addCharacter(character)
    }

    override fun clear() {
        characterAdapter.clear()
    }


    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE

    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun instantiatePresenter(): ListCharactersPresenter {
        return ListCharactersPresenter(this)
    }
}