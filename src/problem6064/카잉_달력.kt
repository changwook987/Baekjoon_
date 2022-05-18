package problem6064

fun main() {
    fun gcd(a: Long, b: Long): Long {
        return if (a % b == 0L) b
        else gcd(b, a % b)
    }

    fun lcm(a: Long, b: Long): Long {
        return a * b / gcd(a, b)
    }

    val list = System.`in`.bufferedReader().use { r ->
        List(r.readLine().toInt()) {
            r.readLine().split(" ").map { it.toLong() }
        }
    }


    System.out.bufferedWriter().use {
        for ((m, n, x, y) in list) {
            var i = x
            val limit = lcm(m, n)
            while (true) {
                if (i > limit || (i - 1) % n == y - 1) {
                    break
                }
                i += m
            }
            it.appendLine(
                if (i > limit) "-1"
                else "$i"
            )
        }
        it.flush()
    }
}
