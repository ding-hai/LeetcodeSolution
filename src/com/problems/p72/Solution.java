package com.problems.p72;
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m==0 && n==0){
            return 0;
        }
        if(m==0){
            return n;
        }

        if(n==0){
            return m;
        }
        int[][] T = new int[m][n];

        T[0][0] = word1.charAt(0) == word2.charAt(0)?0:1;

        for(int i = 1;i<m;i++){
            if(word1.charAt(i) == word2.charAt(0))
                T[i][0] = i;
            else
                T[i][0] = T[i-1][0]+1;
        }

        for(int j = 1;j<n;j++){
            if(word1.charAt(0) == word2.charAt(j))
                T[0][j] = j;
            else
                T[0][j] = T[0][j-1]+1;
        }

        if(m==1 || n==1){
            return T[m-1][n-1];
        }



        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    T[i][j] = T[i-1][j-1] ;
                }else{

                    T[i][j] = Math.min(T[i-1][j],Math.min(T[i][j-1],T[i-1][j-1])) + 1;
                }

            }
        }
        return T[m-1][n-1];
    }
}
