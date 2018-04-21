package com.alext.vietjob.sdk.data.model

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("id")
        val id: String,

        @SerializedName("type")
        val type: String,

        @SerializedName("attributes")
        val userInfo: UserInfo) {

    data class UserInfo(@SerializedName("id")
                        val phone: String,
                        @SerializedName("id")
                        val name: String,
                        @SerializedName("access_token")
                        val accessToken: String)
}