import java.util.*;
import java.math.BigInteger;

public class e178
{
    public static void main (String [] args)
    {
        BigInteger [][][] arr = new BigInteger [10][10][10];
        BigInteger [][][] temp = new BigInteger [10][10][10];

        int  N = 40;

        for(int s=0; s<10; s++)
        for(int t=0; t<10; t++)
        for(int c=0; c<10; c++)
            arr[s][t][c] = BigInteger.ZERO;
        

        for(int c=1; c<10; c++)
            arr[c][c][c] = BigInteger.ONE;

        for(int i=1; i<40; i++)
        {

            for(int s=0; s<10; s++)
                for(int t=0; t<10; t++)
                    for(int c=0; c<10; c++)
                        temp[s][t][c] = BigInteger.ZERO;

            for(int s=0; s<10; s++)
                for(int t=0; t<10; t++)
                    for(int c=0; c<10; c++)
                    {
                        if(c>0)
                            temp[Math.min(s,c-1)][t][c-1] = arr[s][t][c].add(temp[Math.min(s,c-1)][t][c-1]);
                        if(c<9)
                            temp[s][Math.max(t,c+1)][c+1] = arr[s][t][c].add(temp[s][Math.max(t,c+1)][c+1]);

                    }

            for(int s=0; s<10; s++)
                for(int t=0; t<10; t++)
                    for(int c=0; c<10; c++)    
                        arr[s][t][c] = temp[s][t][c];   

        }

        BigInteger res = BigInteger.ZERO;
        for(int c=0; c<10; c++)
            res = res.add(arr[0][9][c]);
        System.out.println(res);


      for(int c=0; c<10; c++)
        {
            System.out.println("--- "+c+" ---");
            for(int s=0; s<10; s++)
            {
                for(int t=0; t<10; t++)
                    System.out.print(arr[s][t][c]+" ");
                System.out.println();
            }
        }


    }
}
