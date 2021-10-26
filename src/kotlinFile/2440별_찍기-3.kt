package kotlinFile

fun main() {
    val n = readLine()?.toInt() ?: return

    for(i in 0 until n){
        for(j in n.minus(i) downTo 0){
            print('*')
        }
        println()
    }
}