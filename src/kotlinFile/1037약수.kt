package kotlinFile

import java.util.*

fun main() {
    val sc = (Scanner(System.`in`))
    List(sc.nextInt()) { sc.nextInt() }.sorted().apply {
        println(first().times(last()))
    }
}