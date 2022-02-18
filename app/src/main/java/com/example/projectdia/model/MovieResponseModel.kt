package com.example.projectdia.model

import com.google.gson.annotations.SerializedName

data class MovieResponseModel(
    val page: Int,
    @SerializedName("results")
    val movieModels: List<MovieModel>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
)