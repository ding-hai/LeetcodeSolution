package com.problems.p62;

class Solution {
    public int uniquePaths(int m, int n) {
        //n 行  m列
        int[][] T = new int[n][m];
        T[n-1][m-1] = 1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int nexRow = i+1;
                int nextCol = j+1;
                if(nexRow>=n && nextCol<m){
                    T[i][j] = T[i][nextCol];
                }else if(nexRow<n && nextCol>=m){
                    T[i][j] = T[nexRow][j];
                }else if(nexRow<n && nextCol<m){
                    T[i][j] = T[i+1][j] + T[i][j+1];
                }
            }
        }
        return  T[0][0];
    }
}
