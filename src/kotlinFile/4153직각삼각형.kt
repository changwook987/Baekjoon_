package kotlinFile

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val w = BufferedWriter(OutputStreamWriter(System.out))

    fun read() = with(StringTokenizer(readln())){List(countTokens()){nextToken().toInt()} }

    while (true) {
        read().apply {
            if (this == listOf(0, 0, 0)) {
                w.flush()
                return
            }
            w.write(
                if (get(2) * get(2) == get(0) * get(0) + get(1) * get(1)) {
                    "right\n"
                } else {
                    "wrong\n"
                }
            )
        }
    }
}