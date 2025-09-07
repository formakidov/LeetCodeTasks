package com.formakidov.leetcodetasks.medium

import java.math.BigInteger

/*
43. Multiply Strings
Medium
Topics
premium lock icon
Companies
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
 

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
*/

class Solution43 {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") {
            return "0"
        }

        val array = IntArray(num1.length + num2.length)

        num1.forEachIndexed { index1, char1 ->
            num2.forEachIndexed { index2, char2 ->
                array[index1 + index2 + 1] += (char1 - '0') * (char2 - '0')
            }
        }

        for (i in array.size - 1 downTo 1) {
            array[i - 1] += array[i] / 10
            array[i] = array[i] % 10
        }

        return array.joinToString(separator = "").removePrefix("0")
    }
}

fun main() {
    testMultiply("2", "3", "6")
    testMultiply("123", "456", "56088")
    testMultiply("0", "52", "0")
    testMultiply("999", "999", "998001")
    testMultiply("1", "1", "1")
    testMultiply("10", "10", "100")
    testMultiply("100", "0", "0")
    testMultiply("0", "100", "0")
    testMultiply("9", "9", "81")
    testMultiply("123456789", "987654321", "121932631112635269")
    testMultiply("11111111111111111111", "11111111111111111111", "123456790123456790120987654320987654321")
    testMultiply("5", "12345678901234567890", "61728394506172839450")
    testMultiply("100000000000000000000", "100000000000000000000", "10000000000000000000000000000000000000000")
}

private fun testMultiply(num1: String, num2: String, expected: String) {
    val solution = Solution43()
    val result = solution.multiply(num1, num2)
    if (result == expected) {
        println("\u001B[32mPASSED\u001B[0m: For input num1 = $num1, num2 = $num2, expected $expected, got $result")
    } else {
        println(
            "\u001B[31mFAILED\u001B[0m: For input num1 = $num1, num2 = $num2, expected $expected, got $result"
        )
    }
}
