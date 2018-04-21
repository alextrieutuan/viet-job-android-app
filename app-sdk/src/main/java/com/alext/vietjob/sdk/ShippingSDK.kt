package com.alext.vietjob.sdk

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

@SuppressLint("StaticFieldLeak")
object ShippingSDK {
    internal lateinit var baseUrl: String
    internal lateinit var context: Context

    fun setUp(application: Application, baseUrl: String){
        ShippingSDK.baseUrl = baseUrl
        context = application.applicationContext
    }
}