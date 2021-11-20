package kotlinFile

fun main() {
    val n = readLine()!!.toInt()
    val k = readLine()!!.toInt()
    List(k) { it.plus(1) }.filter { it >= n && it.isPrime() }.apply {
        if (isEmpty())
            println(-1)
        else {
            var add = 0
            forEach { add += it }
            println(add)
            println(first())
        }
    }
}

fun Int.isPrime(): Boolean {
    if (this < 2) return false
    var i = 2
    while (i * i <= this) {
        if (this % i == 0) return false
        i++
    }
    return true
}
