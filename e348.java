import java.util.*;

public class e348
{

    static long soln = 0;
    static int count = 0;

    public static void main (String [] args)
    {
        for(int n=7; n<=12; n++)
        {
            long end = pow(10, n/2);
            long start = end/10;
            if(n%2==0)
            {
                for(long i=start; i<end; i++)
                {
                    String pal = String.valueOf(i);
                    pal = pal + new StringBuilder(pal).reverse().toString();
                    long pal_long = Long.parseLong(pal);
                    check(pal_long);                
                }
            }
            else
            {   
                for(long m = 0; m<10; m++)
                    for(long i=start; i<end; i++)
                    {
                        String pal = String.valueOf(i);
                        pal = pal + String.valueOf(m)+new StringBuilder(pal).reverse().toString();
                        long pal_long = Long.parseLong(pal);
                        check(pal_long);                
                    }

            }

        }

    }

    static boolean valid(long pal)
    {
        long cubeLimit = (long) Math.cbrt(pal - 4);
        int countForms = 0;

        for(long testNumber = 2; testNumber <= cubeLimit; testNumber++) 
        {
            long cube = testNumber * testNumber * testNumber;
            long diff = pal - cube;
            double squareRoot = Math.sqrt(diff);
            long intSquareRoot = (long) squareRoot;
            if(diff == intSquareRoot*intSquareRoot) 
                countForms++;
            
        }
        if(countForms == 4) {
            return true;
        }

        return false;
    }

    static void check(long pal)
    {
        if(valid(pal))
        {
            soln+=pal;
            count++;
            if(count==5)
                System.out.println(soln);
        }
    }

    static long pow(int a, int b)
    {
        int res = 1;
        for(int i=0; i<b; i++)
            res*=a;
        return res;
    }




}
