package com.example.projectdia.model.getalljob

import com.example.projectdia.model.getalljob.Data

data class JobResponse(
    val code: Int,
    val `data`: List<Data>,
    val status: String
)