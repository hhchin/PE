import java.util.*;

public class e351
{
    public static long N = 100000000;
    //public static long N= 5;
    public static HashMap<Long,Long> mem = new HashMap<Long, Long>();
    public static void main (String [] args)
    {
            
        long cop = R(N);
        long soln= (N-1)*(N)/2- cop;
        soln+=(N-1);
        soln*=6;
        System.out.println(soln);
    }


    private static long R(long n)
    {
        if(n==1) return 0L;
        if(mem.containsKey(n)) return mem.get(n);

        long soln = (n*(n-1))/2;
        long m=2;
        while(m<=n)
        {
            long rem = n/m;
            long next = n/rem;
            soln -= (next-m+1)*R(rem);
            m = next+1;
        }
        mem.put(n,soln);
        return soln;
    }
}
