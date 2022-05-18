package problem16236

import java.util.*

fun main() {
    data class Pos(val x: Int, val y: Int) : Comparable<Pos> {
        override fun compareTo(other: Pos): Int {
            return if (y == other.y) x - other.x
            else y - other.y
        }
    }

    val queue: Queue<Pair<Pos, Int>> = LinkedList()

    val n = readln().toInt()
    val field = List(n) { y ->
        with(StringTokenizer(readln())) {
            IntArray(n) { x ->
                nextToken().toInt().run {
                    if (this == 9) {
                        queue += Pos(x, y) to 0
                        0
                    } else this
                }
            }
        }
    }

    var sharkSize = 2
    var sharkEat = 0

    var time = 0

    while (true) {
        val visited = ArrayList<Pos>()
        val next: SortedSet<Pos> = TreeSet()

        var leastDepth = Int.MAX_VALUE

        while (queue.isNotEmpty()) {
            val (pos, depth) = queue.poll()
            val (x, y) = pos

            if (x !in 0 until n || y !in 0 until n) continue
            if (pos in visited) continue
            if (field[y][x] !in 0..sharkSize) continue

            visited += pos

            if (field[y][x] in 1 until sharkSize) {
                if (leastDepth >= depth) {
                    next += pos
                    leastDepth = depth
                }
            } else {
                queue += Pos(x + 1, y) to depth + 1
                queue += Pos(x - 1, y) to depth + 1
                queue += Pos(x, y + 1) to depth + 1
                queue += Pos(x, y - 1) to depth + 1
            }
        }

        if (next.isEmpty()) {
            break
        } else {
            if (++sharkEat >= sharkSize) {
                sharkEat = 0
                sharkSize++
            }

            time += leastDepth

            next.first().let {
                queue += it to 0

                val (x, y) = it
                field[y][x] = 0
            }
        }
    }

    println(time)
}