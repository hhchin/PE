import java.math.BigInteger;
import java.util.*;

public class e541
{

    public static void main (String [] args)
    {

        int pint = 7;
        long p2int = pint*pint;
        int L = pint;
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
        }

        for(int i=1; i<N.length; i++)
        {
            N[i] = N[i].mod(P);
            D[i] = D[i].mod(P);
            BigInteger g = N[i].gcd(D[i]);
            System.out.println(g);
            N[i] = N[i].divide(g);
            D[i] = D[i].divide(g);
            R[i] = N[i];
        }



        for(int i=0; i<R.length; i++)
        {
            System.out.println(i+":"+R[i]);
        }

        BigInteger psiN = BigInteger.ZERO;
        BigInteger psiD = BigInteger.ONE;
        BigInteger psiN2 = BigInteger.ZERO;
        BigInteger psiD2 = BigInteger.ONE;

        BigInteger hN = N[pint-1];
        BigInteger hD = D[pint-1];
        BigInteger hN2 = N[pint-1];
        BigInteger hD2 = D[pint-1];
        long curI = pint-1;

        boolean notSolve = true;

        while(notSolve)
        {
            BigInteger tempN = hN2;   
            BigInteger tempD = hD2.multiply(P);
            BigInteger tempG = tempN.gcd(tempD);   
            psiN2 = tempN.divide(tempG);
            psiD2 = tempD.divide(tempG);
            psiN = psiN2.mod(P);
            System.out.println("search "+psiN);
            notSolve = false;
            long cur_r = 0;
            for(int i=0; i<pint; i++)
            {
                if(R[i].add(psiN).mod(P).compareTo(BigInteger.ZERO)==0)
                {
                    notSolve = true;
                    cur_r = i;
                }
            }

            if(notSolve)
            {
                curI = cur_r+pint*curI;
                System.out.println("next->"+curI);
            }
            else
            {
                long soln = curI*pint+(long)(pint-1);
                System.out.println("final");
                System.out.println(curI);
                System.out.println(soln);
                break;
            }
            
            tempN = BigInteger.ZERO;
            tempD = BigInteger.ONE;
            long res = curI% (p2int);
            for(long i = curI; i>curI-res; i--)
            {
                /*
                long a = Math.min(i, (long)pint);
                long b = Math.max(i, (long)pint);
                if(GCD(a, b)!= 1L) continue;
                */
                BigInteger r = BigInteger.valueOf(i%p2int);
                BigInteger nt = tempN.multiply(r);
                nt = nt.add(tempD);
                BigInteger dt = tempD.multiply(r);
                BigInteger g = nt.gcd(dt);
                nt = nt.divide(g);
                dt = dt.divide(g);
                tempN = nt;
                tempD = dt;
                    
                System.out.println(r+":@r");
                System.out.println(tempN+":tempN");
                System.out.println(tempD+":tempD");
            }
            tempN = tempN.mod(P2);
            tempD = tempD.mod(P2);
            System.out.println(tempN+":tempN");
            System.out.println(tempD+":tempD");

            hN2 = tempN.multiply(psiD2);
            hN2.add(tempD.multiply(psiN2));
            hD2 = tempD.multiply(psiD2);
            System.out.println(hN2);
            System.out.println(hD2);

            BigInteger g = hN2.gcd(hD2);
            hN2 = hN2.divide(g);
            hD2 = hD2.divide(g);
            hN2 = hN2.mod(P2);
            hD2 = hD2.mod(P2);
            
            System.out.println(hN2+": new hN2");
            System.out.println(hD2+": new hD2");
        }



    }

    private static long GCD(long a, long b)
    {
        if(a==0L) return b;
        return GCD(b%a, a);
    }
}
