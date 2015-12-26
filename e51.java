import java.util.*;

public class e51
{
    public static int LIM = 1000000;
    public static boolean [] prime = new boolean [LIM];
    public static void main (String [] args)
    {
        genPrime();
        for(int i=100000; i<LIM; i++)
        {
            if( prime[i] && check(i) )
            {
                System.out.println("soln "+ i);
                break;
            }
        }
    }

    private static int bfm(int n, int d)
    {
        int count = 0;
        for(int i=d+1; i<10; i++)
        {
            int newn = Integer.parseInt((""+n).replaceAll(""+d,""+i));
            if(prime[newn]) count++;
        }
        return count;
    }

    private static boolean check(int n)
    {
        int [] digits = new int[10];
        int dn = n;
        while(dn>0)
        {
            digits[dn%10]++;
            dn/=10;
        }


        if(digits[0]==3 && bfm(n,0) >= 7) return true;
        if(digits[1]==3 && bfm(n,1) >= 7) return true;
        if(digits[2]==3 && bfm(n,2) >= 7) return true;

        return false;
    }

    private static void genPrime()
    {
        Arrays.fill(prime, true);
        for(int i=2; i<prime.length; i++)
            if(prime[i])
                for(int j=2; i*j<prime.length; j++)
                    prime[i*j] = false;
        
    }
}
