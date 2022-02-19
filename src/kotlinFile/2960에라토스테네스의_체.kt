package kotlinFile

fun main() {
    val command = readLine()!!.split(" ")
    val n = command[0].toInt()
    val m = command[1].toInt()

    var cnt = 0
    val list = ArrayList(List(n) { it + 1 } - 1)
    val remove = ArrayList<Int>()

    while (cnt < m) {
        val k = list.first()
        var num = k

        while (num <= n && cnt < m) {
            remove += num
            list -= num
            while (num in remove) {
                num += k
            }
            cnt++
        }
    }
    println(remove.last())
}