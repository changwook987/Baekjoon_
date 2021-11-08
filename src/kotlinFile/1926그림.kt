package kotlinFile

import java.util.*
import kotlin.math.max

fun main() = with(Scanner(System.`in`)) {
    val y = nextInt()
    val x = nextInt()

    val graph = Graph(MutableList(y) { MutableList(x) { nextInt() } })
    var cnt = 0
    var maxValue = 0

    for (i in 0 until y) {
        for (j in 0 until x) {
            graph.dfs(Pos(j, i)).apply {
                if (this != 0) {
                    cnt++
                    maxValue = max(maxValue, this)
                }
            }
        }
    }
    println(cnt)
    println(maxValue)
}

class Pos(var x: Int, var y: Int)

class Graph(var graph: MutableList<MutableList<Int>>) {
    private val bound = Pos(graph[0].size, graph.size)

    fun dfs(v: Pos): Int {
        if ((0 until bound.x).contains(v.x) && (0 until bound.y).contains(v.y)) {
            if (graph[v.y][v.x] == 1) {
                graph[v.y][v.x] = 0
                return 1.plus(dfs(Pos(v.x + 1, v.y)))
                    .plus(dfs(Pos(v.x - 1, v.y)))
                    .plus(dfs(Pos(v.x, v.y + 1)))
                    .plus(dfs(Pos(v.x, v.y - 1)))
            }
        }
        return 0
    }
}