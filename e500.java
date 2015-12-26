import java.util.*;

public class e500
{
    public static int N = 20000000;
    public static int K = 500500; 
    public static long B = 500500507L;
    public static boolean [] prime = new boolean [N];
    public static boolean [] valid = new boolean [N];


    public static void main (String [] args)
    {
        Arrays.fill(prime,true);
        for(int i=2; i<prime.length; i++)
            if(prime[i])
                for(int j=2; i*j<prime.length; j++)
                    prime[i*j] = false;
       
        for(int i=2; i<valid.length; i++)
        {
            if(prime[i])
            {
                long j=i;
                while(j<(long)valid.length)
                {
                    valid[(int)j] = true;
                    j=j*j;
                }
            }
        } 

        long res = 1L;
        int count = 0;
        for(int i=2; i<valid.length; i++)
        {
            if(valid[i])
            {
                res*=i;
                res=res%B;
                count++;
                if(count>=K) break;
            }
        }

        System.out.println(res);
    }
}    
