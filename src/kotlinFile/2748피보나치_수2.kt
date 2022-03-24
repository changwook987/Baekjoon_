package kotlinFile


fun main() {
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
    println(fibo(readLine()!!.toInt()))
}