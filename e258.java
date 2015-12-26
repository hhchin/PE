import java.util.*;

public class e258
{
    public static long B = 20092010;
    public static long N = (long)1e18;
    public static long P = 2000;
    public static void main (String [] args)
    {
        long [][] A = new long [(int)P][(int)P];
        for(int i=0; i<(int)P-1; i++)
        {
            A[i][i] = 1;
            A[i][i+1] = 1;
        }
        A[(int)P-1][0]=1;
        A[(int)P-1][1]=1;
        A[(int)P-1][(int)P-1]=1;

        long [][] res = powmod(A, N/P, B);

        long accum = 0L;
        for (int i=0; i<(int)P; i++)
            accum = (accum+res[0][i])%B;
        System.out.println(accum);

    }

    public static long[][] powmod(long [][] A, long k, long b)
    {
        int n = A.length;
        if(k==0)
        {
            long [][] eye = new long[n][n];
            for(int i=0; i<n; i++)
                eye[i][i] = 1L;
            return eye;
        }

        if(k==1) return A;

        long [][] temp = powmod(A, k/2, b);
        temp = multmod(temp,temp,b);
        if(k%2 ==1) temp = multmod(A,temp,b);
        
        System.out.println(k); 
        return temp;
    }

    public static long [][] multmod(long [][] x, long [][] y, long b)
    {
        int n = x.length;
        long [][] res = new long[n][n];

        for(int r=0; r<n; r++)
        for(int c=0; c<n; c++)
        {
            long accum = 0L;
            for(int i=0; i<n; i++)
                accum+=x[r][i]*y[i][c];
            res[r][c] = accum%b;
        }
        return res;
    }
}
