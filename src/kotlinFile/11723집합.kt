package kotlinFile

fun main() {
    val set = emptySet<Int>().toMutableSet()

    fun readCmd() = readln().split(" ")

    System.`in`.bufferedReader().use { r ->
        System.out.bufferedWriter().use { w ->
            repeat(r.readLine().toInt()) {
                readCmd().apply {
                    when (get(0)) {
                        "add" -> {
                            set.add(get(1).toInt())
                        }
                        "remove" -> {
                            set.remove(get(1).toInt())
                        }
                        "check" -> {
                            w.write(if (set.contains(get(1).toInt())) "1\n" else "0\n")
                        }
                        "toggle" -> {
                            if (set.contains(get(1).toInt())) {
                                set.remove(get(1).toInt())
                            } else {
                                set.add(get(1).toInt())
                            }
                        }
                        "all" -> {
                            repeat(20) {
                                set.add(it.plus(1))
                            }
                        }
                        "empty" -> {
                            set.clear()
                        }
                    }
                }
            }
            w.flush()
        }
    }
}