import java.math.BigInteger;
import java.util.*;

public class e541_h
{

    public static void main (String [] args)
    {

        int pint = 7;
        int L = 200;
        BigInteger P = BigInteger.valueOf(pint);
        BigInteger P2 = BigInteger.valueOf(pint*pint);
        BigInteger [] N = new BigInteger[L+1];
        BigInteger [] D = new BigInteger[L+1];
        BigInteger [] R = new BigInteger[L+1];

        N[0] = BigInteger.ZERO;
        D[0] = BigInteger.ONE;
        R[0] = BigInteger.ZERO;

        for(int i=1; i<N.length; i++)
        {
            BigInteger r = BigInteger.valueOf(i);
            BigInteger nt = N[i-1].multiply(r);
            nt = nt.add(D[i-1]);
            BigInteger dt = D[i-1].multiply(r);
            BigInteger g = nt.gcd(dt);
            nt = nt.divide(g);
            dt = dt.divide(g);
            N[i] = nt;
            D[i] = dt;
            R[i] = N[i].mod(P);
        }

        System.out.println(N[48]);
        System.out.println(D[48]);
        System.out.println(N[48].mod(P2));
        System.out.println(D[48].mod(P2));



    }
}
