package com.problems.p64;

class Solution {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        int[][] T = new int[height][width];
        T[height-1][width-1] = grid[height-1][width-1];

        for(int i=height-1;i>=0;i--){
            for(int j=width-1;j>=0;j--){
                int downIndex = i+1;
                int rightIndex = j+1;
                if(downIndex>=height && rightIndex<width){
                    T[i][j] = grid[i][j]+T[i][rightIndex];
                    continue;
                }
                if(downIndex<height && rightIndex>=width ) {
                    T[i][j] = grid[i][j]+ T[downIndex][j];
                    continue;
                }

                if(downIndex<height && rightIndex<width ) {
                    T[i][j] = grid[i][j]+ Math.min(T[i][rightIndex],T[downIndex][j]);
                }

            }

        }
        return T[0][0];
    }
}
