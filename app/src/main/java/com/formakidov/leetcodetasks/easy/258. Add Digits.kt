package com.formakidov.leetcodetasks.easy

/*
258. Add Digits
Easy
Topics
premium lock icon
Companies
Hint
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.



Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.
Example 2:

Input: num = 0
Output: 0


Constraints:

0 <= num <= 2^31 - 1


Follow up: Could you do it without any loop/recursion in O(1) runtime?
 */

class Solution {
    fun addDigits(num: Int): Int {
        return when {
            num == 0 -> return 0
            num % 9 == 0 -> 9
            else -> num % 9
        }
    }
}

fun main() {
    testAddDigits(38, 2)
    testAddDigits(0, 0)
    testAddDigits(1, 1)
    testAddDigits(10, 1)
    testAddDigits(9, 9)
    testAddDigits(19, 1)
    testAddDigits(99, 9)
    testAddDigits(123, 6)
    testAddDigits(Int.MAX_VALUE, 1) // 2147483647 -> 2+1+4+7+4+8+3+6+4+7 = 46 -> 4+6 = 10 -> 1+0 = 1
}

private fun testAddDigits(num: Int, expected: Int) {
    val solution = Solution()
    val result = solution.addDigits(num)
    if (result == expected) {
        println("\u001B[32mPASSED\u001B[0m: For input $num, expected $expected, got $result")
    } else {
        println(
            "\u001B[31mFAILED\u001B[0m: For input $num, expected $expected, got $result"
        )
    }
}
