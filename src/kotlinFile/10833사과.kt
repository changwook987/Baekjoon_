package kotlinFile

fun main() {
    var apple = 0
    repeat(readLine()!!.toInt()) {
        readLine()!!.split(' ').apply {
            apple += get(1).toInt().mod(get(0).toInt())
        }
    }
    println(apple)
}