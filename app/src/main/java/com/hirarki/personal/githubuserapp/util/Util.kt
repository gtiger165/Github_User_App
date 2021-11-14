package com.hirarki.personal.githubuserapp.util

import android.content.Context
import java.io.IOException

fun getJsonFromAssets(context: Context, fileName: String): String?{
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

fun getImage(context: Context, imageName: String): Int {
    return context.resources.getIdentifier(imageName, "drawable", context.packageName)
}