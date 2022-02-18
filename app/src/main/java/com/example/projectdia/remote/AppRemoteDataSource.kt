package com.example.projectdia.remote

import com.example.projectdia.model.getalljob.JobResponse
import com.example.projectdia.model.login.LoginResponse
import com.example.projectdia.model.requestlogin.RequestLogin
import io.reactivex.Single

interface AppRemoteDataSource {
    fun getAllJob ():Single<JobResponse>
    fun postLogin(requestLogin: RequestLogin):Single<LoginResponse>
}