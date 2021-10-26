package kotlinFile

fun main() {
    var cnt = 0
    for (i in 1..readLine()!!.toInt()) {
        for (j in 0..i) {
            cnt += i.plus(j)
        }
    }
    println(cnt)
}