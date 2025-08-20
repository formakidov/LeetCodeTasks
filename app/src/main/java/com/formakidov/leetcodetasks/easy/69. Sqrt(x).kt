package com.formakidov.leetcodetasks.easy

/*
69. Sqrt(x)
Easy
Topics
Companies
Hint
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.


Constraints:

0 <= x <= 2^31 - 1
 */

class SqrtSolution {

    fun mySqrt(x: Int): Int {
        if (x < 2) return x
        var left = 1
        var right = x

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (mid > x / mid) { // avoids int overflow
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right
    }
}

fun main() {
    testMySqrt(x = 17, expected = 4)
    testMySqrt(x = 4, expected = 2)
    testMySqrt(x = 8, expected = 2)
    testMySqrt(x = 0, expected = 0)
    testMySqrt(x = 1, expected = 1)
    testMySqrt(x = 9, expected = 3)
    testMySqrt(x = 2, expected = 1)
    testMySqrt(x = 2147483647, expected = 46340)
    testMySqrt(x = 2147395600, expected = 46340) // 46340 * 46340
}

private fun testMySqrt(x: Int, expected: Int) {
    val solution = SqrtSolution()
    val result = solution.mySqrt(x)


    if (result == expected) {
        println("\u001B[32mPASSED\u001B[0m: For input x = $x, expected $expected, got $result")
    } else {
        println(
            "\u001B[31mFAILED\u001B[0m: For input x = $x, expected $expected, got $result"
        )
    }
}
