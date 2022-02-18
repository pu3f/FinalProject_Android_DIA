package com.example.projectdia.remote

import com.example.projectdia.model.getalljob.JobResponse
import com.example.projectdia.model.login.LoginResponse
import com.example.projectdia.model.requestlogin.RequestLogin
import com.example.projectdia.service.AppService
import io.reactivex.Single
import javax.inject.Inject

class AppRemoteDataSourceImpl @Inject constructor(private val service: AppService):AppRemoteDataSource{
    override fun getAllJob(): Single<JobResponse> {
        return service.getAllJob()
    }

    override fun postLogin(requestLogin: RequestLogin): Single<LoginResponse> {
        return service.postLogin(requestLogin)

    }

}