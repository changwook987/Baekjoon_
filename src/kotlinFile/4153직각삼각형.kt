package kotlinFile

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val w = BufferedWriter(OutputStreamWriter(System.out))

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

fun read(): List<Int> {
    readLine()!!.split(' ').apply {
        return listOf(get(0).toInt(), get(1).toInt(), get(2).toInt()).sorted()
    }
}