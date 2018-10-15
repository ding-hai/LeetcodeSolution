package com.dinghai.p684;

class Solution {
    private int[] bset = null;

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] pair = new Solution().findRedundantConnection(edges);

        System.out.println(pair[0] + "-" + pair[1]);
    }


    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        this.bset = new int[n + 1];
        int[] returnPair = null;
        for (int i = 0; i < n+1; i++) {
            bset[i] = i ;
        }

        for (int i = 0; i < n; i++) {

            int[] pair = edges[i];
            boolean isInSet = union(pair[0], pair[1]);
            if (isInSet) {
                returnPair = pair;
            }
        }
        return returnPair;
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

    private boolean union(int m, int n) {
        int mroot = find(m);
        int nroot = find(n);
        if (mroot == nroot) {
            return true;
        }
        bset[nroot] = mroot;
        return false;
    }

}