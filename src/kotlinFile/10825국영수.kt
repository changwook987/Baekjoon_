package kotlinFile

fun main() {
    println(List(readLine()!!.toInt()) { Student(readLine()!!) }.sortedWith(
        compareBy({ 100 - it.ko }, { it.en }, { 100 - it.math }, { it.name })
    ).joinToString("\n") { it.name })
}

class Student(val name: String, val ko: Int, val en: Int, val math: Int) {
    constructor(s: String) : this(
        s.split(" ")[0], s.split(" ")[1].toInt(), s.split(" ")[2].toInt(), s.split(" ")[3].toInt()
    )
}