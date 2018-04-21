package com.alext.vietjob.sdk.api

import com.alext.vietjob.sdk.data.model.User
import com.alext.vietjob.sdk.data.requestmodel.UserLogin
import com.alext.vietjob.sdk.data.requestmodel.UserRegister
import com.alext.vietjob.sdk.di.ApiServiceModule
import com.alext.vietjob.sdk.di.SdkModule
import com.alext.vietjob.sdk.persistence.AuthenticationStore
import rx.Observable

object AuthService {

    private val authApiInterface = ApiServiceModule.provideAuthApiInterface()
    private val authenticationStore: AuthenticationStore = SdkModule.provideAuthenticationStore()

    fun loginAsUser(phoneNumber: String, password: String): Observable<User> {
        val userLogin = UserLogin(phoneNumber, password)
        return authApiInterface.login(userLogin).map { it.data!! }.doOnNext {
            authenticationStore.accessToken = it.userInfo.accessToken
        }
    }

    fun registerUser(name: String, phoneNumber: String, password: String): Observable<User> {
        val userRegister = UserRegister(phoneNumber, name, password)
        return authApiInterface.register(userRegister).map { it.data!! }
    }

    fun logOutUser(): Observable<Boolean> {
        return authApiInterface.logout().map { it.code() == 200 }.doOnNext {
            authenticationStore.clear()
        }
    }

    fun loginAsDriver(phoneNumber: String, password: String): Observable<User> {
        val userLogin = UserLogin(phoneNumber, password)
        return authApiInterface.login(userLogin).map { it.data!! }.doOnNext {
            authenticationStore.accessToken = it.userInfo.accessToken
        }
    }

    fun registerDriver(name: String, phoneNumber: String, password: String): Observable<User> {
        val userRegister = UserRegister(phoneNumber, name, password)
        return authApiInterface.registerDriver(userRegister).map { it.data!! }
    }

    fun logOutDriver(): Observable<Boolean> {
        return authApiInterface.logoutDriver().map { it.code() == 200 }.doOnNext {
            authenticationStore.clear()
        }
    }
}