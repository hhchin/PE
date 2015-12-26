import java.util.*;

public class e149
{
    public static long [][] M = new long [2000][2000];
    public static boolean [][] vis = new boolean[2000][2000];
    public static void main (String [] args)
    {
        int n = 2000*2000+1;
        long base = 1000000;
        long [] lg = new long[n];
        for(int i=1; i<=55; i++)
        {
            long k= (long)i;
            lg[i] = ((100003L - 200003L*k+300007L*k*k*k)%base+base)%base-500000L;
        }
        for(int i=56; i<lg.length; i++)
            lg[i] = ((lg[i-24]+lg[i-55]+base) % base+base) % base - 500000L;

        System.out.println(lg[10]);
        System.out.println(lg[100]);
        int cnt = 0;
        for(int r=0; r<2000; r++)
            for(int c=0; c<2000; c++)
            {
                M[r][c] = lg[cnt];
                cnt++;
            }

        long soln = Long.MIN_VALUE;
        soln = Math.max(testD(1,0), soln);
        soln = Math.max(testD(0,1), soln);
        soln = Math.max(testD(1,1), soln);
        soln = Math.max(testD(1,-1), soln);
        System.out.println(soln);

    }

    public static long testD(int dr, int dc)
    {
        long curMax = 0;
        vis = new boolean[2000][2000];

        for(int r=0; r<M.length; r++)
            for(int c=0; c<M[0].length; c++)
            {
                if(vis[r][c]) continue;
                ArrayList<Long> arr = gen(r,c, dr, dc);
                curMax = Math.max(curMax, mcs(arr));
            }
        return curMax;
    }

    public static ArrayList<Long> gen(int r, int c, int dr, int dc)
    {
        ArrayList<Long> arr = new ArrayList<Long>();
        while(r>=0 && r<M.length && c>=0 && c<M[0].length)
        {
            vis[r][c] = true;
            arr.add(M[r][c]);
            r+=dr;
            c+=dc;
        }
        return arr;
    }

    public static Long mcs(ArrayList<Long> arr)
    {
        long cur = arr.get(0);
        long max = cur;
        for(int i=1; i<arr.size(); i++)
        {
            cur = Math.max(arr.get(i), cur+arr.get(i));
            max = Math.max(max, cur);
        }
        return max;
    }
}
