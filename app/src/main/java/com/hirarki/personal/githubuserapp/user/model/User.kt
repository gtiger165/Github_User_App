package com.hirarki.personal.githubuserapp.user.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var id: Int,
    var username: String,
    var name: String,
    var avatar: String
): Parcelable
