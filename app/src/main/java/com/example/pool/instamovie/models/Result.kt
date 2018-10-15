package com.example.pool.instamovie.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {

    @Expose
    var adult: Boolean? = null
    @SerializedName("backdrop_path")
    var backdropPath: String? = null
    @SerializedName("genre_ids")
    var genreIds: List<Long>? = null
    @Expose
    var id: Long = -1
    @SerializedName("original_language")
    var originalLanguage: String? = null
    @SerializedName("original_title")
    var originalTitle: String? = null
    @Expose
    var overview: String = ""
    @Expose
    var popularity: Double? = null
    @SerializedName("poster_path")
    var posterPath: String = ""
    @SerializedName("release_date")
    var releaseDate: String? = null
    @Expose
    var title: String = ""
    @Expose
    var video: Boolean? = null
    @SerializedName("vote_average")
    var voteAverage: Double = 0.0
    @SerializedName("vote_count")
    var voteCount: Long? = null

}
