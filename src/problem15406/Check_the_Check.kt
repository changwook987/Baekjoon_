package problem15406

fun main() {
    var tot = 0
    while (true) {
        if (readln() != "TOTAL") {
            tot += readln().split(" ").map { it.toInt() }.reduce(Int::times)
        } else break
    }
    if (readln().toInt() > tot) {
        println("PROTEST")
    } else {
        println("PAY")
    }
}