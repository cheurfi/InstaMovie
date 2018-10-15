package com.example.pool.instamovie.models

import com.example.pool.instamovie.models.Result
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ServerMovieResponse {

    @Expose
    var page: Long? = null
    @Expose
    var results: List<Result>? = null
    @SerializedName("total_pages")
    var totalPages: Long? = null
    @SerializedName("total_results")
    var totalResults: Long? = null

}
