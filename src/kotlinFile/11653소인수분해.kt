package kotlinFile

fun main() {
    var n = readLine()!!.toInt()
    var i = 2
    while (n != 1) {
        while (n.mod(i) == 0) {
            println(i)
            n /= i
        }
        i++
    }
}