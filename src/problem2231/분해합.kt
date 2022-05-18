package problem2231

fun main() {
    val n = readLine()!!.toInt()

    for (i in 1..n) {
        var m = i
        var cnt = i
        while (cnt != 0) {
            m += cnt.mod(10)
            cnt /= 10
        }

        if (m == n) {
            println(i)
            return
        }
    }
    println(0)
}