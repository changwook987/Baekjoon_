package kotlinFile

fun main() {
    fun r() = readln().toInt()
    val n = r()

    val list = List(n) { r() }
    val dp = IntArray(n)

    //맨 처음.
    if (n > 0) dp[0] = list[0]
    //두 번째
    if (n > 1) dp[1] = list[1] + dp[0]
    //세 번째
    if (n > 2) dp[2] = list[2] + maxOf(list[0], list[1])

    for (i in 3 until n) {
        dp[i] = maxOf(
            //2칸 오르기, 두 칸은 뛰어도 방해될 것이 없음
            dp[i - 2],
            //한 칸 오르기 지금 오르는 것이 세 번째 연달아 오르는 것 일 수 도 있으니
            //두 칸 뛰었다고 생각 하고 세 칸 전 + 한 칸 전을 더해준다
            dp[i - 3] + list[i - 1]
        ) + list[i]
    }

    println(dp[n - 1])
}