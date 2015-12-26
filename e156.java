import java.util.*;

public class e156
{

    public static ArrayList<Long> found;
    public static HashMap<Long, Long> count_memo= new HashMap<Long, Long>();
    public static long ans = 0;
    public static long D=1;

    public static void main (String [] args)
    {
    
        long M=1;
        for(int i=0; i<11; i++)
            M*=10;

        for(D=1; D<10; D++)
        {
            count_memo = new HashMap<Long, Long>();
            search(1, M);
        }
        System.out.println(ans);
    }

    public static void search(long L, long U)
    {
        if(U-L == 1)
        {
            if(count_fun(L) == L) ans+=L;
            return;
        }
        long M = (U+L)/2;
        long Lv = count_fun(L);
        long Mv = count_fun(M);
        long Uv = count_fun(U);

        if( Mv >= L && M >= Lv)
            search(L,M);

        if( Uv >= M && U >= Mv)
            search(M,U);

    }

    public static long count_fun(long n)
    {
        if(count_memo.containsKey(n))
            return count_memo.get(n);

        long count = 0;
        long fac = 1;

        while( n/fac != 0)
        {
            long lower = n-(n/fac)*fac;
            long cur = (n/fac)%10;
            long upper = n/(fac*10);
            
            if(cur<D)
                count += upper*fac;
            else if (cur == D)
                count += upper*fac+lower+1;
            else
                count += (upper+1)*fac;

            fac*=10;
        }

        count_memo.put(n, count);
        return count;
    }

}
