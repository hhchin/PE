import java.util.*;

public class e463p1
{
    public static int N  = 100;
    public static long [] arr = new long [N+1];
    public static void main (String [] args)
    {
        long S = 0L;
        int acc = 0;
        int pow = 1;
        long counter = 0L;
        for(int i=1; i<=N; i++)
        {
        //    System.out.println(Arrays.toString(arr));
            arr[i] = F(i);
            S+=arr[i];
            counter +=arr[i];
            System.out.printf("%d,",arr[i]);
            acc++;
            if(acc==pow)
            {
                acc = 0;
                pow*=2;
                System.out.println(":"+counter);
                counter=0;
            }


        }

        System.out.println("S->"+S);
        
    }
    public static long F(int n)
    {
        if(n==1) return 1;
        if(n==3) return 3;
        if(n%2==0) return arr[n/2];
        if( (n-1)%4==0) return 2*arr[ 2*((n-1)/4)+1]-arr[ (n-1)/4];
        if( (n-3)%4==0) return 3*arr[ 2*((n-3)/4)+1]-2*arr[ (n-3)/4];
        return -1;
    }   
}
