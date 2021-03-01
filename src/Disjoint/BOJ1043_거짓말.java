import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, party;
    static int[] parent;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        party = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        int partyNum = party;
        st = new StringTokenizer(br.readLine());
        int trueMan = Integer.parseInt(st.nextToken());
        List<Integer> listTrue = new ArrayList<>();
        for (int i = 0; i < trueMan; i++) {
            listTrue.add(Integer.parseInt(st.nextToken()));
        }


        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        List<Integer> list[] = new ArrayList[party];
        for (int i = 0; i < party; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < party; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j < num - 1; j++) {
                for (int k = j + 1; k < num; k++) {
                    union(list[i].get(j), list[i].get(k));
                }
            }
        }


        for (int i = 0; i < n+1; i++) {
            parent[i] = find(i);
        }


        List<Integer> listNot=new ArrayList<>();
        for (int i = 0; i < listTrue.size(); i++) {
            listNot.add(listTrue.get(i));
            for (int j = 0; j < parent.length; j++) {
                if(parent[listTrue.get(i)]==parent[j]){
                    if(!listNot.contains(j)){
                        listNot.add(j);
                    }
                }
            }
        }
        int res=0;
        for (int i = 0; i < party; i++) {
            boolean success=true;
            for (Integer j:list[i]) {
                if(listNot.contains(j)){
                    success=false;
                    break;
                }
            }
            if(success)res++;
        }

        System.out.println(res);
    }


    public static int find(int a) {
        if (a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            parent[aRoot] = b;
        } else {
            return;
        }
    }
}

