package com.example.pool.instamovie.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pool.instamovie.R
import com.example.pool.instamovie.SharedViewModel
import com.example.pool.instamovie.adapters.InstamovieAdapter
import com.example.pool.instamovie.models.INavigationCallbacks
import com.example.pool.instamovie.models.MovieItem
import com.example.pool.instamovie.network.MovieProvider
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment: Fragment() {

    private val movieProvider = MovieProvider()
    private lateinit var listener : INavigationCallbacks
    private lateinit var sharedViewModel: SharedViewModel

    companion object {
        fun newInstance(): MovieListFragment {
            return MovieListFragment()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as INavigationCallbacks
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        movieProvider.getMovieItems()
                .flatMapIterable { it.results }
                .map { MovieItem(it.posterPath, it.title, it.voteAverage) }
                .toList()
                .subscribe(this::displayItems, Throwable::printStackTrace)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    private fun displayItems(result: List<MovieItem>) {
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = InstamovieAdapter(list = result, listener = listener)
    }
}