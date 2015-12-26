import java.util.*;

public class e315
{
    static int [][] trans = new int[11][11];

    static ArrayList<Integer> prime = new ArrayList<Integer>();
    public static void main (String [] args)
    {
        genPrime();

     //   System.out.println(transCost(2,-1));
      //  System.out.println(transCost(11,2));
       // System.out.println(transCost(137,11));
        
        
        int n = 10000000;
        long soln = 0L;
        for(int i=n; i<=2*n; i++)
            if(isPrime(i))
                soln += samCost(i)-maxCost(i);
        System.out.println(soln);
       
    }

    static boolean isPrime(int n)
    {
        for(Integer p: prime)
        {
            if(p*p>n) break;
            if(n%p==0) return false;
        }
        return true;
    }

    static long samCost(int n)
    {
        long cost= 0;
        cost+=2*transCost(n,-1);
        while(n>9)
        {
            int next_n = digitRoots(n);
            cost+=2*transCost(next_n,-1);
            n = next_n;
        }
        return cost;

    }
    static long maxCost(int n)
    {
        long cost = 0;
        cost+=transCost(n,-1);
        while(n>9)
        {
            int next_n = digitRoots(n);
            cost+=transCost(n, next_n);
            n = next_n;
        }
        return cost+=transCost(n,-1);
    }

    
    static long transCost(int s, int t)
    {
        int [] D = {0x7d, 0x50, 0x37, 0x57, 0x5a, 0x4f, 0x6f, 0x59, 0x7f, 0x5f, 0x0};
        long cost = 0L;
        LinkedList<Integer> ds = intDigits(s);
        if(t==-1)
        {
            for(Integer d: ds)
                cost+=Integer.bitCount(D[d]);
            return cost;
        }
        LinkedList<Integer> dt = intDigits(t);
//        System.out.println(ds+":"+dt);
        while(dt.size()>0)
        {
            cost+=Integer.bitCount(D[dt.removeLast()]^D[ds.removeLast()]);
//            System.out.println(cost);
        }
        while(ds.size()>0)
            cost+=Integer.bitCount(D[ds.removeLast()]);
        return cost;

    }

    static int digitRoots(int n)
    {
        LinkedList<Integer> dn = intDigits(n);
        int res = 0;
        for(Integer d:dn)
            res+=d;
        return res;
    }

    static void genPrime()
    {
        boolean [] arr = new boolean[10000];
        Arrays.fill(arr, true);
        for(int i=2; i<arr.length; i++)
            if(arr[i])
                for(int j=2; i*j<arr.length; j++)
                    arr[i*j] = false;
        for(int i=2; i<arr.length; i++)
            if(arr[i])
                prime.add(i);
    }

    static LinkedList<Integer> intDigits(int n)
    {
        LinkedList<Integer> digits = new LinkedList<Integer>();
        while(n>0)
        {
            digits.push(n%10);
            n/=10;
        }
        return digits;
    }
}
