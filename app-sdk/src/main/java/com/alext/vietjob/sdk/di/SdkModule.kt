package com.alext.vietjob.sdk.di

import com.alext.vietjob.sdk.ShippingSDK
import com.alext.vietjob.sdk.persistence.AuthenticationStore

object SdkModule {

    fun provideAuthenticationStore(): AuthenticationStore {
        return AuthenticationStore(ShippingSDK.context)
    }
}