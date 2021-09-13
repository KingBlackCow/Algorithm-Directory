package Stack;

import java.util.Stack;

class Programmers_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i)==')'){
                if(!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.add(s.charAt(i));
                }
            }else{
                stack.add(s.charAt(i));
            }
        }
        if(!stack.isEmpty())answer=false;
        return answer;
    }
}