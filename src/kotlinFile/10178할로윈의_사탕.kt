package kotlinFile

fun main() {
    val n = readLine()!!.toInt()
    var candies: Array<List<Int>> = emptyArray()

    repeat(n) {
        readLine()!!.split(' ').apply {
            candies = candies.plus(
                listOf(
                    get(0).toInt().div(get(1).toInt()),
                    get(0).toInt().mod(get(1).toInt())
                )
            )
        }
    }
    for(i in candies){
        println("You get ${i[0]} piece(s) and your dad gets ${i[1]} piece(s).")
    }
}