package com.example.projectdia.di

import com.example.projectdia.viewmodel.JobViewModel
import com.example.projectdia.viewmodel.LoginViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun injectView(loginViewModel: LoginViewModel)
    fun injectView(jobViewModel: JobViewModel)

}