import java.util.*;

public class e171
{
    public static boolean [] sq = new boolean[2000];
    public static void main (String [] args)
    {

        long base = 1000000000;
        for(int i=1; i*i<sq.length; i++)
            sq[i*i] = true;

        HashMap<Integer, Long> count = new HashMap<Integer, Long>();
        HashMap<Integer, Long> sum = new HashMap<Integer, Long>();
        for(int i=0; i<10; i++)
        {
            count.put(i*i,1L);
            sum.put(i*i, (long)i);
        }

        for(int i=1; i<20; i++)
        {
            HashMap<Integer, Long> tmp_count = new HashMap<Integer, Long>();
            HashMap<Integer, Long> tmp_sum = new HashMap<Integer, Long>();
            Set<Integer> ks = count.keySet();
            for(Integer n: ks)
            {
                long c = count.get(n);
                long s = sum.get(n);

                for(int d=0; d<10; d++)
                {
                    int new_n = n+d*d;
                    long new_c = c;
                    long new_s = (s*10+d*c)%base;
  //                  if(new_n==100) System.out.println(n+":"+d+":"+new_n+"->"+val);
                    if(tmp_count.containsKey(new_n)) 
                    {
                        new_c += tmp_count.get(new_n);
                        new_s += tmp_sum.get(new_n);
                    }

                    tmp_count.put(new_n, new_c%base);
                    tmp_sum.put(new_n, new_s%base);
                }
            }
            count = tmp_count;
            sum  = tmp_sum;

      //      System.out.println(hm);
        }

        long soln = 0L;
        Set<Integer> ks = sum.keySet();
        for(Integer n: ks)
        {
            if(sq[n])
            {
                soln = (soln+sum.get(n))%base;
            }
            
        }

        System.out.println(soln);


    }
}
