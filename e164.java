import java.util.*;

public class e164
{
    private static int LIM = 9;
    private static int MAX = 20;
    private static long [][][] count = new long [10][10][MAX];

    public static void main (String [] args)
    {
        long res = 0;
        for(int i=1; i<=9; i++)
            res+=solve(0,i,MAX-1);
        System.out.println(res);
        
    }

    private static long solve(int d1, int d2, int rem)
    {
        if(rem ==0 ) return 1;
        else
        {
            if(count[d1][d2][rem] == 0)
                for(int i=0; i<=LIM-(d1+d2); i++)
                    count[d1][d2][rem]+=solve(d2,i,rem-1);
            return count[d1][d2][rem];
        }
    
    }
}
