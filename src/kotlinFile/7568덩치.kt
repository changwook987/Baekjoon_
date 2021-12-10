package kotlinFile

fun main() {
    val people = List(readLine()!!.toInt()) { Human(readLine()!!) }
    for (h in people) {
        for (c in people.minus(h)) {
            if(h > c) c.grade++
        }
    }
    for(h in people){
        print("${h.grade} ")
    }
}

class Human(val weight: Int, val height: Int) {
    var grade = 1

    constructor(str: String) : this(str.split(' ')[0].toInt(), str.split(' ')[1].toInt())

    operator fun compareTo(element: Human): Int {
        return if (weight > element.weight && height > element.height) {
            1
        } else if (weight == element.weight && height == element.weight) {
            0
        } else {
            -1
        }
    }
}