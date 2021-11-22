package kotlinFile

fun main() {
    val n = r()
    val list = List(n[0] - 1) { readLine()!!.toInt().minus(1) }
    val meetingList = List(n[1]) { r() }
    val nodes = List(n[0]) { Node(it.plus(1)) }

    for (i in list.indices) {
        nodes[i.plus(1)].parent = nodes[list[i]]
    }
    for (i in meetingList) {
        val a = nodes[i[0].minus(1)].toRoot().reversed()
        val b = nodes[i[1].minus(1)].toRoot().reversed()

        var cur = 0
        while (a[cur] == b[cur]) {
            cur++
            if (!(cur < a.size && cur < b.size))
                break
        }
        println(a[cur.minus(1)])
    }
}

class Node(val id: Int) {
    var parent: Node? = null

    fun toRoot(): List<Int> {
        var cur = this
        val way = emptyList<Int>().toMutableList()
        while (cur.parent != null) {
            way.add(cur.id)
            cur = cur.parent!!
        }
        way.add(cur.id)
        return way
    }
}

fun r(): List<Int> {
    readLine()!!.split(' ').apply {
        return listOf(get(0).toInt(), get(1).toInt())
    }
}