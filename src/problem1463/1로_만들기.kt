package problem1463

fun main() {
    val steps = mapOf(1 to 0).toMutableMap()

    //항상 n번 불러와짐
    fun toMakeOne(n: Int): Int {
        if (!steps.contains(n)) {
            var leastStep = Int.MAX_VALUE
            if (n.mod(3) == 0) {
                val n1 = toMakeOne(n.div(3))
                leastStep = if (n1 > leastStep) {
                    leastStep
                } else {
                    n1
                }
            }
            if (n.mod(2) == 0) {
                val n1 = toMakeOne(n.div(2))
                leastStep = if (n1 > leastStep) {
                    leastStep
                } else {
                    n1
                }
            }
            val n1 = toMakeOne(n.minus(1))
            leastStep = if (n1 > leastStep) {
                leastStep
            } else {
                n1
            }
            steps[n] = leastStep.plus(1)
        }
        return steps[n]!!
    }
    println(toMakeOne(readLine()!!.toInt()))
}