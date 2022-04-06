package com.example.capstoneproject.retrofit

import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.capstoneproject.EditUserActivity
import com.example.capstoneproject.model.User
import com.example.capstoneproject.utils.App
import com.example.capstoneproject.utils.Constants.API_BASE_URL
import com.example.restapitutorial.retrofit.RetrofitManager
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response

class RetrofitManager {
    val TAG: String = "로그"

    companion object {

        val instance = RetrofitManager()
    }

    private val httpCall : ApiService? = RetrofitClient.getClient(API_BASE_URL)?.create(ApiService::class.java)

    fun getUserPaginate(id: Int) {
        val call = httpCall?.getUser(id)
        //we call the new enqueue
        call?.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")

            }

        })
    }

    fun getFirstUser() {
        val call = httpCall?.getUser(1)
        //we call the new enqueue
        call?.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")

                response.body()?.let { // 응답이 있을 때
                    Log.d(TAG, "it : ${it}")

                    val jsonObj = it.asJsonObject //

                    //val fetchedUsersJsonArray = jsonObj.get("fetchedUsersPerPage").asJsonArray

//                    val firstUserJson = jsonObj.get("1").asJsonObject
                    // val firstUserJson = jsonObj.get("1").asJsonObject
//                    Log.d(TAG, "fetchedUsersJsonArray : ${fetchedUsersJsonArray}")

                    Log.d(TAG, "jsonObj : ${jsonObj}")

                    val firstUser = User(user_id = jsonObj.get("user_id").asString,
                        user_pass = jsonObj.get("user_pass").asString,
                        user_name = jsonObj.get("user_name").asString)

//                    val intent = Intent(App.instance, EditUserActivity::class.java)
                    val intent = Intent(App.instance, EditUserActivity::class.java)

                    intent.putExtra("firstUser", firstUser)

                    App.instance.startActivity(intent)


                }

            }

        })
    }




    fun createUser(user_id: String, user_pass: String, user_name: String) {
        val call = httpCall?.createUser(user_id, user_pass, user_name)
        call?.enqueue(object : retrofit2.Callback<JsonElement>{ // 응답이 오면 이 곳으로 들어옴(호출하는 것)
            override fun onFailure(call: Call<JsonElement>, t: Throwable) { // 실패하면 이 곳으로 들어옴
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) { // 성공하면 이 곳으로 들어옴
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")
            }

        })
    }

    fun updateUser(user_id: String, user_pass: String, user_name: String) {

//        val call = httpCall?.updateUser(firstName, lastName, email, password, "1")
        val call = httpCall?.updateUser(user_id, user_pass, user_name)

        call?.enqueue(object : retrofit2.Callback<JsonElement>{

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager - getTodo() - onFailure() called / t: ${t}")
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager - getTodo() - onResponse() called / response: $response")
                Log.d(TAG, "response.body : ${response.body()}")

                Toast.makeText(App.instance, response.body().toString(), Toast.LENGTH_SHORT).show()

            }

        })

}