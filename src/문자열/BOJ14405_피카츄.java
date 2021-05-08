package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14405_피카츄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        boolean res = true;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'p') {
                if (i + 1 < str.length && str[i + 1] == 'i') {
                    i++;
                } else {
                    res = false;
                    break;
                }
            } else if (str[i] == 'k') {
                if (i + 1 < str.length && str[i + 1] == 'a') {
                    i++;
                } else {
                    res = false;
                    break;
                }
            } else if (str[i] == 'c') {
                if (i + 1 < str.length && str[i + 1] == 'h') {
                    if (i + 2 < str.length && str[i + 2] == 'u') {
                        i += 2;
                    } else {
                        res = false;
                        break;
                    }
                } else {
                    res = false;
                    break;
                }
            } else {
                res = false;
                break;
            }
        }
        if (res) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}



