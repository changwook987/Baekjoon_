package problem1920

import java.util.*


fun main() {
    fun read() = with(StringTokenizer(readln())) { List(countTokens()) { nextToken().toInt() } }
    val list = read().sorted()
    val find = read()

    System.out.bufferedWriter().use { w ->
        for (f in find) {
            w.write((if (list.binarySearch(f) >= 0) "1" else "0") + "\n")
        }
        w.flush()
    }
}