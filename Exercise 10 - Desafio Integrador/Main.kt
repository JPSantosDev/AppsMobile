data class Curso(
    val id: Int,
    val nome: String,
    val categoria: String,
    val cargaHoraria: Int,
    val nota: Double,
    val ativo: Boolean
)

data class ResumoCategoria(
    val categoria: String,
    val quantidade: Int,
    val cargaTotal: Int,
    val mediaNota: Double
)

fun buscarPorNome(cursos: List<Curso>, termo: String): List<Curso> {
    return cursos.filter {
        it.nome.contains(termo, ignoreCase = true)
    }
}

fun filtrarPorCategoria(cursos: List<Curso>, categoria: String): List<Curso> {
    return cursos.filter {
        it.categoria.equals(categoria, ignoreCase = true)
    }
}

fun gerarRanking(cursos: List<Curso>): List<Curso> {
    return cursos.sortedByDescending { it.nota }
}

fun gerarResumoPorCategoria(cursos: List<Curso>): List<ResumoCategoria> {
    return cursos
        .groupBy { it.categoria }
        .map { (categoria, lista) ->
            ResumoCategoria(
                categoria = categoria,
                quantidade = lista.size,
                cargaTotal = lista.sumOf { it.cargaHoraria },
                mediaNota = if (lista.isEmpty()) 0.0 else lista.map { it.nota }.average()
            )
        }
}

fun validarCadastro(nome: String, cargaTexto: String): String {
    if (nome.isBlank()) return "Nome obrigatório"

    val carga = cargaTexto.toIntOrNull()
        ?: return "Carga horária inválida"

    if (carga <= 0) return "Carga horária deve ser positiva"

    return "Cadastro válido"
}

fun main() {
    val cursos = listOf(
        Curso(1, "Kotlin Básico", "Programação", 40, 8.5, true),
        Curso(2, "Jetpack Compose", "Android", 32, 9.4, true),
        Curso(3, "Room Database", "Android", 24, 8.0, true),
        Curso(4, "Figma Mobile", "Design", 20, 7.5, false),
        Curso(5, "Testes Unitários", "Qualidade", 30, 8.8, true),
        Curso(6, "Coroutines", "Kotlin", 28, 9.0, true)
    )

    println("Busca por nome:")
    println(buscarPorNome(cursos, "kotlin"))

    println("Ranking:")
    println(gerarRanking(cursos))

    println("Resumo:")
    println(gerarResumoPorCategoria(cursos))
}