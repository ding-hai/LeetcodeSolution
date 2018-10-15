package com.problems.p301;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// TODO: 18-5-14
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Stack<Character> leftBracketStack = new Stack<>();
        Stack<Character> rightBracketStack = new Stack<>();
        List<Integer> removeIndex = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c == '(') {
                leftBracketStack.push(c);
            } else if (c == ')') {
                if (leftBracketStack.size() > 0) {
                    leftBracketStack.pop();
                } else {
                    removeIndex.add(i);
                }
            }
        }
        if (leftBracketStack.size() > 0) {
            for (int i = 0; i < leftBracketStack.size(); i++) {

            }
        }

        System.out.println(removeIndex);
        return null;
    }

    public static void main(String[] args) {
        new Solution().removeInvalidParentheses(")()(a()");
    }
}