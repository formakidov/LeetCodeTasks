package com.formakidov.leetcodetasks.easy

/*
13. Roman to Integer
Easy

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/

fun romanToInt(s: String): Int {
    val romanMap = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    var result = 0
    var i = 0
    while (i < s.length) {
        if (i + 1 < s.length && romanMap[s[i]]!! < romanMap[s[i+1]]!!) {
            result += romanMap[s[i+1]]!! - romanMap[s[i]]!!
            i += 2
        } else {
            result += romanMap[s[i]]!!
            i += 1
        }
    }
    return result
}

fun main() {
    val testCases = mapOf(
        "III" to 3,
        "LVIII" to 58,
        "MCMXCIV" to 1994,
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000,
        "VI" to 6,
        "XVI" to 16,
        "CLXXIII" to 173,
        "MDCCLXXVI" to 1776,
        "IV" to 4,
        "IX" to 9,
        "XL" to 40,
        "XC" to 90,
        "CD" to 400,
        "CM" to 900,
        "XCIX" to 99,
        "CDXLIV" to 444,
        "CMXCIX" to 999,
        "MMXXIV" to 2024,
        "MMMCMXCIX" to 3999
    )

    var passed = 0
    var failed = 0

    println("--- Running Tests ---")
    testCases.forEach { (input, expected) ->
        try {
            val actual = romanToInt(input)
            if (actual == expected) {
                println("✅ PASSED: Input=\"$input\", Expected=$expected, Got=$actual")
                passed++
            } else {
                println("❌ FAILED: Input=\"$input\", Expected=$expected, Got=$actual")
                failed++
            }
        } catch (e: Exception) {
            println("💥 ERROR on input \"$input\": ${e.message}")
            failed++
        }
    }
    println("--- Test Summary ---")
    println("Total Tests: ${testCases.size}, Passed: $passed, Failed: $failed")
    println("--------------------")
}
