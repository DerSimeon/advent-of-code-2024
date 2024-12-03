import kotlin.math.abs

fun main() {
    fun checkLine(numbers: List<Int>): Boolean {
        if (numbers.sorted() != numbers && numbers.sortedDescending() != numbers) return false
        val diffs = numbers.zipWithNext().map { (a, b) -> abs(a - b) }
        return (diffs.all { it in 1..3 })
    }

    fun any(list: List<Int>, check: (List<Int>) -> Boolean): Boolean {
        return list.indices.any { check(list.take(it) + list.drop(it + 1)) }
    }

    fun part1(input: List<String>): Int {
        return input.count { checkLine(it.split(" ").map { num -> num.toInt() }) }
    }

    fun part2(input: List<String>): Int {
        return input.count {
            checkLine(it.split(" ").map { num -> num.toInt() }) || any(
                it.split(" ").map { num -> num.toInt() }, ::checkLine
            )
        }
    }


    val input = readInput("Day02")

    part1(input).println()
    part2(input).println()
}
