package kotlinFile

import java.util.*

fun main() {
    val r = System.`in`.bufferedReader()
    val w = System.out.bufferedWriter()

    fun read() = with(StringTokenizer(r.readLine())) { List(countTokens()) { nextToken().toInt() } }
    val n = r.readLine().toInt()

    fun d(i: Int): Int = i * 2 % 10000
    fun s(i: Int): Int = (i + 9999) % 10000
    fun l(i: Int): Int = i / 1000 + i % 1000 * 10
    fun r(i: Int): Int = i / 10 + i % 10 * 1000


    repeat(n) {
        val (a, b) = read()

        val queue: Queue<Pair<Int, String>> = LinkedList()
        val visited = BooleanArray(10001)

        queue += a to ""

        while (queue.isNotEmpty()) {
            val (cur, cmd) = queue.poll()

            if (visited[cur]) continue
            visited[cur] = true

            if (cur == b) {
                w.appendLine(cmd)
                break
            }

            queue += d(cur) to cmd + "D"
            queue += s(cur) to cmd + "S"
            queue += l(cur) to cmd + "L"
            queue += r(cur) to cmd + "R"
        }
    }

    w.flush()
}