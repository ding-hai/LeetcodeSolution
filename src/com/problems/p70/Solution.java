package com.problems.p70;

class Solution {
    //kind[i] = kind[i-1]+ kind[i-2] 通过递归调用树推
    // 只依赖前两个

    //用数组存储之前所有的
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] kind = new int[n + 1]; //kind[i] 代表i阶的走法
        kind[1] = 1;
        kind[2] = 2;
        for (int i = 3; i < n+1; i++) {
            kind[i] = kind[i - 1] + kind[i - 2];
        }
        return kind[n];
    }


    //只存前两个
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1;
        int pre1 = 2;
        int current = 0;
        for (int i = 3; i < n+1; i++) {
            current = pre1 + pre2;
            pre2 = pre1;
            pre1 = current;
        }
        return current;
    }



    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs2(10));
    }



}