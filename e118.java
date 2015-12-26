import java.util.*;

public class e118
{

    public static HashSet<LinkedList<Integer>> soln = new HashSet<LinkedList<Integer>>();
    public static ArrayList<Integer> primes = Euler.genPrime(100000);
    public static void main (String [] args)
    {
        System.out.println("generated primes of size "+ primes.size());
        permutation("123456789");
        Iterator<LinkedList<Integer>> iter = soln.iterator();
        for(int i=0; i<10; i++)
            System.out.println(iter.next());
        System.out.println(soln.size());
    }

    public static boolean isPrime(int n)
    {
        if(n==1) return false;
        for(Integer p : primes)
        {
            if(p*p> n) break;
            if(n%p == 0) return false;
        }
        return true;
    }

    public static void split(String S, LinkedList<Integer> L, int ind)
    {
        for(int i=ind+1; i<=S.length(); i++)
        {
            int p = Integer.parseInt(S.substring(ind,i));
            if(!isPrime(p)) continue;
            if(L.size()>0 && L.peek()> p) continue;
            L.push(p);
            if(i >= S.length() && L.size()>0)
            {
                LinkedList<Integer> temp = new LinkedList<Integer>(L);
            //    Collections.sort(temp);
                soln.add(temp);
            }
            else 
                split(S, L, i);
            L.pop();
        }
    }

    public static void permutation(String str) { 
        permutation("", str); 
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) split(prefix, new LinkedList<Integer>(), 0);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}
