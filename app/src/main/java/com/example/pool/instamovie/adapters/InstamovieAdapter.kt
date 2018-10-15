package com.example.pool.instamovie.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pool.instamovie.viewholders.InstaViewHolder
import com.example.pool.instamovie.R
import com.example.pool.instamovie.models.INavigationCallbacks
import com.example.pool.instamovie.models.MovieItem

class InstamovieAdapter(val list: List<MovieItem>, val listener: INavigationCallbacks) : RecyclerView.Adapter<InstaViewHolder>() {
    override fun onBindViewHolder(holder: InstaViewHolder, position: Int) {
        val movieItem = list[position]
        val imageBaseUrl = "https://image.tmdb.org/t/p/w500/"
        holder.bind(listener = listener, url = imageBaseUrl + movieItem.url, title = movieItem.title, rating = movieItem.rating.toString(), description = movieItem.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return InstaViewHolder(view)
    }

    override fun getItemCount(): Int = list.size
}