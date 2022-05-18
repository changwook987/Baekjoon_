package problem21300

fun main() = println(with(java.util.Scanner(System.`in`)) { List(6) { nextInt() }.sum() } * 5)