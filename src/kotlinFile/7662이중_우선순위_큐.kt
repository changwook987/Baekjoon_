package kotlinFile

import java.util.*

fun main() {
    val r = System.`in`.bufferedReader()
    val w = System.out.bufferedWriter()

    fun read() = with(StringTokenizer(r.readLine())) { nextToken() to nextToken().toInt() }
    val t = r.readLine().toInt()

    repeat(t) {
        val map: SortedMap<Int, Int> = TreeMap()
        val n = r.readLine().toInt()

        repeat(n) {
            val (cmd, value) = read()
            when (cmd) {
                "I" -> {
                    map += value to map.getOrDefault(value, 0) + 1
                }
                "D" -> {
                    if (map.isNotEmpty()) {
                        val num = if (value < 0) {
                            map.firstKey()
                        } else {
                            map.lastKey()
                        }
                        if (map.put(num, map[num]!! - 1) == 1) {
                            map.remove(num)
                        }
                    }
                }
            }
        }

        if (map.isEmpty()) w.appendLine("EMPTY")
        else w.appendLine("${map.lastKey()} ${map.firstKey()}")
    }
    w.flush()
}