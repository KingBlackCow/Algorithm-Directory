import java.util.Scanner;

public class Main {
    static class Pair {
        long y;
        long x;

        public Pair(long x, long y) {
            super();
            this.y = y;
            this.x = x;
        }

        public boolean cmp(Pair o) {
            if (y > o.y)
                return true;
            if (y == o.y) {
                if (x >= o.x)
                    return true;
            }
            return false;
        }

        public boolean equals(Pair obj) {
            if(x==obj.x && y==obj.y)
                return true;
            return false;
        }

    }

    static long ccw(Pair a, Pair b, Pair c) {
        long op = a.x * b.y + b.x * c.y + c.x * a.y;
        op -= (a.y * b.x + b.y * c.x + c.y * a.x);

        // 반시계 방향
        if (op > 0)
            return 1;
            // 시계방향
        else if (op == 0)
            return 0;
        else
            return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pair a = new Pair(sc.nextLong(), sc.nextLong());
        Pair b = new Pair(sc.nextLong(), sc.nextLong());
        Pair c = new Pair(sc.nextLong(), sc.nextLong());
        Pair d = new Pair(sc.nextLong(), sc.nextLong());

        if (Solve(a, b, c, d))
            System.out.println(1);
        else
            System.out.println(0);
    }


    public static boolean Solve(Pair a, Pair b, Pair c, Pair d) {
        long abc = ccw(a, b, c);
        long abd = ccw(a, b, d);
        long cda = ccw(c, d, a);
        long cdb = ccw(c, d, b);

        if (abc * abd == 0 && cda * cdb == 0) {
            if (a.cmp(b)) {
                Pair tmp = a;
                a = b;
                b = tmp;
            }

            if (c.cmp(d)) {
                Pair tmp = c;
                c = d;
                d = tmp;
            }
            if(b.equals(c)|| a.equals(d))
                return true;

            return b.cmp(c)!= a.cmp(d);
        }

        return abc * abd <= 0 && cda * cdb <= 0;
    }
}


