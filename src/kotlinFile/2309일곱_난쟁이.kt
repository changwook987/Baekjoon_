package kotlinFile

fun main() {
    fun solve(list: List<Int>, choose: List<Int> = emptyList()): List<Int> {
        if (choose.size == 7) {
            var add = 0
            choose.forEach { add += it }
            return if (add == 100) {
                choose.forEach {
                    println(it)
                }
                choose
            } else
                emptyList()
        }
        list.filter {
            try {
                choose.last() < it
            } catch (e: NoSuchElementException) {
                true
            }
        }.forEach {
            val a = solve(list, choose.plus(it))
            if (a.size == 7) {
                return a
            }
        }
        return emptyList()
    }
    solve(List(9) { readLine()!!.toInt() }.sorted())
}

