package problem2441

fun main() {
    val n = readLine()?.toInt() ?: return

    for (i in 0 until n) {
        var str = ""
        for (j in n.minus(i) downTo 1) {
            str += '*'
        }
        println(str.padStart(n, ' '))
    }
}