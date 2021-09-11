import java.util.*;


class Solution2 {
    static int n = 1000000;
    static boolean primes[] = new boolean[n+1];

    static public int solution(int n, int k) {
        int answer = 0;
        eratosthenes();
        String nNum = changeNum(n, k);
        while(nNum.contains("00")) {
            nNum = nNum.replaceAll("00", "0");
        }
        StringTokenizer st = new StringTokenizer(nNum,"0");
        while (st.hasMoreTokens()){
            if(!primes[Integer.parseInt(st.nextToken())]){
                answer++;
            }
        }
        return answer;
    }

    static public String changeNum(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int cnt = n;

        while (cnt > 0) {
            if (cnt % k < 10) {
                sb.append(cnt % k);
            } else {
                sb.append((char) (cnt % k - 10 + 'A'));
            }
            cnt /= k;
        }
        return sb.reverse().toString();
    }

    public static String getConventN(int num, int n) {
        String result = "";
        if (num == 0) {
            return "0";
        }

        while (num > 0) {
            int share = num / n;
            int remainder = num % n;
            if (remainder > 9) {
                result = (char) (remainder + 55) + result;
            } else {
                result = remainder + result;
            }
            num = share;
        }
        return result;
    }

    static public void eratosthenes() {
        primes[0] = primes[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
    }
}