import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m;
    static int[] parent;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            parent = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                parent[i] = i;
            }

            List<Node> list=new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                list.add(new Node(x,y,r));
            }
            for (int i = 0; i < n; i++) {
                Node tmp=list.get(i);
                for (int j =i+1; j < n; j++) {
                    if(tmp.r+list.get(j).r>=Math.sqrt(Math.pow(tmp.x-list.get(j).x,2)+Math.pow(tmp.y-list.get(j).y,2))) {
                        union(i+1, j+1);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                parent[i] = find(i);
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < parent.length; i++) {
                set.add(parent[i]);
            }
            System.out.println(set.size());
        }
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

    static class Node{
        int x;
        int y;
        int r;
        Node(int x,int y,int r){
            this.x=x;
            this.y=y;
            this.r=r;
        }
    }
}

