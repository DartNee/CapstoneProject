package com.example.capstoneproject.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import org.conscrypt.Conscrypt
import java.security.Security


@SuppressLint("Registered")
class App : Application() {
    companion object {
        lateinit var instance: App
            private set
    }

    fun context(): Context?{
        return instance.applicationContext
    }

    init {
        instance = this
    }


//    override fun onCreate() {
//        super.onCreate()
//        instance = this
//    }

    override fun onCreate() {
        super.onCreate()
        Security.insertProviderAt(Conscrypt.newProvider(), 1);
    }

//    fun context(): Context = applicationContext

}
