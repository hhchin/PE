import java.util.*;

public class e172
{
    public static void main(String [] args)
    {
        HashMap<node, Long> Q = new HashMap<node, Long>();
        node head = new node();
        ArrayList<node> move = head.firstMove();
        for(node N : move)
            Q.put(N, 1L);

        for(int i=1; i<18; i++)
        {
            HashMap<node, Long> next_Q = new HashMap<node, Long>();
            Set<node> cur = Q.keySet();
            for(node N: cur)
            {
                ArrayList<node> next = N.nextMove();
                for(node next_N: next)
                {
                    long val = 0L;
                    if(next_Q.containsKey(next_N)) val = next_Q.get(next_N);
                    next_Q.put(next_N, val+Q.get(N));
                }
            }
            Q = next_Q;
        }
        long soln = 0L;
        Set<node> ks = Q.keySet();
        for(node N: ks)
            soln+=Q.get(N);
        System.out.println(soln);
    }

    static class node
    {
        int [] arr;

        public node()
        {
            arr = new int[10];
        }

        public node(int [] arr)
        {
            this.arr = arr;
        }

        public ArrayList<node> nextMove()
        {
            ArrayList<node> M = new ArrayList<node>();
            for(int i=0; i<arr.length; i++)
                if(arr[i]<3)
                {
                    int [] new_arr = new int[10];
                    System.arraycopy(arr,0,new_arr,0,10);
                    new_arr[i]++;
                    M.add(new node(new_arr));
                }
            return M;
        }

        public ArrayList<node> firstMove()
        {
            ArrayList<node> M = new ArrayList<node>();
            for(int i=1; i<arr.length; i++)
            {
                int [] new_arr = new int[10];
                new_arr[i] = 1;
                M.add(new node(new_arr));
            }
            return M;
        }

        public int hashCode()
        {
            return Arrays.hashCode(arr);
        }

        public boolean equals(Object O)
        {
            node N = (node)O;
            for(int i=0; i<N.arr.length; i++)
                if(N.arr[i] != arr[i]) return false;
            return true;

        }
    }
}
