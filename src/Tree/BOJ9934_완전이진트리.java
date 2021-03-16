package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class BOJ9934_완전이진트리 {
    static List<Integer> list[];

    static int res=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k=Integer.parseInt(br.readLine());
        int[] ary=new int[(int) Math.pow(2,k)-1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < ary.length; i++) {
            ary[i]=Integer.parseInt(st.nextToken());
        }

        list=new ArrayList[k];
        for (int i = 0; i < k; i++) {
            list[i]=new ArrayList<>();
        }
        makeNode(ary,0);
        for (int i= 0; i <k;i++) {
            for (int j = 0; j < list[i].size(); j++) {
                System.out.print(list[i].get(j)+" ");
            }
            System.out.println();
        }
    }

    private static void makeNode(int[] ary,int depth) {
        if(ary.length==1){
            list[depth].add(ary[0]);
            return;
        }
        int k=ary[ary.length/2];
        list[depth].add(k);
        int[] ary2=Arrays.copyOfRange(ary, 0, ary.length/2);
        makeNode(ary2,depth+1);
        int[] ary3=Arrays.copyOfRange(ary, ary.length/2+1, ary.length);
        makeNode(ary3,depth+1);
    }
}
