package kotlinFile

fun main() = repeat(readln().toInt()) {
    readln()
    readln().split(' ').map {
        it.toInt()
    }.run {
        println("${minOf { it }} ${maxOf { it }}")
    }
}