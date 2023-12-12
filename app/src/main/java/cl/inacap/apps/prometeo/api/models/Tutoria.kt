package cl.inacap.apps.tutorias.models

data class Tutoria(
    val fecha: String,
    val hora: String,
    val sala: String,
    val alumnos: String,
    val informacionExtra: String
)
