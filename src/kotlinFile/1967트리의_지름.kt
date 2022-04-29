package kotlinFile

fun main() {
    val r = System.`in`.bufferedReader()
    val size = r.readLine().toInt()

    val graph = List(size) { ArrayList<Pair<Int, Int>>() }

    repeat(size - 1) {
        val (left, right, d) = r.readLine().split(" ").map { it.toInt() - 1 }

        graph[left] += right to d + 1
        graph[right] += left to d + 1
    }

    val visited = BooleanArray(size)

    fun dfs(cur: Int, dist: Int): Int {
        var max = 0

        visited[cur] = true

        for ((i, d) in graph[cur]) {
            if (visited[i]) continue

            max = maxOf(max, dfs(i, dist + d))
        }

        visited[cur] = false

        return if (max == 0) dist else max
    }

    var max = 0
    repeat(size) {
        max = maxOf(dfs(it, 0), max)
    }
    println(max)
}