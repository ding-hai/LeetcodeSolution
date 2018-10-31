package com.problems.p413;

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        for(int i=0; i<A.length-1; i++){
            A[i] = A[i+1] - A[i];
        }

        int count = 1;
        int sum = 0;

        for(int i =0; i<A.length-2;i++){
            //System.out.println("A["+i+"]="+A[i]);
            if(A[i] == A[i+1]){
                count++;
                //System.out.println(count);
                if(i+1==A.length-2){
                    count++;
                    sum+=  0.5*(count*count-3*count+2);
                    count = 1;
                }
            }else{
                count++;
                sum+=  0.5*(count*count-3*count+2);
                count = 1;
                //System.out.println("sum="+sum);
            }



        }


        return sum;
    }
}
