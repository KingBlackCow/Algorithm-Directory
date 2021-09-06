package Backtracking;

import java.util.HashMap;
import java.util.Map;

class Programmers_단체사진찍기 {
    static String[] str;
    static Map<Character, Integer> map;
    static int[] res;
    static boolean[] visit;
    static int cnt;
    static int answer;
    public int solution(int n, String[] data) {
        answer = 0;
        str = data;
        res = new int[8];
        visit = new boolean[8];
        cnt = 0;
        map = new HashMap<>();
        map.put('A',1);
        map.put('C',2);
        map.put('F',3);
        map.put('J',4);
        map.put('M',5);
        map.put('N',6);
        map.put('R',7);
        map.put('T',8);
        dfs(0);
        return answer;
    }

    static void dfs(int x){
        if(x==8){
            if(check()){
                answer++;
            }
            return;
        }

        for(int i= 0; i<8; i++){
            if(!visit[i]){
                visit[i] = true;
                res[x] = i+1;
                dfs(x+1);
                visit[i] = false;
            }
        }
    }
    static boolean check(){
        int senFirst = 0;
        int senSecond = 0;
        for(String s: str){
            int first = map.get(s.charAt(0));
            int second = map.get(s.charAt(2));
            char op = s.charAt(3);
            int compare = s.charAt(4)-'0'+1;

            for(int i = 0;i<8; i++){
                if(res[i] == first){
                    senFirst = i+1;
                }else if(res[i] == second){
                    senSecond = i+1;
                }
            }

            if(op=='='){
                if(Math.abs(senFirst-senSecond)!=compare){
                    return false;
                }
            }else if(op=='>'){
                if(Math.abs(senFirst-senSecond)<=compare){
                    return false;
                }
            }else{
                if(Math.abs(senFirst-senSecond)>=compare){
                    return false;
                }
            }
        }
        return true;
    }
}