package com.problems.p130;


class Solution {
    public int[] nodes = null;
    public boolean[] isEdge = null;

    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'O', 'X', 'X', 'O', 'X'},
//                {'X', 'O', 'O', 'X', 'O'},
//                {'X', 'O', 'X', 'O', 'X'},
//                {'O', 'X', 'O', 'O', 'O'},
//                {'X', 'X', 'O', 'X', 'O'}};

        char[][] board = new char[][]{
                {'O', 'X', 'X', 'X', 'X', 'X', 'O', 'O'},
                {'O', 'O', 'O', 'X', 'X', 'X', 'X', 'O'},
                {'X', 'X', 'X', 'X', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'X', 'O', 'O', 'X', 'X', 'X'},
                {'O', 'X', 'O', 'X', 'X', 'X', 'O', 'O'},
                {'O', 'X', 'X', 'O', 'O', 'X', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'X', 'X', 'O', 'O'},
                {'O', 'X', 'X', 'X', 'X', 'O', 'X', 'X'}};
        new Solution().solve(board);

        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println("");
        }
    }

    public void solve(char[][] board) {
        if (board.length <= 1) {
            return;
        }
        int width = board[0].length;
        int height = board.length;
        int length = width * height;

        this.nodes = new int[length];
        this.isEdge = new boolean[length];

        for (int i = 0; i < length; i++) {
            nodes[i] = i;
            int w = i % width;
            int h = i / width;
            if (w == 0 || h == 0 || w == width - 1 || h == height - 1)
                this.isEdge[i] = true;
        }
        for (int i = 0; i < length; i++) {
            int w = i % width;
            int h = i / width;
            char c = board[h][w];
            if (c == 'O') {
                int down = h + 1;
                int right = w + 1;
                if (down < height && right < width) {
                    if (board[h][right] == 'O') {
                        union(i, i + 1);
                    }
                    if (board[down][w] == 'O') {
                        union(i, i + width);
                    }
                }
            }
        }
        for (int i = 0; i < length; i++) {
            int w = i % width;
            int h = i / width;
            char c = board[h][w];
            if (c == 'O') {
                int index = find(i);
                if (!isEdge[index]) {
                    board[h][w] = 'X';
                }
            }
        }


    }


    public int find(int m) {
        while (m != nodes[m]) {
            m = nodes[m];
        }
        return m;

    }

    public boolean check(int m, int n) {
        return this.find(m) == this.find(n);

    }

    public void union(int m, int n) {
        int mRoot = this.find(m);
        int nRoot = this.find(n);
        if (mRoot == nRoot) return;
        else {
            this.nodes[nRoot] = mRoot;

            if (this.isEdge[n] || this.isEdge[nRoot])
                this.isEdge[mRoot] = true;

        }

    }


}



