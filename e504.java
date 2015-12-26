import java.util.*;

public class e504
{
    static int M = 100;
    static boolean [] isSq = new boolean[4*(M+1)*(M+1)];
    public static void main (String [] args)
    {
        for(int i=1; i*i<isSq.length; i++)
            isSq[i*i] = true;
        
        int count = 0;
        for(int a=1; a<=M; a++)
        for(int b=1; b<=M; b++)
        for(int c=1; c<=M; c++)
        for(int d=1; d<=M; d++)
        {
            int A = (a+c)*(b+d);
            int B = bd(a,0,0,b) + bd(0,b,-c,0) + bd(-c,0,0,-d) + bd(0,-d,a,0)-4;
            int I = A-B+2;
            if(I!=0 && I%2==0 && isSq[I/2]) count++;
        }
        System.out.println(count);
        
    }

    static int bd(int a, int b, int c, int d)
    {
        int m = Math.abs(d-b);
        int n = Math.abs(c-a);
        int x = n;
        int g = GCD(Math.min(m,n), Math.max(m,n));
        m/=g; n/=g;
        return x/n+1;
    }

    static int GCD(int a, int b)
    {
        return a==0 ? b : GCD(b%a, a);
    }

}
