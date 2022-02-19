package kotlinFile


fun main() {

    val nm = readLine()!!.split(" ")
    val n = IntArray(nm[0].toInt() + 1)

    fun findParent(x: Int): Int {
        return if (x == n[x]) n[x] else findParent(n[x]).also {
            n[x] = it
        }
    }

    fun union(a: Int, b: Int) {
        val ap = findParent(a)
        val bp = findParent(b)
        n[bp] = ap
    }

    fun check(a: Int, b: Int) {
        val ap = findParent(a)
        val bp = findParent(b)
        if (ap != bp) println("NO") else println("YES")
    }

    for (i in n.indices) {
        n[i] = i
    }

    for (i in 0 until nm[1].toInt()) {
        val commands = readLine()!!.split(" ")
        val command = commands[0].toInt()

        val a = commands[1].toInt()
        val b = commands[2].toInt()

        if (command == 0) {
            union(a, b)
        } else {
            check(a, b)
        }
    }
}


