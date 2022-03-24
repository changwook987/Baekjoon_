package kotlinFile

import java.util.*

fun main() {
    var input = StringTokenizer(readLine())

    val nodeCnt = input.nextToken().toInt()
    val edgeCnt = input.nextToken().toInt()

    val startNode = input.nextToken().toInt()

    fun dfs(graph: LinkedHashMap<Int, LinkedList<Int>>, v: Int, visited: LinkedList<Int>) {
        visited.add(v) //해당 노드를 방문했다고 표시
        print("$v ")
        for (j in graph[v]!!) {
            if (!visited.contains(j)) { //visited[j]==0
                dfs(graph, j, visited)
            }
        }
    }

    fun bfs(graph: LinkedHashMap<Int, LinkedList<Int>>, visited: LinkedList<Int>, toVisit: Queue<Int>) {
        val v = toVisit.poll() ?: return

        if (!visited.contains(v)) {
            print("$v ")
            visited.add(v)
            graph[v]?.forEach {
                if (!visited.contains(it) && !toVisit.contains(it)) {
                    toVisit.offer(it)
                }
            }
            bfs(graph, visited, toVisit)
        }
    }

    val graph = LinkedHashMap<Int, LinkedList<Int>>()

    for (i in 1..nodeCnt) {
        graph[i] = LinkedList()
    }

    repeat(edgeCnt) {
        input = StringTokenizer(readLine())

        val node = input.nextToken().toInt()
        val linkedNode = input.nextToken().toInt()

        graph[node]?.add(linkedNode)
        graph[linkedNode]?.add(node)
    }

    for (i in 1..nodeCnt) {
        graph[i]?.sort()
    }

    dfs(graph, startNode, LinkedList())
    println()


    val toVisit: Queue<Int> = LinkedList()
    toVisit.offer(startNode)
    bfs(graph, LinkedList(), toVisit)
    println()
}

