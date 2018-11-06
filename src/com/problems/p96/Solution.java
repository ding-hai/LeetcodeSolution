package com.problems.p96;
class Solution {
    public int numTrees(int n) {

        int[] T = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        if(n<2){
            return T[n];
        }
        T[2] = 2;
        if(n<3){
            return T[n];
        }


        for(int i = 3;i<=n;i++){
            for(int j=1;j<=i;j++){
                T[i]+=T[i-j]*T[j-1];
            }
        }
        return T[n];
    }
}
