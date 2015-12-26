import java.util.*;

public class e150
{
    public static long [][] tri = new long [1000][];
    public static void main (String [] args)
    {
        long t = 0L;
        for(int r=0; r<1000; r++)
        {
            tri[r] = new long [r+1];
            for(int c=0; c<=r; c++)
            {
                t = (615949L*t + 797807) % (0x1<<20);
                tri[r][c] = t-(0x1<<19);
            }
        }

        long [][] rsum = new long [1000][];
        for(int r=0; r<1000; r++)
        {
            rsum[r] = new long[r+2];
            rsum[r][0] = 0;
            for(int c=0; c<=r; c++)
                rsum[r][c+1] = tri[r][c] + rsum[r][c];
        }

        long gmin = Long.MAX_VALUE;
        for(int r=0; r<1000; r++)
        for(int c=0; c<=r; c++)
        {
            long cur = tri[r][c];
            for(int d = r+1; d<1000; d++)
            {
                cur += rsum[d][d-r+c+1]-rsum[d][c] ;
                gmin = Math.min(gmin, cur);
            }
        }
        System.out.println(gmin);
    }

}
