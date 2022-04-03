package com.example.capstoneproject

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "6cacae3aa88e5fb685376947b41f8521")
    }
}