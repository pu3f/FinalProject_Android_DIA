package com.example.projectdia.repository

import com.example.projectdia.model.getalljob.JobResponse
import com.example.projectdia.model.login.LoginResponse
import com.example.projectdia.model.requestlogin.RequestLogin
import com.example.projectdia.remote.AppRemoteDataSource
import io.reactivex.Single
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(private val remoteDataSource: AppRemoteDataSource):AppRepository{
    override fun getAllJob(): Single<JobResponse> {
        return remoteDataSource.getAllJob()
    }

    override fun postLogin(requestLogin: RequestLogin): Single<LoginResponse> {
        return remoteDataSource.postLogin(requestLogin)
    }
}