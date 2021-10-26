package kotlinFile

fun fibo(n: Int): Long {
    var a = 0L
    var b = 1L
    repeat(n) {
        val tmp = b
        b += a
        a = tmp
    }
    return a
}

fun main() {
    println(fibo(readLine()!!.toInt()))
}