package com.alext.vietjob

import android.app.Application
import com.alext.shipping.BuildConfig
import com.alext.vietjob.sdk.ShippingSDK
import com.alext.vietjob.sdk.api.AuthService

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        ShippingSDK.setUp(this, BuildConfig.SERVER_URL)

    }
}