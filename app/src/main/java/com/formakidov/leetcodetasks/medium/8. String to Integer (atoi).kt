package com.formakidov.leetcodetasks.medium

/*
8. String to Integer (atoi)
Medium
Topics
premium lock icon
Companies
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then round the integer to remain in the range. Specifically, integers less than -2^31 should be rounded to -2^31, and integers greater than 2^31 - 1 should be rounded to 2^31 - 1.
Return the integer as the final result.

 

Example 1:

Input: s = "42"

Output: 42

Explanation:

The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
Example 2:

Input: s = " -042"

Output: -42

Explanation:

Step 1: "   -042" (leading whitespace is read and ignored)
            ^
Step 2: "   -042" ('-' is read, so the result should be negative)
             ^
Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
               ^
Example 3:

Input: s = "1337c0d3"

Output: 1337

Explanation:

Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
         ^
Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
             ^
Example 4:

Input: s = "0-1"

Output: 0

Explanation:

Step 1: "0-1" (no characters read because there is no leading whitespace)
         ^
Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
          ^
Example 5:

Input: s = "words and 987"

Output: 0

Explanation:

Reading stops at the first non-digit character 'w'.

 

Constraints:

0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 */

class Solution8 {
    fun myAtoi(s: String): Int {
        var sign = 1
        var counting = false
        var number = 0L
        val charToDigit = mapOf(
            '0' to 0, '1' to 1, '2' to 2, '3' to 3, '4' to 4, '5' to 5, '6' to 6, '7' to 7, '8' to 8, '9' to 9
        )

        for (i in s.indices) {
            val c = s[i]
            if (c == ' ') {
                if (counting) {
                    // finish counting, not a number
                    break
                } else {
                    // skip leading spaces
                }
            } else if (c == '-' && !counting) {
                sign = -1
                counting = true
            } else if (c == '+' && !counting) {
                sign = 1
                counting = true
            } else if (charToDigit.containsKey(c)) {
                counting = true
                number = number * 10 + charToDigit[c]!!
            } else {
                if (counting) {
                    // finish counting, not a number
                    break
                } else {
                    return 0
                }
            }

            if (sign == 1 && number > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE
            } else if (sign == -1 && number > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE
            }
        }

        return sign * (number.toInt())
    }
}

fun main() {
    testMyAtoi("9223372036854775808", 2147483647)
    testMyAtoi("-9223372036854775808", -2147483648)
    testMyAtoi("  000-42a1234", 0)
    testMyAtoi("   +0k", 0)
    testMyAtoi("42", 42)
    testMyAtoi("   -42", -42)
    testMyAtoi("1337c0d3", 1337)
    testMyAtoi("0-1", 0)
    testMyAtoi("words and 987", 0)
    testMyAtoi("", 0)
    testMyAtoi("+1", 1)
    testMyAtoi("2147483647", 2147483647)
    testMyAtoi("-2147483648", -2147483648)
    testMyAtoi("2147483648", 2147483647)
    testMyAtoi("-2147483649", -2147483648)
    testMyAtoi("  -0012a42", -12)
    testMyAtoi("   +0 123", 0)
    testMyAtoi("+-12", 0)
    testMyAtoi("-+12", 0)
    testMyAtoi("00000-42a1234", 0)
    testMyAtoi("  0000000000012345678", 12345678)
    testMyAtoi("0000000000000", 0)
    testMyAtoi("-5-", -5)
    testMyAtoi("123-", 123)
    testMyAtoi("21474836460", 2147483647)
}

private fun testMyAtoi(s: String, expected: Int) {
    val solution = Solution8()
    val result = solution.myAtoi(s)
    if (result == expected) {
        println("\u001B[32mPASSED\u001B[0m: For input \"$s\", expected $expected, got $result")
    } else {
        println(
            "\u001B[31mFAILED\u001B[0m: For input \"$s\", expected $expected, got $result"
        )
    }
}
