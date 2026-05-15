data class Curso(
    val id: Int,
    val nome: String,
    val categoria: String,
    val cargaHoraria: Int,
    val nota: Double,
    val ativo: Boolean
)

fun encontrarCurso(curso: List<Curso>, id:Int): Curso? {
    return curso.firstOrNull{it.id == id}
}

fun filtrarCurso(curso: List<Curso>): List<Curso> {
    return curso.filter{it.ativo}
}

fun rankingCurso(curso: List<Curso>): List<Curso> {
    return curso.sortedBy { it.nota }
}

fun somaCargaCurso(curso: List<Curso>): Int {
    val ativos = curso.filter{it.ativo}
    var soma = 0

    for(cursos in ativos){
        soma+=cursos.cargaHoraria
    }
    return soma
}

fun retirarDuplicadosCurso(curso: List<Curso>): Set<Curso> {
    val semDuplicados = curso.toMutableSet()
    return semDuplicados
}

fun categorizarCurso(curso: List<Curso>): Map<String,List<Curso>> {
    return curso.groupBy { it.categoria }
}
fun listarCategoriasUnicas(cursos: List<Curso>): List<String> {
    return cursos.map { it.categoria }
        .toSet()
        .toList()
}