package kotlinFile

import java.util.*

fun main() {
    fun read() = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toInt() } }
    val (n, m) = read()

    data class Node(val pos: Int, val dep: Int)

    val queue: Queue<Node> = LinkedList(listOf(Node(n, 0)))
    val visited = BooleanArray(100001)

    while (queue.isNotEmpty()) {
        val (pos, dep) = queue.poll()
        if (pos == m) {
            println(dep)
            break
        }

        fun insertQueue(pos: Int) {
            if (pos in 0..100000 && !visited[pos]) {
                queue += Node(pos, dep + 1)
                visited[pos] = true
            }
        }

        insertQueue(pos + 1)
        insertQueue(pos - 1)
        insertQueue(pos * 2)
    }
}