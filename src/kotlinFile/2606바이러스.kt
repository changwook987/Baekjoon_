package kotlinFile

fun main() {
    val numOfComputer = readLine()!!.toInt()
    val computer = emptyMap<Int, Set<Int>>().toMutableMap()
    val numOfLink = readLine()!!.toInt()

    repeat(numOfLink) {
        readLine()!!.split(' ').apply {
            val a = get(0).toInt().minus(1)
            val b = get(1).toInt().minus(1)

            computer[a] = try {
                computer.getValue(a).plus(b)
            } catch (e: NoSuchElementException) {
                setOf(b)
            }

            computer[b] = try {
                computer.getValue(b).plus(a)
            } catch (e: NoSuchElementException) {
                setOf(a)
            }
        }
    }

    fun dfs(graph: Map<Int, Set<Int>>, v: Int, visited: MutableList<Boolean>): MutableList<Boolean> {
        visited[v] = true
        var visit = visited
        for (i in graph[v] ?: return visited) {
            if (!visit[i])
                visit = dfs(graph, i, visited)
        }
        return visit
    }

    val visited = dfs(computer, 0, MutableList(numOfComputer) { false })
    println(
        visited.count { it }.minus(1)
    )
}