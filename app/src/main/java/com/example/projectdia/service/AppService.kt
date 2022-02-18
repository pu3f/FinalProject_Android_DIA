package com.example.projectdia.service

import com.example.projectdia.model.getalljob.JobResponse
import com.example.projectdia.model.login.LoginResponse
import com.example.projectdia.model.requestlogin.RequestLogin
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AppService {
    @GET("api/v1/jobs")
    fun getAllJob():Single<JobResponse>

    @POST("api/v1/user/login")
    fun postLogin(@Body requestLogin: RequestLogin):Single<LoginResponse>



}