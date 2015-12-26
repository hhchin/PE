import java.util.*;

public class e170
{
    public static void main (String [] args)
    {
        permutation("9876543210");
    }


    public static long GCD(long a, long b)
    {
        if(a == 0) return b;
        return GCD(b%a, a);
    }

    public static void testString(String str, int s, long gcd, LinkedList<Long> arr)
    {  
        if(arr.size() == 0)
        {
            for(int i=s+1; i<=str.length(); i++)
            {
                long val = Long.parseLong(str.substring(s,i));
                if(val % 3 != 0) continue;
                arr.push(val);
                testString(str,i, val, arr);
                arr.pop();
            }
        }
        if(s>=str.length()) //
        {
            if(arr.size()==1) return; //only 1 item

            String test = ""+gcd;
            for(Long L : arr)
            {
                if(L==0 || L== 1) return;
                test += (L/gcd);
            }
        //    System.out.println(arr+":"+gcd+"->"+test);
            char [] CArr = test.toCharArray();
            Arrays.sort(CArr);
            String sortedTest = new String(CArr);
            if(sortedTest.equals("0123456789"))
            {
                System.out.println("soln");
                System.out.println(str);
            }
        }
        else
        {
            for(int i=s+1; i<=str.length(); i++)
            {
                long val = Long.parseLong(str.substring(s,i));
                long temp_gcd = GCD(Math.min(val, gcd), Math.max(val, gcd));
                if(temp_gcd%3 != 0) continue;
                arr.push(val);
                testString(str,i, temp_gcd, arr);
                arr.pop();
            }
        }
    }

   
    
    public static void permutation(String str) 
    { 
        permutation("", str); 
    }

    private static void permutation(String prefix, String str) 
    {
        int n = str.length();
        if (n == 0) testString(prefix,0, 0, new LinkedList<Long> ());
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

}
