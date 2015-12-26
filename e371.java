import java.util.*;

public class e371
{
    public static void main (String [] args)
    {
        int N = 1000;
        int M = N/2;
        int m = M-1;
        double f1= 2.0;
        double f0= 2.0;

        while(--m >=0)
        {
            f1 = (N+2.0*(M-1-m)*f1)/(N-m-1);
            f0 = (N+f1+2.0*(M-1-m)*f0)/(N-m-1);
        }

            System.out.printf("exp %1.8f\n",f0);
        
    }
}
