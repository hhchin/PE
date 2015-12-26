import java.util.*;

public class e467
{
    public static int N=10000;
    public static long B = 1000000007;
    public static boolean [] isPrime = new boolean[10*N];
    public static int [] dRoots = new int[10*N];
    public static int [] Pn = new int[N];
    public static int [] Cn = new int[N];
    public static boolean [] Pmark = new boolean[N];
    public static boolean [] Cmark = new boolean[N];
    public static int [][] M = new int[N+1][N+1];

    public static void main (String [] args)
    {
        for(int i=0; i<isPrime.length; i++)
            isPrime[i] = true;
        isPrime[2] = true;
        for(int i=2; i<isPrime.length; i++)
        if(isPrime[i])
            for(int j=2; j*i<isPrime.length; j++)
                isPrime[i*j] = false;

        System.out.println("done primes");

        for(int i=1; i<10; i++)
            dRoots[i] = i;
        for(int i=10; i<isPrime.length; i++)
            dRoots[i] = dRoots[i/10+i%10];

        int Pcnt = 0;
        int Ccnt = 0;
        for(int i=2; i<isPrime.length; i++)
        {
            if(isPrime[i] && Pcnt<N)
            {
                Pn[Pcnt] = dRoots[i];
                Pcnt++;
            }
            if(!isPrime[i] && Ccnt<N)
            {
                Cn[Ccnt] = dRoots[i];
                Ccnt++;
            }
            if(Ccnt == N && Pcnt == N) break;
        }
        LCS();
        System.out.println(M[N][N]);
        
    }


    private static long superIntString(ArrayList<Integer> si)
    {
        long res =1;
        long soln = 0;
        for(Integer n: si)
        {
            soln+= ((long)n*res) %B;
            res = (10*res) % B;
        }
        return soln%B;
    }

    public static void LCS()
    {
        for(int i=1; i<=N; i++)
        for(int j=1; j<=N; j++)
        if(Pn[i-1] == Cn[j-1])
            M[i][j] = M[i-1][j-1]+1;
        else
            M[i][j] = Math.max(M[i][j-1], M[i-1][j]);
    }



}
