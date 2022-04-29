package kotlinFile

fun main() {
    val r = System.`in`.bufferedReader()

    val (len) = r.readLine().split(" ").map { it.toInt() }
    val map = List(len) { r.readLine().toCharArray() }

    r.close()

    val visited = BooleanArray(26)

    val yRange = 0 until len
    val xRange = 0 until map[0].size

    fun dfs(x: Int, y: Int, dist: Int): Int {
        if (y !in yRange || x !in xRange) return 0
        val idx = map[y][x] - 'A'
        if (visited[idx]) return 0

        visited[idx] = true
        val max = maxOf(
            dfs(x + 1, y, dist + 1),
            dfs(x - 1, y, dist + 1),
            dfs(x, y + 1, dist + 1),
            dfs(x, y - 1, dist + 1)
        )
        visited[idx] = false

        return if (max == 0) dist else max
    }


    println(dfs(0, 0, 0) + 1)
}