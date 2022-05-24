package problem11404

fun main() {
    val r = System.`in`.bufferedReader()
    val city = r.readLine().toInt()
    val map = Array(city) { y ->
        Array(city) { x ->
            if (x == y) 0
            else null
        }
    }

    repeat(r.readLine().toInt()) {
        val (a, b, c) = r.readLine().split(" ").map { it.toInt() - 1 }
        map[a][b]?.let {
            map[a][b] = minOf(it, c + 1)
        } ?: run {
            map[a][b] = c + 1
        }
    }

    repeat(city) { k -> //경유 노드
        repeat(city) { i ->
            repeat(city) e@{ j ->

                val newCost = run {
                    val a = map[i][k] ?: return@e
                    val b = map[k][j] ?: return@e

                    a + b
                }
                val oldCost = map[i][j]

                map[i][j] = if (oldCost == null) newCost
                else minOf(
                    newCost,    //k를 거친 경로
                    oldCost, //기존 경로
                )
            }
        }
    }

    System.out.bufferedWriter().use {

        for (row in map) {
            for (col in row) {
                it.append("${col ?: 0} ")
            }
            it.append("\n")
        }

        it.flush()
    }
}