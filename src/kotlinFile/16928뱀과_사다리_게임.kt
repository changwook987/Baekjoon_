package kotlinFile

import java.util.*

fun main() {
    fun read() = readln().split(" ").map { it.toInt() }
    val (n, m) = read()
    val game = IntArray(101) { it }

    repeat(n + m) {
        val (from, to) = read()
        game[from] = to
    }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue += 1 to 0

    while (queue.isNotEmpty()) {
        val (pos, depth) = queue.poll()

        if (pos !in 1..100) continue
        if(game[pos] == 0) continue

        var cur = pos
        while (game[cur] != cur) {
            cur = game[cur]
        }

        if (pos == 100) {
            println(depth)
            return
        }

        repeat(6) {
            queue += cur + it + 1 to depth + 1
            game[cur] = 0
        }
    }
}