package com.example.projectdia.di

import com.example.projectdia.remote.AppRemoteDataSource
import com.example.projectdia.remote.AppRemoteDataSourceImpl
import com.example.projectdia.repository.AppRepository
import com.example.projectdia.repository.AppRepositoryImpl
import com.example.projectdia.service.AppRetrofit
import com.example.projectdia.service.AppService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideRepository(appRemoteDataSource: AppRemoteDataSource):AppRepository{
        return AppRepositoryImpl(appRemoteDataSource)
    }
    @Provides
    @Singleton
    fun provideRemoteDataSource(appService: AppService):AppRemoteDataSource{
        return AppRemoteDataSourceImpl(appService)
    }
    @Provides
    @Singleton
    fun provideAppService():AppService{
        return AppRetrofit.appService
    }
}