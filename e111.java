import java.util.*;

public class e111
{
    public static ArrayList<Integer> prime = new ArrayList<Integer>();
    public static int [] number = new int [10];
    public static long soln = 0L;
    public static void main (String [] args)
    {
        genPrime();
        for(int d=0; d<10; d++)
        {
            for(int c = 1; c<10; c++)
            {
                Arrays.fill(number, d);
                long sum =0L;
                if(d==0)
                {
                    for(int i=1; i<10; i++)
                    {
                        number[9] = i;
                        sum+= recurse(8,d,c);
                    }   
                }
                else
                {
                    sum = recurse(9,d,c);
                }
                if(sum>0) 
                {
                    soln+=sum;
                    System.out.println(d+"->"+c);
                    break;
                }
            }
        }
        System.out.println(soln);
    }

    private static long recurse(int pos, int digit, int counter)
    {
        if(counter<=0) return checkPrime();


        long val = 0;
        for(int p = pos; p>=0; p--)
        {
            for(int i=0; i<10; i++)
            {
                if(p==9 && (i==0  || digit ==0)) continue;
                number[p] = i;
                val+=recurse(p-1, digit, counter-1);
                number[p] = digit;
            }
        }

        return val;
    }
    private static void genPrime()
    {
        int lim = 1000000;
        boolean [] arr = new boolean [lim+1];
        for(int i=0; i<arr.length; i++)
            arr[i] = true;
        for(int i=2; i<arr.length; i++)
            if(arr[i])
            {
                prime.add(i);
                for(int j=2; i*j<arr.length; j++)
                    arr[i] = false;
            }

    }

    private static long checkPrime()
    {
        long N = 0L;
        long base = 1L;
        for(int i=0; i<number.length; i++)
        {
            N += number[i]*base;
            base *= 10;
        }

        for(Integer p : prime)
        {
            if(p*p>N) break;
            if(N%p==0) return 0L;
        }

        System.out.println(N);
        return N;
    }
}
