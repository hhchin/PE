import java.util.*;

public class e95
{
    public static int LIM = 1000000;
    public static long [] div = new long [LIM];
    public static boolean [] visited  = new boolean [LIM];
    public static int [] cycle = new int [LIM];

    public static void main (String [] args)
    {
        genDiv();    

        for(int i=1; i<visited.length; i++)
            if(!visited[i])
                trace(i);

        int maxCycle = 0;
        int index = 0;
        for(int i=1; i<cycle.length; i++)
            if(cycle[i]>maxCycle)
            {
                maxCycle = cycle[i];
                index = i;
            }
        System.out.println(index);
        System.out.println(maxCycle);
        System.out.println(cycle[12496]);

    }

    private static void trace(int i)
    {   
        LinkedList<Integer> stack = new LinkedList<Integer>();
        HashSet<Integer> hs = new HashSet<Integer>();
        int cycle_len = 0;
        int cur_count = 0;
        int loop_pos = 0;
        while(i<LIM)
        {
            if(!hs.contains(i))
            {
                stack.push(i);
                hs.add(i);
                cycle[i] = cur_count;
                cur_count++;
                if(div[i]<LIM)
                {
                    i = (int)div[i];
                }
                else
                {   
                    cycle_len = 0;
                    break;
                }

            }
            else
            {
                cycle_len = cur_count - cycle[i];
                loop_pos = i;
                break;
            }
        }

        while(stack.size()>0)
        {
            Integer N = stack.pop();
            visited[N] = true;
            cycle[N] = cycle_len;
            if(N==loop_pos)
                cycle_len = 0;

        }
    }

    private static void genDiv()
    {
        for(int i=1; i<div.length; i++)
            div[i] = 1;
        for(int i=2; i<div.length; i++)
            for(int j=2; j*i<div.length; j++)
                div[i*j]+=i;
    }

}
