package kotlinFile

fun main() {
    //검색에서 실패했을 경우 어디부터 다시 검색을 시작하면 되는지 알려주는 배열
    fun kmp(pat: String): IntArray {
        val n = pat.length
        val arr = IntArray(n + 1)
        var (i, j) = -1 to 0

        arr[j] = i
        while (j < n) {
            if (i == -1 || pat[i] == pat[j])
                arr[++j] = ++i
            else i = arr[i]
        }
        return arr
    }

    fun findPattern(str: String, pat: String): List<Int> {
        val list = ArrayList<Int>()
        val arr = kmp(pat)
        val (n, m) = str.length to pat.length
        var (i, j) = 0 to 0

        while (i < n) {
            if (j == -1 || str[i] == pat[j]) {
                i++
                j++
            } else {
                //틀렸을 경우 배열에 나와있는 다시 검색을 시작할 곳으로 이동
                j = arr[j]
            }

            if (j == m) {
                list += i - m + 1
                j = arr[j]
            }
        }

        return list
    }

    System.out.bufferedWriter().use { w ->
        findPattern(readln(), readln()).let {
            w.appendLine("${it.size}")
            for (i in it) {
                w.appendLine("$i")
            }
        }
        w.flush()
    }
}