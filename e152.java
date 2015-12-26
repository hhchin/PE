import java.util.*;

public class e152
{
    public static int N = 45;
    public static double [] arr = new double[N+1];
    public static double [] res = new double[N+1];
    public static double eps = 1e-10;
    public static long soln_count = 0;
    public static void main (String [] args)
    {
        for(int i = 2; i<=N ; i++)
            arr[i] = 1.0/(Math.pow((double)i,2));
        res[N] = arr[N];
        for(int i=N-1; i>=0; i--)
            res[i] = res[i+1]+arr[i];

        double start = arr[2]+arr[3]+arr[4];
        solve(5, start);
        System.out.println(soln_count);
    }

    public static void solve(int ind, double cur)
    {
        if( Math.abs(cur - 0.5)<eps)
        {
            soln_count++;
            return;
        }
        if(ind>=N || cur>0.5 || cur+res[ind] < 0.5) return;
        solve(ind+1, cur);
        solve(ind+1, cur+arr[ind]);
    }
}

