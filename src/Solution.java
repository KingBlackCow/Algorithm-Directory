import java.util.*;
class Solution {
    static List<Integer> list =new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        //String[] cmd={"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        String[] cmd={"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};

        System.out.println( solution(8,2, cmd));
    }

    public static String solution(int n, int k, String[] cmd) {
        boolean[] answer = new boolean[n];
        for(int i = 0 ; i < n; i++){
            list.add(i);
        }
        int cnt = k;
        print(cnt);
        for(int cmdNum = 0 ; cmdNum < cmd.length; cmdNum++){
            String[] parse = cmd[cmdNum].split(" ");
            String order = parse[0];
            String move = "";
            if(order.equals("D") || order.equals("U")){
                move = parse[1];
            }
            cnt = perform(order, move, cnt);
            System.out.println("명령 : " +order+ " 움직임 "+ move);
            print(cnt);
        }
        for(Integer i: list){
            answer[i] = true;
        }
        String ans="";
        for(int i = 0 ; i < n; i++){
            if(answer[i]){
                ans+="O";
            }else{
                ans+="X";
            }
        }
        return ans;
    }

    static int perform(String order, String move, int cnt){
        if(order.equals("D")){
            cnt += Integer.parseInt(move);
        }else if(order.equals("U")){
            cnt -= Integer.parseInt(move);
        }else if(order.equals("C")){
            if(cnt != list.size()-1){
                stack.add(list.remove(cnt));
            }else{
                stack.add(list.remove(cnt));
                cnt--;
            }
        }else if(order.equals("Z")){
            int insert = stack.pop();
            System.out.println(insert);
            if(cnt<insert){
                cnt++;
            }
            list.add(insert);
            Collections.sort(list);
        }
        return cnt;
    }

    static void print(int cnt){
        System.out.println("현재 층수: "+cnt);
        System.out.print("리스트: ");
        for(Integer i:list){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.print("스택: ");
        for(Integer i:stack){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println();
    }
}