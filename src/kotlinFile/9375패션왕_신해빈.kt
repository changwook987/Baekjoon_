package kotlinFile

fun main() {
    val w = System.out.bufferedWriter()
    val t = readln().toInt()

    repeat(t) {
        val n = readln().toInt()
        var tot = 1

        if (n == 0) {
            tot = 0
        } else {
            val map = HashMap<String, Int>()

            repeat(n) {
                val type = readln().split(" ")[1]
                map[type] = map.getOrDefault(type, 0) + 1
            }

            for ((_, i) in map) {
                tot *= i + 1
            }

            tot--
        }
        w.appendLine("$tot")
    }
    w.flush()
}