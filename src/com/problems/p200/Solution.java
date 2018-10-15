package com.dinghai.p200;

class Solution {
    private int[] bset = null;


    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println(new Solution().numIslands(grid));

    }

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int height = grid.length;
        if (height == 0) {
            return 0;
        }
        int width = grid[0].length;

        int length = width * height;
        bset = new int[length];

        for (int i = 0; i < length; i++) {
            int w = i % width;
            int h = i / width;
            char c = grid[h][w];
            if (c == '1') {
                bset[i] = i;
            } else {
                bset[i] = -1;
            }

        }

        for (int i = 0; i < length; i++) {
            int w = i % width;
            int h = i / width;
            if (grid[h][w] == '1') {
                int down = h + 1;
                int right = w + 1;

                if (right < width) {
                    if (grid[h][right] == '1') {
                        union(i, i + 1);
                    }
                }
                if (down < height) {

                    if (grid[down][w] == '1') {
                        union(i, i + width);
                    }
                }
            }
        }

        int islandCount = 0;
        for (int i = 0; i < length; i++) {
            int item = bset[i];
            if (i == item) {
                islandCount++;
            }
        }


        return islandCount;
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