import java.util.*;

public class e347
{

    static int N = 10000000;
//    static int N = 100;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    static HashMap<ArrayList<Integer>, Integer> hm = new HashMap<ArrayList<Integer>,Integer>();

    public static void main (String [] args)
    {
        for(int i=0; i<N+1; i++)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(i);
            arr.add(temp);
        }

        for(int i=2; i<N+1; i++)
        {
            ArrayList<Integer> temp = arr.get(i);
            if(temp.size()==1 && temp.get(0) == i)
            {
                for(int j=2; j*i<N+1; j++)
                {
                    ArrayList<Integer> temp2 = arr.get(i*j);
                    int r = temp2.remove(temp2.size()-1);
                    while(r%i==0)
                        r/=i;
                    temp2.add(i);
                    if(r>1)
                        temp2.add(r);
                    arr.set(i*j, temp2);
                }
            }
            if(temp.size()==2)
            {
                if(!hm.containsKey(temp))
                    hm.put(temp, i);
                else
                {
                    int n = hm.get(temp);
                    hm.put(temp, Math.max(n,i));
                }
            }
        }

        long soln = 0L;
        Set<ArrayList<Integer>> ks = hm.keySet();
        for(ArrayList<Integer> k : ks)
            soln+=hm.get(k);
        System.out.println(soln);

            

    }

}
