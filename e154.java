import java.util.*;

public class e154
{
    public static int EXP = 200000;
    public static long [] twoArr = new long[EXP+1];
    public static long [] fiveArr = new long[EXP+1];



    public static void main(String [ ]args)
    {

        double log2 = Math.log(2);
        double log5 = Math.log(5);

        for(int i=2; i<twoArr.length; i++)
        {
            twoArr[i] = (long)genExp(i,2);
            fiveArr[i] = (long)genExp(i,5);
        }

        for(int i=1; i<twoArr.length; i++)
        {
            twoArr[i]+= twoArr[i-1];
            fiveArr[i]+= fiveArr[i-1];
        }

        //loop over
        long soln = 0;
        int maxi = EXP/3;
        for(int i=0; i<=maxi; i++)
        {
            soln+= check(i,i, EXP-i-i,0);
            if(i%2 == 0) soln+=check(i, (EXP-i)/2, (EXP-i)/2,0);
            for(int j=i+1; j<= (EXP-i)/2; j++)
            {
                int k = EXP-i-j;
                if(k==j) continue;
                soln+=check(i,j,k,1);
            }
        }
        System.out.println(soln);

    /*
        for(int i=0; i<10; i++)
        {
            System.out.printf("%d -> %d : %d \n", i, twoArr[i], fiveArr[i]);
        }
    */
    }

    private static long check(int i, int j, int k, int mode)
    {
        long twoCount = twoArr[EXP] - twoArr[i] - twoArr[j] - twoArr[k];
        long fiveCount = fiveArr[EXP] - fiveArr[i] - fiveArr[j] - fiveArr[k];
        long tenCount = Math.min(twoCount, fiveCount);
        if(mode==0 && tenCount>=12) return 3;
        if(mode==1 && tenCount>=12) return 6;
        return 0;
    }

    private static int genExp(int val, int fac)
    {
        int count = 0;
        while(val % fac == 0)
        {
            count++;
            val/=fac;
        }
        return count;
    }
}
