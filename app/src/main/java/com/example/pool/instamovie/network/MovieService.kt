package com.example.pool.instamovie.network

import com.example.pool.instamovie.models.ServerMovieResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface MovieService {

    @GET("discover/movie?api_key=8f983d9643fbf459027fc5fee0071a74")
    fun getMovieResponse(): Observable<ServerMovieResponse>
}