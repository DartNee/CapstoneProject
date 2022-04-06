package com.example.capstoneproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstoneproject.model.User
import com.example.capstoneproject.retrofit.RetrofitManager
import kotlinx.android.synthetic.main.activity_edit_user.*

class EditUserActivity : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user)


        //val id = intent.getIntExtra("user_id", 0)

        val firstUser = intent.extras?.get("id") as User


//        Log.d(
//            TAG,
//            "EditUserActivity - onCreate() called / firstUser.firstName : ${firstUser.user_id}"
//        )

        user_id.setText(firstUser.user_id)
        user_pass.setText(firstUser.user_pass)
        user_name.setText(firstUser.user_name)

        edit_user_btn.setOnClickListener {
            RetrofitManager.instance.updateUser(
                user_id = user_id.text.toString(),
                user_pass = user_pass.text.toString(),
                user_name = user_name.text.toString()
            )
        }


    }


}
