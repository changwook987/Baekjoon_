package kotlinFile

fun main() {
    val n = readln().toInt()
    for (i in 1..n) {
        for (j in 0 until n.minus(i)) {
            print(' ')
        }
        for (j in 0 until i.times(2).minus(1)) {
            print('*')
        }
        println()
    }
    for (i in n.minus(1) downTo 1) {
        for (j in 0 until n.minus(i)) {
            print(' ')
        }
        for (j in 0 until i.times(2).minus(1)) {
            print('*')
        }
        println()
    }
}