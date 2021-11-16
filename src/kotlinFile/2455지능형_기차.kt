package kotlinFile

fun main() {
    var max = 0
    var p = 0
    repeat(4) {
        p = readLine()!!.split(' ').run { p - get(0).toInt() + get(1).toInt() }
        max = p.run { if (max > this) max else this }
    }
    println(max)
}