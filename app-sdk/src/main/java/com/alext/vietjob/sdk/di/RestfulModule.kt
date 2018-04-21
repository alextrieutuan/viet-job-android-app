package com.alext.vietjob.sdk.di

import com.alext.vietjob.sdk.ShippingSDK
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RestfulModule {

    private var retrofit: Retrofit? = null
    private var okHttpClient: OkHttpClient? = null

    fun provideRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(ShippingSDK.baseUrl)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(provideOkHttpClient())
                    .build()
        }
        return retrofit!!
    }

    private fun provideOkHttpClient(): OkHttpClient {
        if (okHttpClient == null) {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor {
                        val request = it.request()
                        val requestBuilder = request.newBuilder()
                        val accessToken = SdkModule.provideAuthenticationStore().accessToken
                        if (accessToken != null) {
                            requestBuilder.addHeader("X-API-KEY", accessToken)
                        }
                        it.proceed(requestBuilder.build())
                    }
                    .build()
        }
        return okHttpClient!!
    }

}