import java.util.*;

public class e214
{
    public static int LIMIT = 40000000;
//    public static int LIMIT = 11;
    public static int LEN = 25;
    public static boolean [] prime = new boolean [LIMIT];
    public static long [] tot = new long [LIMIT];
    public static int [] totLen = new int [LIMIT];
    public static long soln = 0L;

    public static void main (String [] args)
    {
    
        genTot();
        totLen[1] = 1;
        for(int i=2; i<totLen.length; i++)
            totLen[i] = totLen[(int)tot[i]]+1;

        for(int i=1; i<totLen.length; i++)
            if(prime[i] && totLen[i] == LEN)
                soln+=i;
        System.out.println(soln);

    }

    private static void genTot()
    {
        for(int i=2; i<prime.length; i++)
        {
            prime[i] = true;
            tot[i] = 1L;
        }
        for(int i=2; i<prime.length; i++)
            if(prime[i])
            {
                tot[i] = i-1;
                int maxInd = (prime.length-1)/i;
                for(int j=2; j<=maxInd; j++)
                {
                    int ind = i*j;
                    prime[ind] = false;
                    long mult = 1;
                    int val = i*j;
                    while( val%i == 0)
                    {
                        val/=i;
                        mult*=i;
                    }
                        tot[ind] *= (long)((i-1)*mult)/((long)i);
                    }
            }
    }
}
