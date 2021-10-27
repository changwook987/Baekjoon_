package kotlinFile

fun main() {
    var i = 1
    var cnt = 1
    val n = readLine()!!.toInt()
    while (cnt < n) {
        cnt += i++ * 6
    }
    println(i)
}