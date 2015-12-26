import java.util.*;

public class e233
{
    public static void main (String [] args)
    {
        long U = pow(10L, 11L);
        int V = (int)(U/(pow(5L,3L)*pow(13L,2L)));
        int W = (int)(U/(pow(5L,3L)*pow(13L,2L))*17L);


        boolean [] isPrime = new boolean[V+1];
        for(int i=2; i<isPrime.length; i++)
            isPrime[i] = true;
        for(int i=2; i<isPrime.length; i++)
            if(isPrime[i])
                for(int j=2; j*i<isPrime.length; j++)
                    isPrime[j*i] = false;

        ArrayList<Integer> sPrimes = new ArrayList<Integer>();
        long [] mult = new long[W+1];
        for(int i=0; i<mult.length; i++) mult[i] = i;
        for(int i=2; i<isPrime.length; i++)
        {
            if(isPrime[i] && i%4 ==1)
            {
                sPrimes.add(i);
                for(int j=i; j<mult.length; j+=i)
                    mult[j] = 0;
            }
        }

        System.out.println("solving");
        //accumulate mult
        for(int i=1; i<mult.length; i++) mult[i]+=mult[i-1];
        long sum = 0L;

        for(Integer r:sPrimes)
        {
            if( r > Math.pow(U/(13*5*5), 1.0/3)) break;
            for(Integer q:sPrimes)
            {
                if(q > Math.sqrt( U/(5*Math.pow(r,3)))) break;
                if( r==q ) continue;
                for(Integer p:sPrimes)
                {
                    if(p > U/Math.pow(q,2)*Math.pow(r,3)) break;
                    if(r==p || q==p) continue;
                    long n = (long)p*pow((long)q,2)*pow((long)r,3);
                    sum+=n*mult[(int)(U/n)];
                }
            }
        }

        for(Integer r:sPrimes)
        {
            if( r > Math.pow(U/Math.pow(5,3), 1.0/7)) break;
            for(Integer q:sPrimes)
            {
                if(q > Math.pow(U/Math.pow(r,7) ,1.0/3)) break;
                if( r==q ) continue;
                long n = pow((long)q,3)*pow((long)r,7);
                sum+=n*mult[(int)(U/n)];
            }
        }


        for(Integer r:sPrimes)
        {
            if( r > Math.pow(U/Math.pow(5,2), 1.0/10)) break;
            for(Integer q:sPrimes)
            {
                if(q > Math.pow(U/Math.pow(r,10) ,1.0/2)) break;
                if( r==q ) continue;
                long n = pow((long)q,2)*pow((long)r,10);
                sum+=n*mult[(int)(U/n)];
            }
        }







        System.out.println(sum);

        
    }

    public static int pow(int b, int e)
    {
        int accum = 1;
        for(int i=e; i>0; i--)
            accum*=b;
        return accum;
    }

    public static long pow(long b, long e)
    {
        long accum = 1;
        for(long i=e; i>0; i--)
            accum*=b;
        return accum;
    }
}
