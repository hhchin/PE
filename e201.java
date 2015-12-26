import java.util.*;

public class e201
{
    public static void main (String [] args)
    {
        int MAGIC = 295425;
        long check = 1L<<50;
        long [] arr = new long [295425+1];

        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(0);
        arr[0] = 1L;

        for(int i=1; i<=3; i++)
        {
            int ii = i*i;
            HashSet<Integer> new_hs = new HashSet<Integer>();
            for(Integer n:hs)
            {
                int cur = n+ii;
                if(cur == MAGIC)
                {
                    System.out.print(n+":"+i+":");
                    System.out.println(arr[cur]);
                }

                long val = arr[n];
                if(cur>=arr.length || ((val*2L)>(check))) continue;
                arr[cur] = (arr[cur] | (val*2L));
                new_hs.add(n);
                new_hs.add(cur);
            }
            hs = new_hs;
            for(Integer n: hs)
                System.out.println(n+":"+arr[n]);
            System.out.println();
        }
/*
        long sum = 0L;
        for(int i=1; i<arr.length; i++)
            if((arr[i] & check )== check)
            {
                sum+=i;
            }

        System.out.println(sum);
        System.out.println(check);
        System.out.println((arr[MAGIC] & check));
*/
    }


}
