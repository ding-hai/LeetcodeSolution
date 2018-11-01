package com.problems.p712;

class Solution {
    public int minimumDeleteSum(String s1, String s2) {

        int m= s1.length();
        int n = s2.length();

        int[][]  T = new int[m+1][n+1];
        T[m][n] = 0;



        //i = m j:n->0
        for(int j=n-1;j>=0;j--){
            T[m][j] =  T[m][j+1]+s2.charAt(j);
        }


        //i = m->0 j:n
        for(int i=m-1;i>=0;i--){
            T[i][n] =  T[i+1][n] + s1.charAt(i);
        }


        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    T[i][j] = T[i+1][j+1];

                }else{
                    T[i][j] = Math.min(s1.charAt(i)+T[i+1][j],Math.min(s2.charAt(j)+T[i][j+1],s1.charAt(i)+s2.charAt(j)+T[i+1][j+1]));

                }
            }
        }

        return T[0][0];
    }
}
