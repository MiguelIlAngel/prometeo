package cl.inacap.apps.tutorias.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TutoriasAPIAdapter {

    private const val BASE_URL = "https://tu-url-de-api.com/" // Reemplaza con tu URL base

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getTutoriasAPIService(): TutoriasAPIService {
        return retrofit.create(TutoriasAPIService::class.java)
    }
}
