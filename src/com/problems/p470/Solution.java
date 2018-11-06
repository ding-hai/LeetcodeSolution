package com.problems.p470;
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {

        return  (rand5()<<1)+rand2();
    }

    private int rand5(){
        int x= 0;
        do{
            x = rand7();
        }while(x>5);

        return x;
    }

    private int rand2(){
        int x= 0;
        do{
            x = rand7();
        }while(x==7);

        return x%2-1;
    }
}
