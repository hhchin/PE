import java.util.*;

public class e60
{
    public static int N = 100000000;
    public static int LN = 10000;
    public static int res = Integer.MAX_VALUE;
    public static ArrayList<Integer> prime;
    public static void main (String [] args)
    {
        genPrime();
        solve(new HashSet<Integer>(), -1, 0,0);
        
    }

    private static HashSet<Integer> test(HashSet<Integer> hs, int p)
    {
        HashSet<Integer> new_hs = new HashSet<Integer>();
        if(hs.size()==0)
        {
            new_hs.add(p);
            return new_hs;
        }
        
        for(Integer n: hs)
        {
            if(isPrime(concat(n,p)) && isPrime(concat(p,n)))
                new_hs.add(n);
        }
        if(new_hs.size() == hs.size())
            new_hs.add(p);
        else
            new_hs.clear();

        return new_hs;
    }

    private static void solve(HashSet<Integer> hs, int st, int depth, int cur_res)
    {
        for(int i=st+1; i<prime.size(); i++)
        {
            int cur_prime = prime.get(i);
            if((5-depth)*cur_prime+cur_res>res) return;
            HashSet<Integer> hs_prime = test(hs, cur_prime);
            
            if(hs_prime.size()!=0) //valid case
            {
                int new_res = cur_res+cur_prime;
                int new_depth = depth+1;
                if(new_depth==5)
                {
                    res = new_res;
                    System.out.println("new min sum "+res+":"+hs_prime);
                    return;
                }
                else
                {
                 //   System.out.println("solving : " + hs_prime);
                    solve(hs_prime, i+1, new_depth, new_res);
                }
            }
        }
    }

    private static int concat(int a, int b)
    {
        int res = b;
        int shift = 1;
        while(b>0)
        {
            shift*=10;
            b/=10;
        }
        while(a>0)
        {   
            res+= shift*(a%10);
            a/=10;
            shift*=10;
        }
        return res;
    }

    private static boolean isPrime(int n)
    {
        int lim = (int)Math.ceil(Math.sqrt((double)n));
        for(int i=0; i<prime.size(); i++)
        {
            int P  = prime.get(i);
            if(P>lim) break;
            if(n%P == 0) return false;
        }
        return true;
    }

    private static void genPrime()
    {
        boolean [] arr = new boolean [LN];
        prime = new ArrayList<Integer>();

        for(int i=0; i<arr.length; i++)
            arr[i] = true;
        for(int i=2; i<arr.length; i++)
        if(arr[i])
        {
            prime.add(i);    
            for(int j=2; i*j<arr.length; j++)
                arr[i*j] = false;
        }
    }

}

