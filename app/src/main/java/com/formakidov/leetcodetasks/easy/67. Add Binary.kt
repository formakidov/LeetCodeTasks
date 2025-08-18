package com.formakidov.leetcodetasks.easy

/*
67. Add Binary
Easy
Topics
premium lock icon
Companies
Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
 */

class AddBinarySolution {
    fun addBinary(a: String, b: String): String {
        val result = StringBuilder()
        var i = a.length - 1
        var j = b.length - 1
        var carry = 0

        while (i >= 0 || j >= 0) {
            var sum = carry
            if (i >= 0) {
                sum += getInt(a[i--])
            }
            if (j >= 0) {
                sum += getInt(b[j--])
            }
            result.append(sum % 2)
            carry = sum / 2
        }

        if (carry != 0) result.append(carry)

        return result.reverse().toString()
    }

    private fun getInt(ch: Char) = if (ch == '0') 0 else 1
}

fun main() {
    testAddBinary("11", "1", "100")
    testAddBinary("1010", "1011", "10101")
    testAddBinary("1111", "1111", "11110")
    testAddBinary("0", "0", "0")
    testAddBinary("1", "0", "1")
    testAddBinary("0", "1", "1")
}

private fun testAddBinary(a: String, b: String, expected: String) {
    val solution = AddBinarySolution()
    val result = solution.addBinary(a, b)
    if (result == expected) {
        println("\u001B[32mPASSED\u001B[0m: For input a = \"$a\", b = \"$b\", expected \"$expected\", got \"$result\"")
    } else {
        println(
            "\u001B[31mFAILED\u001B[0m: For input a = \"$a\", b = \"$b\", expected \"$expected\", got \"$result\""
        )
    }
}
