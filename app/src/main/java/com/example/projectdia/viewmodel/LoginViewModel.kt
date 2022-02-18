package com.example.projectdia.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectdia.di.DaggerAppComponent
import com.example.projectdia.model.login.LoginResponse
import com.example.projectdia.model.requestlogin.RequestLogin
import com.example.projectdia.repository.AppRepository
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

class LoginViewModel : ViewModel() {
    private val list = MutableLiveData<LoginResponse>()
    private val compositeDisposable = CompositeDisposable()
    private val isError = MutableLiveData<Boolean>()

    @Inject
    lateinit var repository: AppRepository

    init {
        DaggerAppComponent.create().injectView(this)
    }

    fun postLogin(requestLogin: RequestLogin) {
        compositeDisposable.add(
            repository.postLogin(requestLogin)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<LoginResponse>() {
                    override fun onSuccess(t: LoginResponse) {
                        if (t.code == 200) {
                            list.value = t
                            Log.d("testLogin", "notError = " + t.toString())
                        } else {
                            isError.value = true
                        }
                    }

                    override fun onError(e: Throwable) {
                        isError.value = true
                        if (e is HttpException) {
                            val errorBody = (e as HttpException).response()?.errorBody()
                            val gson = Gson()
                            val error = gson.fromJson(
                                errorBody?.string(),
                                LoginResponse::class.java
                            )
                            Log.d("testLoginError", "error = "+ error)
                        }
                    }
                })
        )
    }

    fun listResponse(): MutableLiveData<LoginResponse> {
        return list
    }

    fun getIsError(): MutableLiveData<Boolean> {
        return isError
    }
}