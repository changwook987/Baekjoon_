package kotlinFile

fun main() {
    val n = readln().toInt()
    val table = IntArray(1001)//Memorization

    fun solve(c: Int): Int {
        if (c == 0) return 1
        if (c >= 0) {
            if (table[c] == 0) {
                if (c >= 2) {
                    table[c] += solve(c - 2)
                    table[c] += solve(c - 2)
                }
                table[c] += solve(c - 1)
            }
            return table[c] % 10007
        }
        return 0
    }

    println(solve(n))
}