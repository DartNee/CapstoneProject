package com.example.capstoneproject.model

import android.os.Parcel
import android.os.Parcelable

class User() : Parcelable {

    var user_id: String = ""
    var user_pass: String = ""
    var user_name: String = ""

    constructor(parcel: Parcel) : this() {
//        id = parcel.readInt()
        user_id = parcel.readString().toString()
        user_pass = parcel.readString().toString()
        user_name = parcel.readString().toString()
    }

    constructor(user_id: String, user_pass: String, user_name: String) : this() {


        this.user_id = user_id
        this.user_pass = user_pass
        this.user_name = user_name

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(user_id)
        parcel.writeString(user_pass)
        parcel.writeString(user_name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }


}
