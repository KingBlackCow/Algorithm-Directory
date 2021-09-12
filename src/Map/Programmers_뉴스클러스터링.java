package Map;

import java.util.HashMap;
import java.util.Map;

class Programmers_뉴스클러스터링 {

    static Map<String, Integer> commonMap = new HashMap<>();
    static Map<String, Integer> unionMap = new HashMap<>();
    static Map<String, Integer> unionMap2 = new HashMap<>();
    public int solution(String str1, String str2) {
        int answer = 0;


        for(int i = 0; i < str1.length()-1; i++){
            String tmp = "";
            for(int j = i; j < i+2; j++){
                char cnt = str1.charAt(j);
                if((cnt>='A'&& cnt <='Z')||(cnt>='a'&&cnt<='z')){
                    tmp += str1.charAt(j);
                }
            }

            if(tmp.length()==2){
                System.out.print(tmp.toLowerCase()+" ");
                unionMap.put(tmp.toLowerCase(), unionMap.getOrDefault(tmp.toLowerCase(),0)+1);
            }
            tmp = "";
        }

        for(int i = 0; i < str2.length()-1; i++){
            String tmp = "";
            for(int j = i; j < i+2; j++){
                char cnt = str2.charAt(j);
                if((cnt>='A'&& cnt <='Z')||(cnt>='a'&&cnt<='z')){
                    tmp += str2.charAt(j);
                }
            }

            if(tmp.length()==2){
                unionMap2.put(tmp.toLowerCase(), unionMap2.getOrDefault(tmp.toLowerCase(),0)+1);
            }
            tmp = "";
        }


        double commonSize = 0.0;
        double unionSize = 0.0;
        for(String key : unionMap.keySet()){
            if(unionMap2.containsKey(key)){
                int min = Math.min(unionMap.get(key), unionMap2.get(key));
                commonSize += min;
                unionSize += Math.max(unionMap.get(key), unionMap2.get(key));
            }else{
                unionSize += unionMap.get(key);
            }
        }

        for(String key : unionMap2.keySet()){
            if(!unionMap.containsKey(key)){
                unionSize += unionMap2.get(key);
            }
        }

        if(commonSize==0&&unionSize==0) return 65536;
        answer = (int)(commonSize/unionSize*65536);
        return answer;
    }
}