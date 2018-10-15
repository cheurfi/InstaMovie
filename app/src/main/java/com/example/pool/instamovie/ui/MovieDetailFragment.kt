package com.example.pool.instamovie.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.pool.instamovie.R
import com.example.pool.instamovie.models.MovieDetailItem
import com.example.pool.instamovie.network.MovieProvider
import kotlinx.android.synthetic.main.fragment_detail.*

class MovieDetailFragment : Fragment() {

    private val movieProvider = MovieProvider()

    companion object {
        fun newInstance(): MovieDetailFragment {
            return MovieDetailFragment()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        movieProvider.getMovieItems()
                .flatMapIterable { it.results }
                .map { MovieDetailItem(it.title, it.overview, it.posterPath) }
                .subscribe {
                    title.text = it.title
                    description.text = it.description
                    Glide.with(image).load("https://image.tmdb.org/t/p/w500/" + it.imagePath).into(image)
                }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
}