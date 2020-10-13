package com.oodles.tambolaapp2.network

import com.google.gson.JsonObject
import com.oodles.tambolaapp2.model.ModelAuthRequest
import com.oodles.tambolaapp2.model.ModelAuthResponse
import com.oodles.tambolaapp2.model.ModelOtpResponse
import com.oodles.tambolaapp2.model.ModelTicketsParent
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {
    @GET
    fun getAllTickets(
        @Url url: String? //bcdc7f7c
    ): Call<List<ModelTicketsParent>>



    @POST("/user/authenticate")
    fun getLoginResponse(
        @Header("token") token: String?,
        @Body data: JsonObject?
    ): Call<ModelAuthResponse>

    @POST("/user/validation-otp")
    fun getOtpResponse(
        @Header("token") token: String?,
        @Body data: JsonObject?
    ): Call<ModelOtpResponse>


}