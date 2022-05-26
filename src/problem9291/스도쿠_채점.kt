package problem9291

fun main() {
    val t = readln().toInt()

    for (i in 1..t) {
        val map = Array(9) { readln().split(" ").map { it.toInt() } }

        fun check(x: Int, y: Int): Boolean {
            val arr1 = BooleanArray(10)
            val arr2 = BooleanArray(10)
            val arr3 = BooleanArray(10)

            repeat(9) { i ->
                if (arr1[map[i][x]]) return false
                arr1[map[i][x]] = true

                if (arr2[map[y][i]]) return false
                arr2[map[y][i]] = true

                if (arr3[map[(y / 3) * 3 + i / 3][(x / 3) * 3 + i % 3]]) return false
                arr3[map[(y / 3) * 3 + i / 3][(x / 3) * 3 + i % 3]] = true
            }
            return true
        }

        var flag = false

        for (k in 0 until 9) {
            for (j in 0 until 9) {
                if (!check(k, j)) {
                    flag = true
                }
            }
        }

        println("Case $i: ${if (flag) "IN" else ""}CORRECT")
        if (i != t) readln()
    }
}