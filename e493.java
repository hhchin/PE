import java.util.*;
import java.math.*;
public class e493
{
    public static BigInteger [][] binom = new BigInteger[71][71];
    public static BigInteger [] fac =new BigInteger[11];
    public static BigInteger cur_num;
    public static BigInteger tot_num = BigInteger.ZERO;
    public static BigInteger dem;
    public static int [] color = new int[7];

    public static void main (String [] args)
    {
        binom[1][0] = BigInteger.ONE; binom[1][1] = BigInteger.ONE;
        for(int r=2; r<binom.length; r++)
        {
            binom[r][0] = BigInteger.ONE;
            binom[r][r] = BigInteger.ONE;
            for(int c=1; c<r; c++)
                binom[r][c] = binom[r-1][c-1].add(binom[r-1][c]);
        }
        fac[1] = BigInteger.ONE;
        for(int i=2; i<fac.length; i++)
            fac[i] = fac[i-1].multiply(new BigInteger(""+i));
        dem = binom[70][20];

        for(int c=1; c<=7; c++)
        {
            cur_num = BigInteger.ZERO;
            solve(0,c,10,20,  new ArrayList<Integer>());
            tot_num = tot_num.add(cur_num);
        }

        double soln = tot_num.doubleValue();
        soln /= dem.doubleValue();
        System.out.printf("%1.10f\n",soln);

    }

    public static BigInteger genCoeff(ArrayList<Integer> arr)
    {
        BigInteger val = binom[7][arr.size()];
        int [] counter = new int[11];
        for(Integer n: arr)
            counter[n]++;
        val = val.multiply(fac[arr.size()]);
        for(int i=1; i<counter.length; i++)
            if(counter[i]>0)
                val = val.divide(fac[counter[i]]);
        return val;
    }

    public static void solve(int curc, int maxc, int val, int rem, ArrayList<Integer> arr)
    {
        if(curc == maxc && rem ==0)
        {
            BigInteger num = BigInteger.ONE;
            for(Integer n: arr)
                num = num.multiply(binom[10][n]);
            BigInteger cur_val = num.multiply(genCoeff(arr));
            cur_val = cur_val.multiply(new BigInteger(""+maxc));
            cur_num = cur_num.add(cur_val);
        }
        if(curc < maxc && rem > 0)
        {
            for(int i=Math.min(val, rem); i>0; i--)
            {
                ArrayList<Integer> temp = new ArrayList<Integer>(arr);
                temp.add(i);
                solve(curc+1, maxc, i, rem-i, temp);
            }
        }
    }
}
