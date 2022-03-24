package kotlinFile

fun main() {
    class Deck(
        val star: Int,
        val circle: Int,
        val square: Int,
        val triangle: Int,
    ) {
        override fun toString(): String {
            return "%03d%03d%03d%03d".format(star, circle, square, triangle)
        }
    }

    fun makeDeck(): Deck {
        java.util.StringTokenizer(readLine()).run {
            List(nextToken().toInt()) {
                nextToken().toInt()
            }.groupingBy { it }.eachCount()
        }.apply {
            return Deck(
                get(4) ?: 0,
                get(3) ?: 0,
                get(2) ?: 0,
                get(1) ?: 0
            )
        }
    }
    List(readLine()!!.toInt()) {
        val a = makeDeck().toString().toLong()
        val b = makeDeck().toString().toLong()

        if (a > b) {
            "A"
        } else if (a < b) {
            "B"
        } else {
            "D"
        }

    }.forEach {
        println(it)
    }
}

