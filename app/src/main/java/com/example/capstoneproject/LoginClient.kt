package com.example.capstoneproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstoneproject.retrofit.RetrofitManager
import kotlinx.android.synthetic.main.activity_login_client.*

class LoginClient : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_client)

        btn_register.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {
            var id = RetrofitManager.instance.getUserPaginate(et_id.text.toString())
            var pw = et_pass.text.toString()


            print("id = " + id + " pw = " + pw)

//            result = authenticate(username=id, password=pw)
//
//            if result:
//            print("로그인 성공!")
//            return JsonResponse({'code': '0000', 'msg': '로그인성공입니다.'}, status=200)
//            else:
//            print("실패")
//            return JsonResponse({'code': '1001', 'msg': '로그인실패입니다.'}, status=200)



            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }
}