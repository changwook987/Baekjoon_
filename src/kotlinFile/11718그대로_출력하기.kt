package kotlinFile

import java.io.BufferedReader
import java.io.InputStreamReader
//이게 왜 됨?
fun main() {
    val strs = BufferedReader(InputStreamReader(System.`in`)).readLines()
    for (i in strs) println(i)
}