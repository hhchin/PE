import java.util.*;

public class e157
{
    public static int N = 9;
//    public static int M = (int)(Math.sqrt(Math.pow(2,N) * Math.pow(5,N)+0.5));
    public static int M = ((int) (Math.pow(10,N)*1.2));
    public static ArrayList<Integer> prime = new ArrayList<Integer>();
    
    public static void main (String [] args)
    {
        makePrime();
        System.out.println("prime limit: " + M);
        long soln = 0;
        for(int n=1; n<=N; n++)
        {
            int curP = 1;
            for(int i=0; i<n; i++)
                curP*=10;
            ArrayList<Integer> divP = new ArrayList<Integer>();
            int A = 1;
            for(int i=0; i<=n; i++)
            {
                int B = 1;
                for(int j=0; j<=n; j++)
                {
                    divP.add(A*B);
                    B*=2;
                }
                A*=5;
            }
            for(int i=0; i<divP.size(); i++)
            for(int j=i; j<divP.size(); j++)
            {
                int a = divP.get(i);
                int b = divP.get(j);
                if(GCD(a,b) == 1 && a*b <= curP)
                {
                    int P =(int)(((long)curP*(long)(a+b))/(long)(a*b));
//                    System.out.printf("%d : %d : %d-> %d\n",a,b,P, noDiv(P));
                    soln+= noDiv(P);
                }
            }
        }
        System.out.println(soln);

    }

    private static int GCD(int A, int B)
    {
        return ((A==0) ? B : GCD(B%A, A));
    }   

    private static int noDiv(int n)
    {
        int res = 1;
        for(Integer P : prime)
        {
            if(n==1 || n<P) break;
            if(n % P == 0)
            {
                int fac = 0;
                while(n%P==0)
                {
                    n/=P;
                    fac++;
                }
                res*=(fac+1);
            }
        }
        return res;
    }
    private static void makePrime()
    {
        boolean [] primeArr = new boolean [M];
        for(int i=0; i<primeArr.length; i++)
            primeArr[i] = true;
        for(int i=2; i<primeArr.length; i++)
        if(primeArr[i])
        {
            int ind = (primeArr.length-1)/i;
            for(int j=2; j<=ind; j++)
                primeArr[i*j] = false;
        } 
        for(int i=2; i<primeArr.length; i++)
        if(primeArr[i])
            prime.add(i);
    }


}
