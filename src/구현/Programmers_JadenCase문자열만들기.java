package 구현;

class Programmers_JadenCase문자열만들기 {
    public String solution(String s) {
        String answer = "";
        boolean flag = true;
        s = s.toLowerCase();
        for(int i = 0; i < s.length();i++){
            if(flag){
                if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                    String s1 = s.substring(0,i);
                    String s2 = s.substring(i,i+1).toUpperCase();
                    String s3 = s.substring(i+1);
                    s = s1+s2+s3;
                }
                flag = false;
            }
            if(s.charAt(i)==' '){
                flag = true;
            }
        }
        answer = s;
        return answer;
    }
}