package com.alext.vietjob.sdk.data.requestmodel

import com.google.gson.annotations.SerializedName

data class UserLogin (@SerializedName("phone")
                       val phone: String,
                       @SerializedName("password")
                       val password: String)