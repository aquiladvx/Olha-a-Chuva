package com.debcomp.aql.olhaachuva.data

import com.debcomp.aql.olhaachuva.data.response.TodayWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


/*
 * Davi Áquila
 *
 * 24/02/2020
 *
 */
val APIKEY = "52bfe4999baf8e6d297202a9dcdd9e34"
interface WeatherStackApi {

    //EXAMPLE : http://api.weatherstack.com/current?access_key=52bfe4999baf8e6d297202a9dcdd9e34&query=montreal

    @GET("current")
    fun getCurrentWeather(
        @Query("query") location: String
    ): Deferred<TodayWeatherResponse>

    companion object {
        operator fun invoke(): WeatherStackApi {
            val requestInterceptor = Interceptor{
                var url = it.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("access_key", APIKEY)
                    .build()
                val request = it.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor it.proceed(request)
            }
            val okHttp = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttp)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherStackApi::class.java)
        }
    }
}