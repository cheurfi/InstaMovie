package com.example.pool.instamovie.models

import java.io.Serializable

class MovieItem(
        val url: String,
        val title: String,
        val rating: Double,
        val description: String
) : Serializable