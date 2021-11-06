package kotlinFile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val r = BufferedReader(InputStreamReader(System.`in`))
val w = BufferedWriter(OutputStreamWriter(System.out))

fun readCmd(): List<String> {
    return r.readLine().split(' ')
}

fun main() {
    val set = emptySet<Int>().toMutableSet()
    repeat(r.readLine().toInt()) {
        readCmd().apply {
            when (get(0)) {
                "add" -> {
                    set.add(get(1).toInt())
                }
                "remove" -> {
                    set.remove(get(1).toInt())
                }
                "check" -> {
                    w.write(if (set.contains(get(1).toInt())) "1\n" else "0\n")
                }
                "toggle" -> {
                    if (set.contains(get(1).toInt())) {
                        set.remove(get(1).toInt())
                    } else {
                        set.add(get(1).toInt())
                    }
                }
                "all" -> {
                    repeat(20) {
                        set.add(it.plus(1))
                    }
                }
                "empty" -> {
                    set.clear()
                }
            }
        }
    }
    w.flush()
}