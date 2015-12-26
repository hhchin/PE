import java.util.*;

public class e491
{
    public static void main (String [] args)
    {

        HashMap<node, Long> map = new HashMap<node, Long>();
        map.put(new node(), 1L);

        for(int i=0; i<19; i++)
        {
            HashMap<node, Long> temp = new HashMap<node, Long>();
            Set<node> ks = map.keySet();
            for(node n: ks)
            {
                long count = map.get(n);
                ArrayList<node> next = n.next(0,10);
                for(node n_next: next)
                {
                    long count_next = count;
                    if(temp.containsKey(n_next)) count_next+=temp.get(n_next);
                    temp.put(n_next, count_next);
                }
            }
            map = temp;
            System.out.println("iter: "+i+"->"+map.size());

            //Set<node> dbg_ks=  map.keySet();
            //for(node n: dbg_ks) System.out.println(n);

        }
        for(int i=0; i<1; i++)
        {
            HashMap<node, Long> temp = new HashMap<node, Long>();
            Set<node> ks = map.keySet();
            for(node n: ks)
            {
                long count = map.get(n);
                ArrayList<node> next = n.next(1,10);
                for(node n_next: next)
                {
                    long count_next = count;
                    if(temp.containsKey(n_next)) count_next+=temp.get(n_next);
                    temp.put(n_next, count_next);
                }
            }
            map = temp;
            System.out.println("iter final: ->"+map.size());
        }

        node term = new node();
        for(int i=0; i<10; i++)
            term.D[i] = 2;
        term.mod = 0;
        Set<node> ks=  map.keySet();
        for(node n: ks)
        {
            //System.out.println(n);
            if(term.equals(n))
                 System.out.println(map.get(n));
        }

    }

    static class node
    {
        int [] D;
        int mod;

        public node()
        {
            D = new int[10];
            mod = 0;
        }

        public node(int [] D, int d, int mod)
        {
            this.D = new int[10];
            for(int i=0; i<10; i++)
                this.D[i] = D[i];
            this.D[d]++;
            this.mod = mod;

        }
        public ArrayList<node> next(int s, int t)
        {
            ArrayList<node> nextArr = new ArrayList<node>();
            for(int i=s; i<t; i++)
                if(D[i]<2)
                    nextArr.add(new node(D,i, (10*mod+i)%11));
            return nextArr;
        }

        public int hashCode()
        {
            return Arrays.hashCode(D)+mod;
        }

        public boolean equals(Object o)
        {
            node N = (node)o;
            for(int i=0; i<10; i++)
                if(D[i] != N.D[i]) return false;
            return mod == N.mod;
        }

        public String toString()
        {
            return Arrays.toString(D)+","+mod;
        }
    }

}
