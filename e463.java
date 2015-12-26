import java.util.*;
import java.math.BigInteger;

public class e463
{
    public static long N  = 450283905890997363L;
    public static BigInteger res = new BigInteger("89173845");
//    public static long N = 100L;
 //   public static BigInteger res = new BigInteger("1365");
    public static BigInteger bigtwo = new BigInteger("2");
    public static void main (String [] args)
    {
        long b = 1;
        int cnt = 0;
        while(b<N)
        {
            cnt++;
            b*=2;
        }
        b/=2;
        cnt--;
        long diff = N-b+1;
        System.out.printf("pow %d diff %d\n", cnt, diff);
        BigInteger seg = new BigInteger("4");
        seg = seg.pow(cnt);

        solve(seg, diff, b/2, bigtwo.pow(cnt-1), bigtwo);
        System.out.println(res.mod(new BigInteger("1000000000")));

    }   

    public static void solve(BigInteger seg, long cur, long lvl, BigInteger len, BigInteger offset)
    {
       
        System.out.print("seg :"+seg+" len "+len+" off "+offset+" ");
        BigInteger diff = len.multiply(offset);
        BigInteger half = seg.subtract(diff);
        half = half.divide(bigtwo);

        if(cur == lvl)
        {
            System.out.printf("case 0\n");
            res = res.add(half);
            return;
        }
        if(cur >  lvl)
        {
            System.out.printf("case 1: cur %d lvl %d\n", cur, lvl);
            res = res.add(half);
            solve(half.add(diff), cur-lvl, lvl/2, len.divide(bigtwo), offset.multiply(bigtwo));
        }
        else
        {
            System.out.printf("case 2: cur %d lvl %d\n", cur, lvl);
            solve(half, cur, lvl/2, len.divide(bigtwo), offset.multiply(bigtwo));
        }
    }
}
