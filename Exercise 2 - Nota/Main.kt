fun main(){
    val num = readLine()!!.toInt()
    classificar(num)
}


fun classificar(nota:Int){
    when (nota) {
        in 90..100 -> {
            println("Excelente")
        }
        in 70..89 -> {
            println("Aprovado")
        }
        in 50..69 -> {
            println("Recuperação")
        }
        in 0..49 -> {
            println("Reprovado")
        }
        else -> {
            println("Nota Invalida")
        }
    }
}
