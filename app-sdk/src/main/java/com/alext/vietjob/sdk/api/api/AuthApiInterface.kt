package com.alext.vietjob.sdk.api.api

import com.alext.vietjob.sdk.data.requestmodel.UserLogin
import com.alext.vietjob.sdk.data.requestmodel.UserRegister
import com.alext.vietjob.sdk.data.response.UserResponse
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import rx.Observable

interface AuthApiInterface {

    @POST("users/login")
    fun login(@Body userLogin: UserLogin): Observable<UserResponse>

    @POST("users")
    fun register(@Body userRegister: UserRegister): Observable<UserResponse>

    @DELETE("users/logout")
    fun logout(): Observable<Response>

    @POST("drivers/login")
    fun loginAsDriver(@Body userLogin: UserLogin): Observable<UserResponse>

    @POST("drivers")
    fun registerDriver(@Body userRegister: UserRegister): Observable<UserResponse>

    @DELETE("drivers/logout")
    fun logoutDriver(): Observable<Response>

}