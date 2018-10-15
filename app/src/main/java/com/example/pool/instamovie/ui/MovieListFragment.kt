package com.example.pool.instamovie.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pool.instamovie.R
import com.example.pool.instamovie.adapters.InstamovieAdapter
import com.example.pool.instamovie.models.INavigationCallbacks
import com.example.pool.instamovie.models.MovieItem
import com.example.pool.instamovie.network.MovieProvider
import com.example.pool.instamovie.viewmodels.MovieListViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.*

class MovieListFragment : Fragment() {

    private val movieProvider = MovieProvider()
    private val movieListViewModel = MovieListViewModel(movieProvider)
    lateinit var listener: INavigationCallbacks

    companion object {
        fun newInstance(): MovieListFragment {
            return MovieListFragment()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as INavigationCallbacks
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieListViewModel.getMovieList()
                .subscribe { movieItems -> displayItems(movieItems) }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    private fun displayItems(result: List<MovieItem>) {
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = InstamovieAdapter(list = result, listener = listener)
    }
}