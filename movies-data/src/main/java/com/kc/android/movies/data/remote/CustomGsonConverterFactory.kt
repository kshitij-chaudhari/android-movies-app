/*
 * Copyright 2021 Kshitij Chaudhari
 */
package com.kc.android.movies.data.remote

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Custom Gson Factory is created to handle empty date string in response
 */
class CustomGsonConverterFactory {
    fun create(): GsonConverterFactory {
        val gson = GsonBuilder()
            .registerTypeAdapter(
                Date::class.java,
                JsonDeserializer { json: JsonElement?, _: Type?, _: JsonDeserializationContext? ->
                    json?.asString?.let {
                        try {
                            SimpleDateFormat("yyyy-mm-dd", Locale.getDefault()).parse(it)
                        } catch (e: Exception) {
                            null
                        }
                    }
                }
            ).create()
        return GsonConverterFactory.create(gson)
    }
}
