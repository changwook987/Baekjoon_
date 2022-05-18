package problem4963

import java.util.*

fun main() {
    val stringTokenizer = StringTokenizer(System.`in`.bufferedReader().readLines().joinToString(" "))
    with(stringTokenizer) {
        while (hasMoreTokens()) {
            val x = nextToken().toInt()
            val y = nextToken().toInt()

            if (x == 0 && y == 0) break

            val map = List(y) { MutableList(x) { nextToken().toInt() } }

            fun bfs(startAt: Pair<Int, Int>): Boolean {
                val queue: Queue<Pair<Int, Int>> = LinkedList(listOf(startAt))

                var result = false
                while (queue.isNotEmpty()) {
                    val pos = queue.poll()

                    if (pos.first in 0 until x && pos.second in 0 until y) {
                        if (map[pos.second][pos.first] == 1) {

                            result = true
                            map[pos.second][pos.first] = 0

                            (pos.first + 1 to pos.second).apply {
                                if (this !in queue) {
                                    queue += this
                                }
                            }

                            (pos.first + 1 to pos.second + 1).apply {
                                if (this !in queue) {
                                    queue += this
                                }
                            }

                            (pos.first to pos.second + 1).apply {
                                if (this !in queue) {
                                    queue += this
                                }
                            }

                            (pos.first - 1 to pos.second).apply {
                                if (this !in queue) {
                                    queue += this
                                }
                            }

                            (pos.first - 1 to pos.second - 1).apply {
                                if (this !in queue) {
                                    queue += this
                                }
                            }

                            (pos.first to pos.second - 1).apply {
                                if (this !in queue) {
                                    queue += this
                                }
                            }

                            (pos.first + 1 to pos.second - 1).apply {
                                if (this !in queue) {
                                    queue += this
                                }
                            }

                            (pos.first - 1 to pos.second + 1).apply {
                                if (this !in queue) {
                                    queue += this
                                }
                            }
                        }
                    }
                }

                return result
            }

            var cnt = 0

            for (i in 0 until y) {
                for (j in 0 until x) {
                    if (bfs(j to i)) {
                        cnt++
                    }
                }
            }

            println(cnt)
        }
    }
}