package problem15649

fun main() {
    System.out.bufferedWriter().use { w ->
        fun search(n: Int, m: Int, visit: List<Int> = emptyList()) {
            if (m == 0) {
                for (item in visit) {
                    w.write("$item ")
                }
                w.write("\n")
            } else {
                for (i in 1..n) {
                    if (!visit.contains(i)) {
                        search(n, m.minus(1), visit.plus(i))
                    }
                }
            }
        }

        readln().split(' ').apply { search(get(0).toInt(), get(1).toInt()) }
        w.flush()
    }
}

