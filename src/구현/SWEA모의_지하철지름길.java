package 구현;

import java.util.Scanner;

class SWEA모의_지하철지름길 {
    static int n;
    static int[] ary;
    static int max = 0;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            init(sc);
            max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+2; j < n; j++) {
                    for (int k = j+2; k < n; k++) {
                        for (int l = k+2; l < n+i-1; l++) {
                            max=Math.max(getRes(ary[i],ary[j],ary[k],ary[l%n]),max);
                        }
                    }
                }
            }
            System.out.println("#"+test_case+" "+max);
        }

        sc.close();
    }

    private static void init(Scanner sc) {
        n = sc.nextInt();
        ary = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = sc.nextInt();
        }
    }

    static int getRes(int a, int b, int c,int d){
        return (int) (Math.pow(a+b,2)+Math.pow(c+d,2));
    }
}
