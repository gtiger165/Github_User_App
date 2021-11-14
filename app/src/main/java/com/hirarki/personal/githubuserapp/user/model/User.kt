package com.hirarki.personal.githubuserapp.user.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var id: Int,
    var username: String,
    var name: String,
    var avatar: String,
    var company: String,
    var location: String,
    var repository: Int,
    var follower: Int,
    var following: Int
): Parcelable
