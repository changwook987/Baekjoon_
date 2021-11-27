package kotlinFile

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val r = BufferedReader(InputStreamReader(System.`in`))
    val w = BufferedWriter(OutputStreamWriter(System.out))
    r.readLine().split(' ').apply {
        val pokemonList = emptyMap<String, Int>().toMutableMap()
        repeat(get(0).toInt()) {
            pokemonList[r.readLine()] = it.plus(1)
        }
        repeat(get(1).toInt()) {
            val s = r.readLine()
            s.toIntOrNull().apply {
                if (this != null)
                    w.write("${pokemonList.toList()[it]}\n")
                else
                    w.write("${pokemonList[s]}\n")
            }
        }
    }
    w.flush()
}