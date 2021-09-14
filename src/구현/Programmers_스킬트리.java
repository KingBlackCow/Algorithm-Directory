package 구현;

import java.util.*;

class Programmers_스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> set= new HashSet<>();
        List<Character> list = new LinkedList<>();
        for(int i = 0 ; i < skill.length(); i++){
            set.add(skill.charAt(i));
            list.add(skill.charAt(i));
        }

        for(String s : skill_trees){
            boolean flag = true;
            Queue<Character> q = new LinkedList<>(list);
            for(int i = 0; i< s.length();i++){
                if(set.contains(s.charAt(i))){
                    if(q.peek() == s.charAt(i)){
                        q.poll();
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                System.out.println(s);
                answer++;
            }
        }
        return answer;
    }
}