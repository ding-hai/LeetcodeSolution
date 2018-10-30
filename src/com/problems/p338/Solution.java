package com.problems.p338;

class Solution {
    public int[] countBits(int num) {
        if(num==0){
            return new int[]{0};
        }


        int length = num+1;
        int[] T = new int[length];
        T[0] = 0;
        T[1] = 1;
         if(num==1){
            return T;
        }

        int powerValue = 2;
        for(int i=2;i<length;i++){
            if(((1.0*i)/2)>powerValue){
                powerValue*=2;
            }
            int index = i%powerValue;
            //System.out.println(i+" "+powerValue+" "+index);
            T[i] = T[index] + 1;

        }
        return T;
    }


}
