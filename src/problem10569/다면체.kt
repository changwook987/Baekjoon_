package problem10569

fun main(){
    var results = emptyArray<Int>()
    val n = readLine()!!.toInt()

    repeat(n){
        readLine()!!.split(' ').apply {
            results = results.plus(get(1).toInt().minus(get(0).toInt()).plus(2))
        }
    }
    for(i in results){
        println(i)
    }
}