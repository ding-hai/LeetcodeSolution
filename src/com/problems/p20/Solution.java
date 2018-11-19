package com.problems.p20;
import java.util.Stack;
class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();

        if(s.length()==0)return true;
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.empty())
                stack.push(c);
            else{
                char top = stack.peek();
                switch(top){
                    case '(':
                        if(c==')'){
                            stack.pop();
                        }else{
                            stack.push(c);
                        }
                        break;
                    case '{':
                        if(c=='}'){
                            stack.pop();
                        }else{
                            stack.push(c);
                        }
                        break;
                    case '[':
                        if(c==']'){
                            stack.pop();
                        }else{
                            stack.push(c);
                        }
                        break;

                }
            }
        }

        if(stack.empty())return true;
        return false;

    }
}
