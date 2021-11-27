package kotlinFile

fun main() {
    val fine = listOf('I', 'O', 'S', 'H', 'Z', 'X', 'N')
    println(if (readLine()!!.filterNot { fine.contains(it) }.isEmpty()) "YES" else "NO")
}