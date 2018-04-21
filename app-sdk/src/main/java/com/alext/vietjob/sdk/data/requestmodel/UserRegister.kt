package com.alext.vietjob.sdk.data.requestmodel

import com.google.gson.annotations.SerializedName

data class UserRegister(@SerializedName("phone")
                        val phone: String,
                        @SerializedName("name")
                        val name: String,
                        @SerializedName("password")
                        private val password: String,
                        @SerializedName("password_confirmation")
                        val passwordConfirmation: String = password)