package com.formakidov.leetcodetasks.medium

/*
6. Zigzag Conversion
Attempted
Medium
Topics
premium lock icon
Companies
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N 5 9 13
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I


Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000





1P      7I       13N
2A   6L 8S   12I 14G
3Y 5A   9H 11R
4P     10I

indexes:
0         8           16
1      7  9       15  17
2    6   10     14    18
3  5     11  13       19
4        12           20
 */

class Solution6 {
    fun convert(s: String, numRows: Int): String {

        if (numRows == 1 || s.length <= numRows) return s

        var curRow = 0
        var iteratingDown = false
        val rows = MutableList(numRows) { StringBuilder() }

        for (char in s) {
            rows[curRow].append(char)

            if (curRow == 0 || curRow == numRows - 1) {
                iteratingDown = !iteratingDown
            }

            if (iteratingDown) curRow++ else curRow--
        }

        return rows.joinToString("")
    }
}

private fun testSolution6(s: String, numRows: Int, expected: String) {
    val result = Solution6().convert(s, numRows)
    if (result != expected) {
        println("\u001B[31mTest Failed\u001B[0m")
        println("Input s: \"$s\"")
        println("Input numRows: $numRows")
        println("Expected: \"$expected\"")
        println("Got: \"$result\"")
    } else {
        println("\u001B[32mTest Passed\u001B[0m")
    }
    println()
}

fun main() {
    testSolution6("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR")
    testSolution6("PAYPALISHIRING", 4, "PINALSIGYAHRPI")
    testSolution6("A", 1, "A")
    testSolution6("AB", 1, "AB")
    testSolution6("ABCDE", 4, "ABCED")
    testSolution6("ABC", 2, "ACB")
    testSolution6("A", 10, "A")
    testSolution6("P", 3, "P")
    testSolution6("AB", 2, "AB")
    testSolution6("ABC", 3, "ABC")
    testSolution6("ABCD", 2, "ACBD")
    testSolution6("ABCDEFGHIJKLMN", 5, "AIBHJCGKDFLNEM")
    testSolution6("PAYPALISHIRING", 1, "PAYPALISHIRING")
}
