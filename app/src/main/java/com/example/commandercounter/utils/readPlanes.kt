package com.example.commandercounter.utils

import android.content.Context
import com.example.commandercounter.data.models.Plane
import com.example.commandercounter.data.models.Planes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun readPlanes(context: Context): List<Plane> {
    val jsonStr = context
        .assets
        .open("planechase.json")
        .bufferedReader()
        .use {it.readText()}

    val planeListType: List<Plane> = Gson().fromJson(jsonStr, object : TypeToken<List<Plane>>() {}.type)
    return planeListType
}