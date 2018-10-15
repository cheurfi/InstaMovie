package com.example.pool.instamovie.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pool.instamovie.viewholders.InstaViewHolder
import com.example.pool.instamovie.R
import com.example.pool.instamovie.models.INavigationCallbacks
import com.example.pool.instamovie.models.MovieItem

class InstamovieAdapter(val list: List<MovieItem>, val listener: INavigationCallbacks): RecyclerView.Adapter<InstaViewHolder>() {
    override fun onBindViewHolder(holder: InstaViewHolder, position: Int) {
        val imageBaseUrl = "https://image.tmdb.org/t/p/w500/"
        holder.bind(imageBaseUrl + list[position].url, list[position].title, list[position].rating.toString(), listener = listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return InstaViewHolder(view)
    }

    override fun getItemCount(): Int = list.size
}