package kotlinFile

fun main() {
    val n = readln().toInt()
    val map = List(n) { BooleanArray(n) }

    fun solve(x: Int, y: Int, size: Int) {
        if (size == 1) {
            map[y][x] = true
        } else {
            val s = size / 3

            solve(x, y, s)
            solve(x + s, y, s)
            solve(x + s + s, y, s)
            solve(x, y + s, s)
            solve(x + s + s, y + s, s)
            solve(x, y + s + s, s)
            solve(x + s, y + s + s, s)
            solve(x + s + s, y + s + s, s)
        }
    }

    solve(0, 0, n)

    System.out.bufferedWriter().use {
        for (r in map) {
            for (b in r) {
                it.append(if (b) '*' else ' ')
            }
            it.append('\n')
        }
        it.flush()
    }
}