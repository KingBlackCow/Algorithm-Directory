package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2590_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int one, two, three, four, five, six;
        one =Integer.parseInt(br.readLine());
        two =Integer.parseInt(br.readLine());
        three =Integer.parseInt(br.readLine());
        four =Integer.parseInt(br.readLine());
        five =Integer.parseInt(br.readLine());
        six =Integer.parseInt(br.readLine());
        int count = 0;
        count += six;
        while (one != 0 || two != 0 || three != 0 || four != 0 || five != 0)
        {
            while (five>0)
            {
                int pan = 36;
                five--;
                pan -= 25;
                if (one <= pan)
                    one = 0;
                else
                    one -= pan;
                count++;
            }
            while (four>0)
            {
                int pan = 36;
                four--;
                pan -= 16;
                if (two>5)
                {
                    two -= 5;
                    pan -= 20;
                }
                else
                {
                    pan -= 4 * two;
                    two = 0;
                }
                if (one <= pan)
                    one = 0;
                else
                    one -= pan;
                count++;
            }
            while (three>0)
            {
                int pan = 36;
                if (three>4)
                {
                    three -= 4;
                    pan = 0;
                }
                else
                {
                    pan -= 9 * three;
                    three = 0;
                }
                if (pan == 27 && two>5)
                {
                    two -= 5;
                    pan -= 20;
                }
                else if (pan == 27 && two <= 5)
                {
                    pan -= 4 * two;
                    two = 0;
                }
                if (pan == 18 && two>3)
                {
                    two -= 3;
                    pan -= 12;
                }
                else if (pan == 18 && two <= 3)
                {
                    pan -= 4 * two;
                    two = 0;
                }
                if (pan == 9 && two >= 1)
                {
                    pan -= 4 * two;
                    two = 0;
                }
                if (one <= pan)
                    one = 0;
                else
                    one -= pan;
                count++;
            }
            while (two>0)
            {
                int pan = 36;
                if (two>9)
                {
                    two -= 9;
                    pan = 0;
                }
                else
                {
                    pan -= 4 * two;
                    two = 0;
                }
                if (one <= pan)
                    one = 0;
                else
                    one -= pan;
                count++;
            }
            while (one>0)
            {
                if (one>36)
                    one -= 36;
                else
                    one = 0;
                count++;
            }
        }
        System.out.println(count);
    }

}