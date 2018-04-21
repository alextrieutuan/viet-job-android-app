package com.alext.vietjob.sdk.di

import com.alext.vietjob.sdk.api.api.AuthApiInterface

object ApiServiceModule {

    private var authApiInterface: AuthApiInterface? = null

    fun provideAuthApiInterface(): AuthApiInterface {
        if (authApiInterface == null) {
            authApiInterface = RestfulModule.provideRetrofit().create(AuthApiInterface::class.java)
        }
        return authApiInterface!!
    }
}