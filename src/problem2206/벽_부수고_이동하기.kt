package problem2206

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val map = Array(n) { readln().map { it == '1' }.toBooleanArray() }

    val queue: Queue<Pair<Pair<Int, Int>, Int>> = LinkedList()
    queue += 0 to 0 to 1

    val rX = 0 until m
    val rY = 0 until n

    fun Int.nextCost(): Int {
        return if (this > 0) inc()
        else dec()
    }

    fun Int.abs(): Int {
        return if (this > 0) this
        else -this
    }

    val visited = Array(n) { IntArray(m) }

    while (queue.isNotEmpty()) {
        val (pos, cost) = queue.poll()
        val (x, y) = pos

        if (cost > 0) {
            if (visited[y][x] and 1 != 0) continue
            else visited[y][x] = visited[y][x] xor 1
        } else {
            if (visited[y][x] and 2 != 0) continue
            else visited[y][x] = visited[y][x] xor 2
        }

        if (x == m - 1 && y == n - 1) {
            println(cost.abs())
            return
        }

        if (y + 1 in rY) {
            if (!map[y + 1][x]) queue += x to y + 1 to cost.nextCost()
            else if (cost >= 0) queue += x to y + 1 to -cost.nextCost()
        }

        if (y - 1 in rY) {
            if (!map[y - 1][x]) queue += x to y - 1 to cost.nextCost()
            else if (cost >= 0) queue += x to y - 1 to -cost.nextCost()
        }

        if (x + 1 in rX) {
            if (!map[y][x + 1]) queue += x + 1 to y to cost.nextCost()
            else if (cost >= 0) queue += x + 1 to y to -cost.nextCost()
        }

        if (x - 1 in rX) {
            if (!map[y][x - 1]) queue += x - 1 to y to cost.nextCost()
            else if (cost >= 0) queue += x - 1 to y to -cost.nextCost()
        }
    }

    println(-1)
}

/*
6 4
0000
1110
1000
0000
0111
0000
 */