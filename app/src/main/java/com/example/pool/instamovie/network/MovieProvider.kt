package com.example.pool.instamovie.network

import com.example.pool.instamovie.models.MovieItem
import com.example.pool.instamovie.models.ServerMovieResponse
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MovieProvider {

    val url = "https://api.themoviedb.org/3/"

    val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    fun getMovieItems(): Observable<ServerMovieResponse> {
        return retrofit.create(MovieService::class.java)
                .getMovieResponse()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}