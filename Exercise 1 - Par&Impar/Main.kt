fun main(){
    val num = readLine()!!.toInt()
    println(parimpar(num))
}

fun parimpar(num:Int){
    if(num%2 == 0)
        println("Par")
    else
        println("Impar")
}
