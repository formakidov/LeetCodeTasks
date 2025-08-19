package com.formakidov.leetcodetasks.easy

/*
70. Climbing Stairs
Easy
Topics
premium lock icon
Companies
Hint
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45

11111

1112
...

122


======

n
...
...
...
n/2+n%2
 */

class ClimbingStairsSolution {

    val array = IntArray(46)
    fun climbStairs(n: Int): Int {
        if (n <= 2) {
            return n
        }
        with(array[n]) {
            if (this != 0) {
                return this
            }
        }
        val result = climbStairs(n - 1) + climbStairs(n - 2)
        array[n] = result
        return result
    }

    // uses general formula to calculate unique permutations, but it only works for smaller numbers and then overflows Int
//    fun climbStairs(n: Int): Int {
//        if (n >= 3) {
//            var totalVariations = 0
//            var amountOfOnes = n
//            var amountOfTwos = 0
//            (n downTo (n / 2 + n % 2)).forEach { i ->
//                totalVariations += countVariation(amountOfOnes, amountOfTwos)
//                amountOfOnes -= 2
//                amountOfTwos++
//            }
//            return totalVariations
//        } else {
//            return n
//        }
//    }
//
//    private fun countVariation(n1: Int, n2: Int): Int {
//        if (n1 == 0 || n2 == 0) return 1
//        val dividend = factorial(n1+n2)
//        val divisor = factorial(n1) * factorial(n2)
//        return dividend / divisor
//    }
//
//    private fun factorial(i: Int): Int {
//        var result = 1
//        for (j in 1..i) {
//            result *= j
//        }
//        return result
//    }
}

fun main() {
    testClimbStairs(1, 1)
    testClimbStairs(2, 2)
    testClimbStairs(3, 3)
    testClimbStairs(4, 5)
    testClimbStairs(5, 8)
    testClimbStairs(6, 13)
    testClimbStairs(7, 21)
    testClimbStairs(8, 34)
    testClimbStairs(9, 55)
    testClimbStairs(45, 1836311903)
}

private fun testClimbStairs(n: Int, expected: Int) {
    val solution = ClimbingStairsSolution()
    val result = solution.climbStairs(n)
    if (result == expected) {
        println("\u001B[32mPASSED\u001B[0m: For input n = $n, expected $expected, got $result")
    } else {
        println(
            "\u001B[31mFAILED\u001B[0m: For input n = $n, expected $expected, got $result"
        )
    }
}
