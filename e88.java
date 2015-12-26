import java.util.*;

public class e88 
{
    public static int MAXK = 12000;
    public static int MAXN = 2*MAXK;
    public static LinkedList<Node> Q = new LinkedList<Node>();
    public static int [] res = new int[MAXK+1];
    public static void main (String [] args)
    {
        //base case
        for(int x=2; x<=MAXN; x++)
            for(int y=x; x*y<=MAXN; y++)
                Q.add(new Node(x*y, x+y, 2, y));

        int depth = 0;

        for(int i=1; i<res.length; i++)
            res[i] = 2*i;
        while(Q.size()>0)
        {
            Node N = Q.pollFirst();
            int K = N.F+N.P-N.S;
            if(K<=MAXK) res[K] = Math.min(res[K], N.P);
            ArrayList<Node> next = N.genNext();
            for(Node nx: next) Q.add(nx);
            System.out.println(Q.size());
        }

        long soln = 0;
        HashSet<Integer> check = new HashSet<Integer>();
        for(int i=2; i<res.length; i++)
            if(!check.contains(res[i]))
            {
                soln+=res[i];
                check.add(res[i]);
            }
        System.out.println("soln: "+soln);
    }

    static class Node
    {
        int P,S,F, last;
        
        public Node( int P,  int S, int F, int last)
        {
            this.P = P;
            this.S = S;
            this.F = F;
            this.last = last;
        }

        public ArrayList<Node> genNext()
        {
            ArrayList<Node> next = new ArrayList<Node>();
            for(int i=last; P*i<=MAXN; i++)
                next.add(new Node(P*i, S+i, F+1, i));
            return next;
        }

        public String toString()
        {
            return "P: "+P+" S:"+S+" F:"+ F;
        }
    }
}
