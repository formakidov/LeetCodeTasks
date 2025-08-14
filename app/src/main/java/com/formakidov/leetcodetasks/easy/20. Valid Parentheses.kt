package com.formakidov.leetcodetasks.easy

/*
20. Valid Parentheses
Easy
Topics
premium lock icon
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false



Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */
fun isValid(s: String): Boolean {
    val stack = CharArray(s.length)
    var head = 0
    for (char in s) {
        when (char) {
            '(' -> stack[head++] = ')'
            '[' -> stack[head++] = ']'
            '{' -> stack[head++] = '}'
            else -> {
                if (head == 0 || stack[--head] != char) {
                    return false
                }
            }
        }
    }
    return head == 0
}

fun test(s: String, expected: Boolean) {
    val greenTick = "✅"
    val redCross = "❌"
    val result = isValid(s)
    val status = if (result == expected) greenTick else redCross
    println("Input: s = \"$s\", Output: $result, Expected: $expected $status")
}

fun main() {
    test("()", true)
    test("()[]{}", true)
    test("(]", false)
    test("([])", true)
    test("([)]", false)
    test("(((", false)
    test("]]}", false)
    test("{([])}", true)
    test("{[([{}])]}", true)
    test("{[([)]]}", false)
    test("[", false)
    test("}", false)
    test("(((((((((())))))))))", true)
    test("(((((((((])))))))))", false)
    test("(((((((((()))))))))", false)
    test("{[]()}", true)
}
