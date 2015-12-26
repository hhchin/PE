import java.util.*;

public class e159
{
    public static int N = 1000000;
    public static long [] mds = new long[N];

    public static void main (String [] args)
    {
        for(int i=2; i<mds.length; i++)
        {
            mds[i] = Math.max(mds[i], (i%9==0 ? 9 : i%9) );
            for(int j=2; j*i<mds.length; j++)
            {
                int ind = i*j;
                mds[ind] = Math.max(mds[ind], mds[i]+mds[j]);
            }
        }

        long soln = 0;
        for(int i=2; i<mds.length; i++)
            soln+= mds[i];
        System.out.println(soln);
    }
}
