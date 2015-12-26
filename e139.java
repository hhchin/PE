import java.util.*;

public class e139
{
    public static void main (String [] args)
    {
        long LIM = 100000000;
        long result = 0;
        long MLIM = (long) Math.sqrt( (double)(LIM/2));

        for(long m=2; m<MLIM; m++)
        {
            for(long n=1; n<m; n++)
            {
                if (((n + m) % 2) == 1 && GCD(n, m) == 1) {
                    long a = 2 * m * n;
                    long b = m * m - n * n;
                    long c = m * m + n * n;
                    long p = a + b + c;
                    if(c % (b-a) == 0)
                        result += LIM / p;
                }
            }
        }

        System.out.println(result);
    }

    private static long GCD(long a, long b)
    {
        if(a == 0) return b;
        else return GCD(b%a, a);
    }
}
