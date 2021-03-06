package DFS;

import java.io.*;
import java.util.ArrayList;

public class BOJ16637_괄호추가하기 {
    static long ans;
    static ArrayList<Character> opList;
    static ArrayList<Integer> numList;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        opList = new ArrayList<>();
        numList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*') {
                opList.add(str.charAt(i));
            } else {
                numList.add(Integer.parseInt(String.valueOf(str.charAt(i))));
            }
        }
        ans=Integer.MIN_VALUE;
        dfs(numList.get(0), 0);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long calc(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        }
        return -1;
    }

    private static void dfs(long x, int opIdx) {
        if (opIdx+1 == numList.size()) {
            ans = Math.max(x, ans);
            return;
        }
        dfs(calc(x, numList.get(opIdx + 1), opList.get(opIdx)), opIdx + 1);
        if (opIdx + 2 < numList.size()) {
            long tmp = calc(numList.get(opIdx + 1), numList.get(opIdx + 2), opList.get(opIdx + 1));
            dfs(calc(x, tmp, opList.get(opIdx)), opIdx + 2);
        }
    }


}
