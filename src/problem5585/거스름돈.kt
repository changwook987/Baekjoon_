package problem5585

fun main() {
    readLine()!!.toInt().apply {
        var c = 0
        var a = 1000 - this
        c += a.div(500)
        a %= 500
        c += a.div(100)
        a %= 100
        c += a.div(50)
        a %= 50
        c += a.div(10)
        a %= 10
        c += a.div(5)
        a %= 5
        c += a.div(1)
        println(c)
    }
}
