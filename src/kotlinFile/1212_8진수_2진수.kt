package kotlinFile

fun main() {
    val int = readLine()!!
    for (i in int.indices) {
        if (i == 0)
            print(int[i].toString().toInt(8).toString(2))
        else
            print(int[i].toString().toInt(8).toString(2).padStart(3, '0'))
    }
}