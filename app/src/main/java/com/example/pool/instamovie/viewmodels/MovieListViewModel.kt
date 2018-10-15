package com.example.pool.instamovie.viewmodels

import android.arch.lifecycle.ViewModel
import com.example.pool.instamovie.models.MovieItem
import com.example.pool.instamovie.network.MovieProvider
import io.reactivex.Single

class MovieListViewModel(val movieProvider: MovieProvider): ViewModel() {

    fun getMovieList(): Single<List<MovieItem>> {
        return movieProvider.getMovieItems()
                .flatMapIterable { it.results }
                .map { MovieItem(it.posterPath, it.title, it.voteAverage, it.overview) }
                .toList()
    }
}