package 구현;

import java.util.*;

class Programmers_수식최대화 {
    static List<Character> ops = new ArrayList<>();
    static List<Long> nums = new ArrayList<>();
    static Set<Character> set = new HashSet<>();
    static public long solution(String expression) {
        long answer = 0;
        String numStr = "";
        for(int i = 0; i< expression.length(); i++){
            char cnt = expression.charAt(i);
            if(cnt=='+'||cnt=='-'||cnt=='*'){
                ops.add(cnt);
                set.add(cnt);
                if(!numStr.equals("")){
                    nums.add(Long.parseLong(numStr));
                    numStr ="";
                    continue;
                }
            }
            numStr += cnt;
        }
        if(!numStr.equals("")){
            nums.add(Long.parseLong(numStr));
        }
        //print();
        answer = Math.max(answer, Math.abs(calc("+-*")));
        answer = Math.max(answer, Math.abs(calc("+*-")));
        answer = Math.max(answer, Math.abs(calc("-+*")));
        answer = Math.max(answer, Math.abs(calc("-*+")));
        answer = Math.max(answer, Math.abs(calc("*+-")));
        answer = Math.max(answer, Math.abs(calc("*-+")));
        return answer;
    }
    static long calc(String order){
        long ans = 0;
        List<Long> nums2 = new ArrayList<>(nums);
        List<Character> ops2 = new LinkedList<>(ops);

        for(int i = 0; i < order.length();i++){
            char op = order.charAt(i);
            int cnt = 0;
            for(int j = 0; j < ops2.size();j++){
                if(ops2.get(j)==op){
                    if(op=='+') {
                        long tmp = nums2.get(j-cnt) + nums2.get(j-cnt+1);
                        ans += tmp;
                        nums2.remove(j-cnt);
                        nums2.remove(j-cnt);
                        nums2.add(j-cnt,tmp);
                        cnt++;
                    }
                    else if(op=='-'){
                        long tmp=nums2.get(j-cnt) - nums2.get(j-cnt+1);
                        ans += tmp;
                        nums2.remove(j-cnt);
                        nums2.remove(j-cnt);
                        nums2.add(j-cnt,tmp);
                        cnt++;

                    }
                    else if(op=='*') {
                        long tmp=nums2.get(j-cnt) * nums2.get(j-cnt+1);
                        ans += tmp;
                        nums2.remove(j-cnt);
                        nums2.remove(j-cnt);
                        nums2.add(j-cnt,tmp);
                        cnt++;

                    }


                }
            }
            for(int j = 0; j < ops2.size(); j++){
                if(ops2.get(j)==op){
                    ops2.remove(j);
                    j--;
                }
            }
        }
        return nums2.get(0);
    }

    static void print(){
        for(Long i: nums){
            System.out.print(i+" ");
        }
        System.out.println();
        for(Character c: ops){
            System.out.print(c+" ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }
}