package Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ19583_싸이버개강총회 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[3];
        int cnt = 0;
        while (st.hasMoreTokens()) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ":");
            int hour = Integer.parseInt(st2.nextToken());
            int min = Integer.parseInt(st2.nextToken());
            time[cnt++] = hour * 60 + min;
        }
        Map <String, Integer> map = new HashMap<>();
        String str;
        int res = 0;
        while ((str=br.readLine())!=null){
            st = new StringTokenizer(str);
            if(!st.hasMoreTokens())break;
            String[] tmpTime = st.nextToken().split(":");
            int realTime = Integer.parseInt(tmpTime[0])*60+Integer.parseInt(tmpTime[1]);
            String name = st.nextToken();
            if(realTime <=time[0]){
                map.put(name,realTime);
            }
            else if(realTime>=time[1]&&realTime<=time[2]){
                if(map.getOrDefault(name,-1)!=-1) {
                    map.remove(name);
                    res++;
                }
            }
        }
        System.out.println(res);

    }
}
