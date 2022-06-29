package problem14677

fun main() {
    val n = readln().toInt()
    val arr = readln().map {
        when (it) {
            'B' -> 0
            'L' -> 1
            else -> 2
        }
    }

    val visited = Array(n * 3) { IntArray(n * 3) { -1 } }

    fun dfs(start: Int, end: Int, dep: Int = 0): Int {
        if (start > end) return dep

        if (visited[start][end] == -1) {

            var max = 0

            if (arr[start] == dep % 3) {
                max = maxOf(dfs(start + 1, end, dep + 1), max)
            }

            if (arr[end] == dep % 3) {
                max = maxOf(dfs(start, end - 1, dep + 1), max)
            }

            visited[start][end] = if (max == 0) dep
            else max
        }

        return visited[start][end]
    }

    println(dfs(0, arr.size - 1))
}