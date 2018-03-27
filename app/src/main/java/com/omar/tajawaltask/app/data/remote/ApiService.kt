package com.omar.tajawaltask.app.data.remote

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by omaraboulfotoh on 3/27/18.
 */
interface ApiService {
    @GET("hotels_exercise.json")
    fun getHotels(): Observable<Result>


    /**
     * Companion object for the factory
     */
    companion object Factory {
        fun create(): ApiService {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .baseUrl("http://gchbib.de/tajawal/")
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}