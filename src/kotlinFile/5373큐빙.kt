package kotlinFile

fun main() = System.out.bufferedWriter().run {
    val t = readln().toInt()

    class Face(color: Char) {
        private val face = List(3) {
            Array(3) {
                color
            }
        }

        var upper: String
            get() = face[0].joinToString("")
            set(value) {
                for (i in face.indices) {
                    face[0][i] = value[i]
                }
            }
        var down: String
            get() = face[2].joinToString("")
            set(value) {
                for (i in face.indices) {
                    face[2][i] = value[i]
                }
            }
        var left: String
            get() = List(3) { face[it][0] }.joinToString("")
            set(value) {
                for (i in face.indices) {
                    face[i][0] = value[i]
                }
            }
        var right: String
            get() = List(3) { face[it][2] }.joinToString("")
            set(value) {
                for (i in face.indices) {
                    face[i][2] = value[i]
                }
            }

        fun show() {
            appendLine(face.joinToString("\n") { it.joinToString("") })
        }

        fun spinRight() {
            List(3) { y ->
                List(3) { x ->
                    face[2 - x][y]
                }.joinToString("")
            }.forEachIndexed { i, s ->
                for ((j, c) in s.withIndex()) {
                    face[i][j] = c
                }
            }
        }

        fun spinLeft() {
            List(3) { y ->
                List(3) { x ->
                    face[x][2 - y]
                }.joinToString("")
            }.forEachIndexed { i, s ->
                for ((j, c) in s.withIndex()) {
                    face[i][j] = c
                }
            }
        }
    }

    class Cube {
        val u = Face('w')
        val d = Face('y')
        val f = Face('r')
        val r = Face('b')
        val b = Face('o')
        val l = Face('g')

        fun doSpin(cmd: String) {
            val where = cmd[0]
            val how = cmd[1]

            if (how == '-')
                when (where) {
                    'U' -> spinUpperLeft()
                    'D' -> spinDownLeft()
                    'F' -> spinFrontLeft()
                    'B' -> spinBackLeft()
                    'L' -> spinLeftLeft()
                    'R' -> spinRightLeft()
                }
            else
                when (where) {
                    'U' -> spinUpperRight()
                    'D' -> spinDownRight()
                    'F' -> spinFrontRight()
                    'B' -> spinBackRight()
                    'L' -> spinLeftRight()
                    'R' -> spinRightRight()
                }
        }

        private fun spinUpperRight() {
            val tmp = f.upper
            f.upper = r.upper
            r.upper = b.upper
            b.upper = l.upper
            l.upper = tmp

            u.spinRight()
        }

        private fun spinUpperLeft() {
            val tmp = f.upper
            f.upper = l.upper
            l.upper = b.upper
            b.upper = r.upper
            r.upper = tmp

            u.spinLeft()
        }

        private fun spinDownRight() {
            val tmp = f.down
            f.down = l.down
            l.down = b.down
            b.down = r.down
            r.down = tmp

            d.spinRight()
        }

        private fun spinDownLeft() {
            val tmp = f.down
            f.down = r.down
            r.down = b.down
            b.down = l.down
            l.down = tmp

            d.spinLeft()
        }

        private fun spinLeftRight() {
            val tmp = f.left
            f.left = u.left
            u.left = b.right.reversed()
            b.right = d.left.reversed()
            d.left = tmp

            l.spinRight()
        }

        private fun spinLeftLeft() {
            val tmp = f.left
            f.left = d.left
            d.left = b.right.reversed()
            b.right = u.left.reversed()
            u.left = tmp

            l.spinLeft()
        }

        private fun spinRightRight() {
            val tmp = f.right
            f.right = d.right
            d.right = b.left.reversed()
            b.left = u.right.reversed()
            u.right = tmp

            r.spinRight()
        }

        private fun spinRightLeft() {
            val tmp = f.right
            f.right = u.right
            u.right = b.left.reversed()
            b.left = d.right.reversed()
            d.right = tmp

            r.spinLeft()
        }

        private fun spinFrontRight() {
            val tmp = u.down
            u.down = l.right.reversed()
            l.right = d.upper
            d.upper = r.left.reversed()
            r.left = tmp

            f.spinRight()
        }

        private fun spinFrontLeft() {
            val tmp = u.down
            u.down = r.left
            r.left = d.upper.reversed()
            d.upper = l.right
            l.right = tmp.reversed()

            f.spinLeft()
        }

        private fun spinBackRight() {
            val tmp = u.upper
            u.upper = r.right
            r.right = d.down.reversed()
            d.down = l.left
            l.left = tmp.reversed()

            b.spinRight()
        }

        private fun spinBackLeft() {
            val tmp = u.upper
            u.upper = l.left.reversed()
            l.left = d.down
            d.down = r.right.reversed()
            r.right = tmp

            b.spinLeft()
        }
    }
    repeat(t) {
        readln()
        val cube = Cube()
        val list = readln().split(" ")
        for (cmd in list) {
            cube.doSpin(cmd)
        }
        cube.u.show()
    }

    flush()
}