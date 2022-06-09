package problem12852

fun main() {
    val n = readln().toInt()

    val memo = IntArray(n + 1)
    val parent = IntArray(n + 1) { it - 1 }

    parent[1] = 1

    fun find(n: Int): Int {
        if (n == 1) return 0

        if (memo[n] == 0) {
            var min = find(n - 1)

            if (n % 3 == 0) {
                val value = find(n / 3)

                if (min > value) {
                    parent[n] = n / 3
                    min = value
                }
            }

            if (n % 2 == 0) {
                val value = find(n / 2)

                if (min > value) {
                    parent[n] = n / 2
                    min = value
                }
            }

            memo[n] = min + 1
        }

        return memo[n]
    }

    println(find(n))

    var cur = n
    val sb = StringBuilder("$cur")

    while (cur != parent[cur]) {
        cur = parent[cur]
        sb.append(" $cur")
    }

    println(sb)
}