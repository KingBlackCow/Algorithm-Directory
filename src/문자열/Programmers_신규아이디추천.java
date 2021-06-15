package 문자열;

class Programmers_신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";
        //1단계
        answer=new_id.toLowerCase();
        String ans="";

        //2단계
        for(int i = 0; i< answer.length();i++){
            if(answer.charAt(i)=='_'||answer.charAt(i)=='-'||answer.charAt(i)=='.'
                    ||(answer.charAt(i) >= '0'&& answer.charAt(i) <= '9')
                    ||(answer.charAt(i) >= 'a'&& answer.charAt(i) <= 'z')){
                ans+=answer.charAt(i);
            }
        }

        //3단계
        answer = ans.toString().replace("..", ".");
        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

        //4단계
        if(answer.length()>0){
            if(answer.charAt(0) =='.'){
                answer=answer.substring(1);
            }
        }
        if(answer.length()>0){
            if(answer.charAt(answer.length()-1) =='.'){
                answer=answer.substring(0, answer.length() -1);
            }
        }
        //5단계
        if(answer.equals("")){
            answer+="a";
        }

        //6단계
        if(answer.length()>=16){
            answer=answer.substring(0,15);
            if(answer.length() > 0){
                if(answer.charAt(answer.length()-1) =='.'){
                    answer=answer.substring(0, answer.length() -1);
                }
            }
        }

        //7단계
        while(answer.length() <= 2){
            answer+=answer.charAt(answer.length()-1);
        }

        return answer;
    }
}