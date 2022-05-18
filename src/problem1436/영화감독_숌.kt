package problem1436

fun main() {
    val n = readln().toInt()

    var i = 0
    var cnt = 0

    fun Int.isAvailable(): Boolean {
        var j = this
        var c = 0

        while (j != 0 && c != 3) {
            if (j % 10 == 6) {
                c++
            } else {
                c = 0
            }
            j /= 10
        }

        return c == 3
    }

    while (cnt < n) {
        i++
        while (!i.isAvailable()) {
            i++
        }
        cnt++
    }

    println(i)
}