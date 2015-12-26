import java.math.BigInteger;
import java.util.*;
public class e346
{

    public static void main (String [] args)
    {
        BigInteger N = BigInteger.valueOf(10).pow(12);
        HashSet<BigInteger> hs = new HashSet<BigInteger>();
        BigInteger soln = BigInteger.ZERO;
        hs.add(BigInteger.ONE);
        int i = 2;
        while(true)
        {
            BigInteger bi = BigInteger.valueOf(i);
            BigInteger b = bi;
            BigInteger k = (BigInteger.ONE).add(b);
            b = b.multiply(bi);
            k = k.add(b);
            if(k.compareTo(N)>0) break;
            while(k.compareTo(N)<=0)
            {
                hs.add(k);
                b = b.multiply(bi);
                k = k.add(b);
            }
            i++;
        }
        for(BigInteger B : hs)
            soln = soln.add(B);
        System.out.println(soln);
    }
}
