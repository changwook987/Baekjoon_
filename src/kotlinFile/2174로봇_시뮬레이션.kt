package kotlinFile

fun main() {
    val boundary: Boundary
    readIntList().apply {
        boundary = Boundary(
            Pos(1, 1),
            Pos(get(0), get(1))
        )
    }

    val robotCnt: Int
    val opCnt: Int

    readIntList().apply {
        robotCnt = get(0)
        opCnt = get(1)
    }

    val robotList = emptyList<Robot>().toMutableList()

    for (i in 1..robotCnt) {
        robotList.add(
            Robot(
                i,
                readPos()
            )
        )
    }

    val opList = List(opCnt) { readOp() }

    for (op in opList) {
        try {
            op.doOp(robotList, boundary)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return
        }
    }
    println("OK")
}

fun readPos(): Pos {
    readLine()!!.split(' ').apply {
        return Pos(
            get(0).toInt(), get(1).toInt(),
            if (get(2) == "N") {
                0
            } else if (get(2) == "E") {
                1
            } else if (get(2) == "S") {
                2
            } else {
                3
            }
        )
    }
}

fun readIntList(): List<Int> {
    readLine()!!.split(' ').apply {
        return listOf(get(0).toInt(), get(1).toInt())
    }
}

fun readOp(): Op {
    readLine()!!.split(' ').apply {
        return Op(
            get(0).toInt(),
            if (get(1) == "L") Operation.L
            else if (get(1) == "R") Operation.R
            else Operation.F,
            get(2).toInt()
        )
    }
}

class Boundary(private val pos1: Pos, private val pos2: Pos) {
    fun isInBoundary(robot: Robot): Boolean {
        return ((pos1.x..pos2.x).contains(robot.position.x) && (pos1.y..pos2.y).contains(robot.position.y))
    }
}

class Pos(var x: Int, var y: Int, var facing: Int = 0)

class Robot(
    private val robotNum: Int,
    var position: Pos
) {
    fun turnLeft() {
        position.facing += 7
        position.facing %= 4
    }

    fun turnRight() {
        position.facing += 5
        position.facing %= 4
    }

    fun goStraight(list: List<Robot>, boundary: Boundary) {
        when (position.facing) {
            0 -> {
                position.y++
            }
            1 -> {
                position.x++
            }
            2 -> {
                position.y--
            }
            3 -> {
                position.x--
            }
        }
        if (!boundary.isInBoundary(this))
            throw IllegalArgumentException("Robot $robotNum crashes into the wall")
        for (robot in list) {
            if (robot != this)
                if (robot.position.x == position.x && robot.position.y == position.y)
                    throw IllegalArgumentException("Robot $robotNum crashes into robot ${robot.robotNum}")
        }
    }
}

enum class Operation {
    L,
    R,
    F
}


class Op(
    private val robotNum: Int,
    private val operation: Operation,
    private val re: Int
) {
    fun doOp(robotList: List<Robot>, boundary: Boundary) {
        val robot = robotList[robotNum.minus(1)]

        repeat(re) {
            when (operation) {
                Operation.F -> {
                    robot.goStraight(robotList, boundary)
                }
                Operation.R -> {
                    robot.turnRight()
                }
                Operation.L -> {
                    robot.turnLeft()
                }
            }
        }
    }
}
