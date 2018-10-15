package com.example.pool.instamovie.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.example.pool.instamovie.models.INavigationCallbacks
import kotlinx.android.synthetic.main.movie_item.view.*

class InstaViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val image = view.image
    val title = view.title
    val rating = view.rating

    fun bind(url: String, title: String, rating: String, listener:INavigationCallbacks) {
        Glide.with(image).load(url).into(image)
        this.title.text = title
        this.rating.text = rating
        image.setOnClickListener { listener.onMovieItemClicked() }
    }
}