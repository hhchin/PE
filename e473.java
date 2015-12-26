import java.util.*;
import java.math.BigInteger;

public class e473
{
    public static int N = 24;
    public static long [] pow5 = new long[N];
    public static long [] pow2 = new long[2*N];
    public static long [][] binom = new long [2*N][2*N];
    public static long [] res = new long[N];
    public static long soln = 0L; 
    
    public static long MAXN = 1L;
    public static void main (String [] args)
    {
        for(int i=0; i<10; i++)
            MAXN = MAXN*10;
        pow5[0] = 1;
        for(int i=1; i<pow5.length; i++)
            pow5[i] = pow5[i-1]*5L;
        pow2[0] = 1;
        for(int i=1; i<pow2.length; i++)
            pow2[i] = pow2[i-1]*2L;
        binom[0][0] = 1;
        binom[1][0] = 1;
        binom[1][1] = 1;
        for(int r=2; r<binom.length; r++)
        {
            binom[r][0] = 1;
            for(int c=1; c<=r; c++)
                binom[r][c] = binom[r-1][c-1]+binom[r-1][c];
        }
        
        res[0] = 1;
        res[1] = 2;
        for(int i=2; i<res.length; i++)
            res[i] = genVal(2*i);

        HashMap<Integer, ArrayList<Long>> map = new HashMap<Integer, ArrayList<Long>>();
        ArrayList<Long> arr = new ArrayList<Long>();
        arr.add(1L); map.put(0, arr);
        arr = new ArrayList<Long>(); arr.add(2L); map.put(1,arr);
        arr = new ArrayList<Long>(); arr.add(14L); map.put(2,arr);
        arr = new ArrayList<Long>(); arr.add(36L); arr.add(38L); map.put(3,arr);
        arr = new ArrayList<Long>(); arr.add(94L); arr.add(96L); map.put(4,arr);
        
        for(int i=5; i<res.length; i++)
        {
            arr = new ArrayList<Long>();
            arr.add(res[i]);
            int top = i-3;
            for(int t=1; t<=top; t++)
            {
                ArrayList<Long> old = map.get(t);
                for(Long L: old)
                    arr.add(res[i]+L);
            }
            map.put(i,arr);
        }
       

        for(int i=0; i<res.length; i++)
        {
            ArrayList<Long> old = map.get(i);
            for(Long L: old)
            soln+=L;
        }

        ArrayList<Long> old = map.get(res.length-1);
        long last = old.get(old.size()-1);
        System.out.println(last+":"+ (last>MAXN));
        System.out.println(soln);
    }

    public static long genVal(int K)
    {
        BigInteger acc =  BigInteger.ZERO;
        for(int i=0; i<=K; i+=2)
        {
            BigInteger coeff = BigInteger.valueOf(binom[K][i]);
            BigInteger pow = BigInteger.valueOf(pow5[i/2]);
            acc = acc.add(coeff.multiply(pow));
        }
        acc = acc.divide(BigInteger.valueOf(pow2[K-2]));
        return acc.longValue();
    }


}
