package Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

class BOJ13414_수강신청 {
    static int n,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<String,Integer> map=new LinkedHashMap<>();
        for (int i = 0; i < m; i++) {
            String tmp=br.readLine();
            if(map.containsKey(tmp)) {
                map.remove(tmp);
            }
            map.put(tmp,1);
        }
        int i=0;
        for( Iterator itr = map.keySet().iterator(); itr.hasNext(); ) {

            System.out.println( itr.next());
            i++;
            if(i>=n)break;
        }
    }
}

