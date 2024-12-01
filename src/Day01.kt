import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (left, right) = input.splitInput()

        return left.sorted().zip(right.sorted()).sumOf { (a, b) -> abs(a - b) }
    }

    fun part2(input: List<String>): Int {

        val (leftList, rightList) = input.splitInput()
        return leftList.sumOf { left -> left * rightList.count { left == it } }
    }

    val input = readInput("Day01")

    part1(input).println()
    part2(input).println()
}
