package problem16899

val r = System.`in`.bufferedReader()
fun read() = r.readLine().split(" ").map { it.toLong() }

//연속한 수의 xor
//https://www.geeksforgeeks.org/calculate-xor-1-n/
fun xorSum(n: Long): Long {
    return when (n % 4) {
        0L -> n
        1L -> 1
        2L -> n + 1
        else -> 0
    }
}

fun xorSum(n: Long, m: Long): Long {
    return xorSum(n - 1) xor xorSum(m)
}

fun main() {
    var g = 0L

    repeat(r.readLine().toInt()) {
        val (x, m) = read()
        g = g xor xorSum(x, x + m - 1)
    }

    if (g == 0L) println("cubelover")
    else println("koosaga")
}