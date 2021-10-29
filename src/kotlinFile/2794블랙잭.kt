package kotlinFile

import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val goal = nextInt()
    val numbers = MutableList(n) { nextInt() }.sorted()

    search(numbers, goal)
    println(approximation)
}

private var approximation = -1
//영어로 근사값 이래요

private fun search(numbers: List<Int>, goal: Int, used: List<Int> = emptyList()) {
    for (i in numbers.indices) {
        if (!used.contains(i)) {
            val newUsed = used.plus(i)
            var add = 0

            if (newUsed.size == 3) {
                for (j in newUsed) {
                    add += numbers[j]
                }


                if (approximation == -1 || (add <= goal && goal.minus(add) < goal.minus(approximation))) {
                    approximation = add
                }
            } else {
                search(numbers, goal, newUsed)
            }
        }
    }
}