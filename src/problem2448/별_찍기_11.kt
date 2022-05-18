package problem2448

fun main() {
    val n = readln().toInt()
    val star = List(n) { BooleanArray(n * 2) }

    fun write(size: Int = n, x: Int = 0, y: Int = 0) {
        if (size == 3) {
            for ((i, value) in listOf("  *  ", " * * ", "*****").withIndex()) {
                for ((j, c) in value.withIndex()) {
                    star[y + i][x + j] = c == '*'
                }
            }
        } else {
            write(size / 2, x + size / 2, y)
            write(size / 2, x, y + size / 2)
            write(size / 2, x + size, y + size / 2)
        }
    }

    write()

    System.out.bufferedWriter().use {
        for (i in star) {
            for (j in i) {
                it.append(if (j) '*' else ' ')
            }
            it.append('\n')
        }
        it.flush()
    }
}