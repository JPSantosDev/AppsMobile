data class Curso(
    val id: Int,
    val curso:String,
    val ativo: Boolean

)

fun encontrarCurso(curso: List<Curso>, id:Int): Curso? {
    return curso.firstOrNull{it.id == id}
}

fun filtrarCurso(curso: List<Curso>): List<Curso> {
    return curso.filter{it.ativo}
}