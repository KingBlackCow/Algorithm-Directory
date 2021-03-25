package 구현;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class SW역향테스트_방사능 {
    static int n, m, k;
    static int ary[][];
    static int smallX;
    static int largeX;
    static int smallY;
    static int largeY;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();
            ary = new int[301][301];
            smallX = Integer.MAX_VALUE;
            largeX = Integer.MIN_VALUE;
            smallY = Integer.MAX_VALUE;
            largeY = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                int x2 = sc.nextInt();
                int y2 = sc.nextInt();
                int minX;
                int minY;
                int maxX;
                int maxY;

                if (x1 < x2) {
                    minX = x1;
                    maxX = x2;
                } else {
                    minX = x2;
                    maxX = x1;
                }
                if (y1 < y2) {
                    minY = y1;
                    maxY = y2;
                } else {
                    minY = y2;
                    maxY = y1;
                }

                for (int j = minX; j < maxX; j++) {
                    for (int k = minY; k < maxY; k++) {
                        ary[j][k] = i;
                    }
                }
                smallX = Math.min(smallX, minX);
                smallY = Math.min(smallY, minY);
                largeX = Math.max(largeX, maxX);
                largeY = Math.max(largeY, maxY);
            }
            k = Math.max(largeX - smallX, largeY - smallY);

            System.out.println("#" + tc + " "+binarySearch(k));
        }
        System.exit(0);
    }

    private static int binarySearch(int x) {
        int left=1;
        int right=x;

        while(left<=right) {
            int mid=(left+right)/2;
            int resTmp=attack(mid);
            if(resTmp>=m) {
                left=mid+1;
            }else if(resTmp<m) {
                right=mid-1;
            }
        }
        return right;
    }

    private static int attack(int size) {

        int min=Integer.MAX_VALUE;
        for(int r=smallX;r+size<largeX;r++) {
            for(int c=smallY;c+size<largeY;c++) {
                Set<Integer> set=new HashSet<>();
                int copy[][]=new int[301][301];
                for(int i=smallX;i<=largeX;i++) {
                    for(int j=smallY;j<=largeY;j++) {
                        copy[i][j]=ary[i][j];
                    }
                }

                for(int i=r;i<r+size;i++) {
                    for(int j=c;j<c+size;j++) {
                        copy[i][j]=0;
                    }
                }

                for(int i=smallX;i+size<largeX;i++) {
                    for(int j=smallY;j+size<largeY;j++) {
                        if(ary[i][j]!=0) {
                            set.add(copy[i][j]);
                        }
                    }
                }
                min=Math.min(min, set.size());

            }
        }

        return min;
    }

}
