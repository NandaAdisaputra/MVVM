package com.nandaadisaputra.mvvm.network

import com.nandaadisaputra.mvvm.BuildConfig.API_INTERFACE
import com.nandaadisaputra.mvvm.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(API_INTERFACE)
    fun movie(): Call<MovieResponse>
}