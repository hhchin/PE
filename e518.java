import java.util.*;

public class e518
{
    public static int N = 100000000;
    public static boolean [] P = new boolean [N+1];

    public static void main (String [] args)
    {
        fillPrimes();
        long sum = 0L;
        for(int d = 1; d<N; d++)
        {
            long dd = d*d;
            if(dd>N) break;
            for(int n = (int)dd; n<N; n+=dd)
            {
                int nd = n/d;
                int ndd = nd/d;

                if(P[n-1]) // some candidate a
                {
                    for(int k=d+1; ndd*k*k<=N; k++)
                    {
                        int b = nd*k-1;
                        int c = ndd*k*k -1;
                        if(P[b] && P[c] && GCD(d,k)==1)
                            sum+=(n-1)+b+c;
                    }
                }
            }

        }
        System.out.println(sum);
    }

    private static int GCD(int a, int b)
    {
        if(a==0) return b;
        return GCD(b%a, a);
    }

    private static void fillPrimes()
    {
        Arrays.fill(P, true);
        P[0] = false; P[1]=false;
        for(int i=2; i<P.length; i++)
        {
            if(P[i])
            {
                for(int j=2; j<=(P.length-1)/i; j++)
                    P[j*i] = false;
            }
        }
    }
}
