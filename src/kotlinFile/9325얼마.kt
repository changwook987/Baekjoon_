package kotlinFile

fun main() {
    var result = emptyArray<Int>()

    repeat(readLine()!!.toInt()) {
        var prise = readLine()!!.toInt()

        repeat(readLine()!!.toInt()) {
            readLine()!!.split(' ').apply {
                prise += get(0).toInt().times(get(1).toInt())
            }
        }
        result = result.plus(prise)
    }
    for(i in result){
        println(i)
    }
}