package kotlinFile

fun main() {
    data class Node(
        val value: Int,
        var parent: Node? = null,
        var left: Node? = null,
        var right: Node? = null
    )

    class BinarySearchTree {
        val head = Node(-1)

        operator fun plusAssign(node: Int) {
            var cur = head

            while (true) {
                if (cur.value < node) {
                    if (cur.right == null) {
                        cur.right = Node(node)
                        break
                    } else {

                        cur = cur.right!!

                    }
                } else if (cur.value > node) {
                    if (cur.left == null) {
                        cur.left = Node(node)
                        break
                    } else {

                        cur = cur.left!!

                    }
                }
            }
        }

        fun search(node: Node? = head.right) {
            node ?: return

            node.left?.let { search(it) }
            node.right?.let { search(it) }
            println(node.value)
        }
    }

    val list = System.`in`.bufferedReader().readLines().map { it.toInt() }
    val tree = BinarySearchTree()

    list.forEach {
        tree += it
    }

    tree.search()
}