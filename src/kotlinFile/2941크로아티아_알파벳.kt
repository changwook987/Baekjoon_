package kotlinFile

fun main() {
    var str = readLine()!!
    str = str.replace("c=","1")
    str = str.replace("c-","1")
    str = str.replace("dz=","1")
    str = str.replace("d-","1")
    str = str.replace("lj","1")
    str = str.replace("nj","1")
    str = str.replace("s=","1")
    str = str.replace("z=","1")

    println(str.length)
}