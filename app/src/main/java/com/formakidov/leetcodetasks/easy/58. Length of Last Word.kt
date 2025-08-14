package com.formakidov.leetcodetasks.easy

/*
58. Length of Last Word
Easy
Topics
premium lock icon
Companies
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.



Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.


Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.
 */

fun lengthOfLastWord(s: String): Int {
    if (s.isEmpty()) return 0 // special case (not specific to this task, but still good to have)

    var foundWord = false
    var startIndex = -1
    var endIndex = -1
    for (i in s.length - 1 downTo 0) {
        if (foundWord) {
            if (s[i] == ' ') {
                startIndex = i
                break
            }
        } else if (s[i] != ' ') {
            foundWord = true
            endIndex = i
        }
    }
    return if (foundWord) endIndex - startIndex else 0
}

fun main() {
    testLengthOfLastWord("Hello World", 5)
    testLengthOfLastWord("   fly me   to   the moon  ", 4)
    testLengthOfLastWord("luffy is still joyboy", 6)
    testLengthOfLastWord("a", 1)
    testLengthOfLastWord("a ", 1)
    testLengthOfLastWord(" b", 1)
    testLengthOfLastWord("  c  ", 1)
    testLengthOfLastWord("  ", 0)
    testLengthOfLastWord("word", 4)
    testLengthOfLastWord("  word  ", 4)
    testLengthOfLastWord("leading space", 5)
    testLengthOfLastWord("trailing space ", 5)
}

private fun testLengthOfLastWord(input: String, expected: Int) {
    val result = lengthOfLastWord(input)
    if (result == expected) {
        println("Input: \"$input\", Output: $result \u001B[32m(Correct)\u001B[0m")
    } else {
        println(
            "Input: \"$input\", Output: $result \u001B[31m(Incorrect)\u001B[0m, Expected: $expected"
        )
    }
}
