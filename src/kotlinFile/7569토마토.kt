package kotlinFile

import java.util.*

fun main() {
    val (n, m, h) = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toInt() } }
    data class Pos(val x: Int, val y: Int, val z: Int)

    val queue: Queue<Pair<Pos, Int>> = LinkedList()

    val map = List(h) { y ->
        List(m) { z ->
            with(StringTokenizer(readln())) {
                IntArray(n) { x ->
                    nextToken().toInt().apply {
                        if (this == 1) {
                            queue += Pos(x, y, z) to 0
                        }
                    }
                }
            }
        }
    }

    var maxDep = 0
    while (queue.isNotEmpty()) {
        val (pos, depth) = queue.poll()
        val (x, y, z) = pos

        if (map[y][z][x] == 1) {
            maxDep = maxOf(maxDep, depth)

            listOf(
                Pos(x + 1, y, z),
                Pos(x - 1, y, z),
                Pos(x, y + 1, z),
                Pos(x, y - 1, z),
                Pos(x, y, z + 1),
                Pos(x, y, z - 1)
            ).forEach { (x, y, z) ->
                if (x in 0 until n && y in 0 until h && z in 0 until m && map[y][z][x] == 0) {
                    map[y][z][x] = 1
                    queue += Pos(x, y, z) to depth + 1
                }
            }
        }
    }
    for (x in 0 until n) for (y in 0 until h) for (z in 0 until m) if (map[y][z][x] == 0) {
        println(-1)
        return
    }
    println(maxDep)
}