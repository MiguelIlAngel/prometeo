package cl.inacap.apps.tutorias

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import cl.inacap.apps.prometeo.R
import cl.inacap.apps.tutorias.api.TutoriasAPIAdapter
import cl.inacap.apps.tutorias.models.Tutoria
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var editTextFecha: EditText
    private lateinit var editTextHora: EditText
    private lateinit var editTextSala: EditText
    private lateinit var editTextAlumnos: EditText
    private lateinit var editTextInformacionExtra: EditText
    private lateinit var btnAgregarTutoria: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar vistas
        editTextFecha = findViewById(R.id.edit_text_fecha)
        editTextHora = findViewById(R.id.edit_text_hora)
        editTextSala = findViewById(R.id.edit_text_sala)
        editTextAlumnos = findViewById(R.id.edit_text_alumnos)
        editTextInformacionExtra = findViewById(R.id.edit_text_informacion_extra)
        btnAgregarTutoria = findViewById(R.id.btn_agregar_tutoria)

        // Asignar un listener al botón para agregar una tutoría
        btnAgregarTutoria.setOnClickListener {
            agregarTutoria()
        }

        // Obtener todas las tutorías al inicio
        getAllTutorias()
    }

    private fun getAllTutorias() {
        val tutoriasService = TutoriasAPIAdapter.getTutoriasAPIService()

        tutoriasService.getAllTutorias().enqueue(object : Callback<List<Tutoria>> {
            override fun onResponse(call: Call<List<Tutoria>>, response: Response<List<Tutoria>>) {
                if (response.isSuccessful) {
                    val tutorias: List<Tutoria>? = response.body()
                    // Manejo de la lista de tutorías obtenidas
                } else {
                    // Manejo de errores en caso de respuesta no exitosa
                }
            }

            override fun onFailure(call: Call<List<Tutoria>>, t: Throwable) {
                // Manejo de errores en caso de falla en la llamada
            }
        })
    }

    private fun agregarTutoria() {
        val fecha = editTextFecha.text.toString()
        val hora = editTextHora.text.toString()
        val sala = editTextSala.text.toString()
        val alumnos = editTextAlumnos.text.toString()
        val informacionExtra = editTextInformacionExtra.text.toString()

        val newTutoria = Tutoria(fecha, hora, sala, alumnos, informacionExtra)

        val tutoriasService = TutoriasAPIAdapter.getTutoriasAPIService()

        tutoriasService.addTutoria(newTutoria).enqueue(object : Callback<Tutoria> {
            override fun onResponse(call: Call<Tutoria>, response: Response<Tutoria>) {
                if (response.isSuccessful) {
                    // La tutoría se agregó exitosamente
                } else {
                    // Manejo de errores en caso de respuesta no exitosa
                }
            }

            override fun onFailure(call: Call<Tutoria>, t: Throwable) {
                // Manejo de errores en caso de falla en la llamada
            }
        })
    }
}
