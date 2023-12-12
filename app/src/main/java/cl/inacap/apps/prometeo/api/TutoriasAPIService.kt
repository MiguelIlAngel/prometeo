package cl.inacap.apps.tutorias.api

import cl.inacap.apps.tutorias.models.Tutoria
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TutoriasAPIService {

    @GET("tutorias")
    fun getAllTutorias(): Call<List<Tutoria>>

    @POST("tutorias")
    fun addTutoria(@Body tutoria: Tutoria): Call<Tutoria>
}
