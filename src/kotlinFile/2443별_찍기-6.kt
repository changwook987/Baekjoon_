package kotlinFile

fun main() {
    val n = readLine()!!.toInt()
    for (i in n downTo 1) {
        for (j in 0 until n.minus(i)) {
            print(' ')
        }
        for (j in 0 until i.times(2).minus(1)) {
            print('*')
        }
        println()
    }
}