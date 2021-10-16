package kotlinFile

fun main() {
    val a = readLine()?.toInt() ?: return

    for (i in (1..9)) {
        println("$a * $i = ${a.times(i)}")
    }
}