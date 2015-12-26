import java.util.*;

public class e203
{
    public static void main (String [] args)
    {
        long [][] coeff = new long[51][51];
        coeff[0][0] = 1;
        coeff[1][0] = 1;
        coeff[1][1] = 1;
        HashSet<Long> hs = new HashSet<Long>();
        for(int r=2; r<coeff.length; r++)
        {
            coeff[r][0] = 1;
            for(int c=1; c<=r; c++)
            {
                coeff[r][c] = coeff[r-1][c-1] + coeff[r-1][c];
                hs.add(coeff[r][c]);
            }

        }

        long soln = 0;
        for(Long L: hs)
            if(L%4!=0 && L%9!=0 && L%25!=0 && L%49!=0)
                soln+=L;
        System.out.println(soln);

    

    }
}
