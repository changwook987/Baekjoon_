package problem9461

fun main() {
    val t = readln().toInt()

    val arr = LongArray(101)

    arr[1] = 1
    arr[2] = 1
    arr[3] = 1
    arr[4] = 2
    arr[5] = 2

    fun get(n: Int): Long {
        if (arr[n] == 0L) {
            arr[n] = get(n - 1) + get(n - 5)
        }
        return arr[n]
    }

    repeat(t) {
        val n = readln().toInt()
        println(get(n))
    }
}