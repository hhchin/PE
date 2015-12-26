import java.util.*;

public class e128
{
    public static ArrayList<Integer> primes = EulerPack.genPrimeList(100000);
    public static void main (String [] args)
    {

        int count = 1;
        int limit = 2000;
        long n = 0;
        long number = 0;

        while (count < limit) {
            n++;
            if (IsPrime(6 * n - 1) && IsPrime(6 * n + 1) && IsPrime(12 * n + 5)) {
                count++;
                number = (3 * n * n - 3*n + 2);
                if (count >= limit) break;

            }
            if (IsPrime(6 * n + 5) && IsPrime(6 * n - 1) && IsPrime(12 * n - 7) && n != 1) {
                count++;
                number = (3 * n * n + 3*n + 1);                                       
                if (count >= limit) break;
            }             
        }            

        System.out.println( number);

    }

    public static boolean IsPrime(long n)
    {
        for(Integer P : primes)
        {
            if(P*P > n ) return true;
            if(n % (long)P == 0) return false;
        }
        return true;
    }
}
