package problem2530

fun main() {
    var h: Int
    var m: Int
    var s: Int
    readLine()!!.split(' ').apply {
        h = get(0).toInt()
        m = get(1).toInt()
        s = get(2).toInt()
    }
    s += readLine()!!.toInt()
    m += s / 60
    s %= 60
    h += m / 60
    m %= 60
    h %= 24
    println("$h $m $s")
}