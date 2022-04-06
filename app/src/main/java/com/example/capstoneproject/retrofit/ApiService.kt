package com.example.capstoneproject.retrofit

import com.example.capstoneproject.utils.Constants.API_GET_USER
import com.example.capstoneproject.utils.Constants.API_PUT_USER
import com.example.capstoneproject.utils.Constants.API_USER
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

//    @GET(API_GET_USER)
//    fun getUser(@Path(value = "page", encoded = true)page :String): Call<JsonElement>

    @GET(API_GET_USER)
    fun getUser(@Path(value = "id", encoded = true)id :Int): Call<JsonElement>


    // firstName, lastName, email, password

//    @FormUrlEncoded
//    @POST(API_USER)
//    fun createUser(@Field("firstName") firstName :String,
//                   @Field("lastName") lastName :String,
//                   @Field("email") email :String,
//                   @Field("password") password :String
//    ) : Call<JsonElement>

    @FormUrlEncoded
    @POST(API_USER)
    fun createUser(
        @Field("user_id") user_id: String,
        @Field("user_pass") user_pass: String,
        @Field("user_name") user_name: String

    ) : Call<JsonElement>


    @FormUrlEncoded
    @PATCH(API_PUT_USER)
    fun updateUser(@Field("user_id") user_id: String,
                   @Field("user_pass") user_pass: String,
                   @Field("user_name") user_name: String
    ) : Call<JsonElement>


}

