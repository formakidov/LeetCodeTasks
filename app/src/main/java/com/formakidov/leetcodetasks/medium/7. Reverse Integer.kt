package com.formakidov.leetcodetasks.medium

/*
7. Reverse Integer
Medium
Topics
premium lock icon
Companies
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-2^31 <= x <= 2^31 - 1
 */
class Solution7 {
    fun reverse(x: Int): Int {
        if (x == 0) return 0
        val negative: Boolean
        var temp = if (x < 0) {
            negative = true
            x*-1
        } else {
            negative = false
            x
        }

        var result = 0
        while (temp > 0) {
            val digit = temp % 10
            val tempResult = result * 10 + digit
            if (result != (tempResult - digit) / 10) {
                return 0
            }
            result = tempResult
            temp /= 10
        }

        return if (negative) -result else result
    }
}

fun main() {
    val solution = Solution7()

    fun test(value: Int, expected: Int) {
        val result = solution.reverse(value)
        if (result == expected) {
            println("✅ Test passed for value: $value. Expected: $expected, Got: $result")
        } else {
            println("❌ Test FAILED for value: $value. Expected: $expected, Got: \u001B[31m$result\u001B[0m")
        }
    }

    test(1534236469, 0)
    test(123, 321)
    test(-123, -321)
    test(120, 21)
    test(-120, -21)
    test(0, 0)
    test(-2147483648, 0)
    test(2147483647, 0)
    test(1, 1)
    test(-1, -1)
    test(1000000003, 0)
    test(-1000000003, 0)
}
