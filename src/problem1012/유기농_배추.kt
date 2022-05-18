package problem1012

import java.util.*

fun main() = with(System.out.bufferedWriter()) {
    fun read() = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toInt() } }
    val n = readln().toInt()

    repeat(n) {
        val (x, y, m) = read()
        val map = List(y) { IntArray(x) }

        repeat(m) {
            val (i, j) = read()
            map[j][i] = 1
        }

        val xRange = 0 until x
        val yRange = 0 until y


        var cnt = 0

        repeat(y) { y1 ->
            repeat(x) { x1 ->
                val queue: Queue<Pair<Int, Int>> = LinkedList()
                queue += x1 to y1
                if (map[y1][x1] == 1) cnt++

                while (queue.isNotEmpty()) {
                    val (i, j) = queue.poll()

                    if (i in xRange && j in yRange) {
                        if (map[j][i] == 1) {
                            map[j][i] = 0

                            queue += i + 1 to j
                            queue += i - 1 to j
                            queue += i to j + 1
                            queue += i to j - 1
                        }
                    }
                }
            }
        }

        appendLine(cnt.toString())
    }
    flush()
}