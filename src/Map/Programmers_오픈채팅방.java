package Map;

import java.util.*;

class Programmers_오픈채팅방 {
    static Map<String, String> map = new HashMap<>();
    static List<String> list = new ArrayList<>();
    public String[] solution(String[] record) {

        for(int i = 0; i<record.length;i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String order = st.nextToken();
            String id = st.nextToken();
            String name = "";
            if(st.hasMoreTokens()){
                name = st.nextToken();
            }
            if("Enter".equals(order)){
                map.put(id,name);
                list.add(id+"님이 들어왔습니다.");
            }else if ("Leave".equals(order)){
                list.add(id+"님이 나갔습니다.");
            }else if("Change".equals(order)){
                map.put(id,name);
            }
        }
        String[] answer = new String[list.size()];
        int cnt = 0;
        for(String s : list){
            String str = "";
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i)=='님'){
                    break;
                }
                str+=s.charAt(i);
            }
            answer[cnt]=s.replace(str,map.get(str));
            cnt++;
        }
        return answer;
    }
}