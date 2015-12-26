import java.util.*;
import java.math.BigInteger;

public class e178
{
    public static void main (String [] args)
    {
        BigInteger [][][] arr = new BigInteger [10][10][10];
        BigInteger [][][] temp = new BigInteger [10][10][10];
        BigInteger res = BigInteger.ZERO;

        int  N = 40;

        for(int c=0; c<10; c++)
        for(int s=0; s<10; s++)
        for(int t=0; t<10; t++)
            arr[c][s][t] = BigInteger.ZERO;

        for(int c=0; c<10; c++)
            arr[c][c][c] = BigInteger.ONE;

        for(int i=1; i<N; i++)
        {

            for(int c=0; c<10; c++)
            for(int s=0; s<10; s++)
            for(int t=0; t<10; t++)
                temp[c][s][t] = BigInteger.ZERO;

            for(int c=0; c<10; c++)
            for(int s=0; s<10; s++)
            for(int t=0; t<10; t++)
            {
                if(c>0)
                    temp[c-1][Math.min(s,c-1)][t] = arr[c][s][t].add(temp[c-1][Math.min(s,c-1)][t]);
                if(c<9)
                    temp[c+1][s][Math.max(t,c+1)] = arr[c][s][t].add(temp[c+1][s][Math.max(t,c+1)]);

            }

            for(int c=0; c<10; c++)    
            for(int s=0; s<10; s++)
            for(int t=0; t<10; t++)
                arr[c][s][t] = temp[c][s][t];   
             for(int c=1; c<10; c++)
                res = res.add(arr[c][0][9]);

        }

        System.out.println(res);
/*
        BigInteger T = BigInteger.ZERO;

      for(int c=0; c<10; c++)
        {
            System.out.println("--- "+c+" ---");
            for(int s=0; s<10; s++)
            {
                for(int t=0; t<10; t++)
                {
                    System.out.print(arr[c][s][t]+" ");
                    T = T.add(arr[c][s][t]);
                }
                System.out.println();
            }
        }

      System.out.println("debug "+T);
*/

    }
}
