package com.problems.p22;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        List<String> result = new Solution().generateParenthesis(3);
        result.forEach(System.out::println);
    }


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", n, n, result);
        return result;
    }


    private void backtrack(String subString, int left, int right, List<String> result) {
        System.out.println(String.format("left:%d right:%d",left,right));
        if (left == 0 && right == 0) {
            result.add(subString);
        }

        if (left > 0) {
            System.out.println("添加左括号");
            backtrack(subString + "(", left - 1, right, result);
        }

        if (left < right) {
            System.out.println("添加右括号");
            backtrack(subString + ")", left, right - 1, result);
        }

    }
}