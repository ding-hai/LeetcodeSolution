package com.dinghai.p547;

class Solution {

    private int[] bset = null;


    public static void main(String[] args) {
        int[][] M = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 1, 1}};
        System.out.println(new Solution().findCircleNum(M));

    }

    public int findCircleNum(int[][] M) {
        if (M == null) {
            return 0;
        }
        int n = M.length;
        bset = new int[n];

        for (int i = 0; i < n; i++) {
            bset[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            int item = bset[i];
            if (item == i) {
                num++;
            }
        }
        return num;
    }

    private int find(int m) {
        int _m = m;
        if (this.bset == null) return -1;
        while (m != bset[m]) {
            m = bset[m];
        }
        //避免变成一个长链
        this.bset[_m] = m;
        return m;
    }

    private void union(int m, int n) {
        int mroot = find(m);
        int nroot = find(n);
        if (mroot == nroot) {
            return;
        }
        bset[nroot] = mroot;
    }
}