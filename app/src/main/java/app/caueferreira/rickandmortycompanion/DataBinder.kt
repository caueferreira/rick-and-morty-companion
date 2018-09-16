package app.caueferreira.rickandmortycompanion

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import app.caueferreira.rickandmortycompanion.characters.CharacterAdapter
import com.bumptech.glide.Glide


@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: CharacterAdapter) {
    view.adapter = adapter
}

@BindingAdapter("layoutManager")
fun setLayoutManager(view: RecyclerView, layoutManager: RecyclerView.LayoutManager) {
    view.layoutManager = layoutManager
}

@BindingAdapter("imageFromUrl")
fun imageFromUrl(imageView: ImageView, url: String) {

    url?.let {
        Glide.with(imageView.context)
                .load(url)
                .into(imageView)
    }
}

@BindingAdapter("statusColor")
fun statusColor(textView: TextView, color: Int) {
    textView.setBackgroundResource(color)
}