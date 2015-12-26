import java.util.*;

public class e143
{
    static long L = 120000L;
    static long LSQ = 347;

    static long GCD(long a, long b)
    {
        return a==0? b : GCD(b%a, a);
    }

    public static void main (String [] args)
    {
        ArrayList<Pair> arr = new ArrayList<Pair>();

        for(long u=1; u<LSQ; u++)
        for(long v=1; v<u; v++)
        {
            if(GCD(v,u)!=1) continue;
            if( (u-v)%3 == 0) continue;
            long a = 2*u*v+v*v;
            long b = u*u-v*v;
            if(a+b>L) break;
            for(long k=1; k*(a+b)<L; k++)
            {
                arr.add(new Pair(k*a, k*b));
                arr.add(new Pair(k*b, k*a));
            }
        }
        Collections.sort(arr);

        int [] index = new int[(int)L];
        Arrays.fill(index,-1);
        for(int i=0; i<arr.size(); i++)
            if(index[ (int)(arr.get(i).x)]==-1)
                index[(int)(arr.get(i).x)] = i;
        boolean [] sums = new boolean[(int)L];

        for(Pair p : arr)
        {
            ArrayList<Long> va = new ArrayList<Long>();
            ArrayList<Long> vb = new ArrayList<Long>();
            long a = p.x;
            long b = p.y;
            int ia = index[(int)a];
            int ib = index[(int)b];
            while(ia<arr.size())
            {
                Pair tp = arr.get(ia);
                if(tp.x!=a) break;
                va.add(tp.y);
                ia++;
            }

            while(ib<arr.size())
            {
                Pair tp = arr.get(ib);
                if(tp.x!= b) break;
                vb.add(tp.y);
                ib++;
            }

            for(long ja : va)
                for(long jb : vb)
                    if((ja == jb) && (a+b+ja < L))
                        sums[ (int)(a+b+ja)] = true;     
        }

        long soln = 0;
        for(int i=0; i<L ;i++)
            if(sums[i]) soln+=i;
        System.out.println(soln);
    }

    static class Pair implements Comparable<Pair>
    {
        public long x,y;
        public Pair(long x, long y)
        {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair p)
        {
            if(p.x==x) return (int)(y-p.y);
            return (int)(x-p.x);
        }
    }
}
