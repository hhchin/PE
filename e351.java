import java.util.*;

public class e351
{
    public static void main (String [] args)
    {
        int order = 100000000;
        //int order  = 5;
        LinkedList<Pt> Q = new LinkedList<Pt>();
        HashSet<Pt> hs = new HashSet<Pt> ();
        long soln = 0;
        Q.addLast(new Pt(1,1, order));
        hs.add(Q.peek());
        while(Q.size()>0)
        {
            Pt cur = Q.removeFirst();
            soln++;
            ArrayList<Pt> next = cur.move();
            for(Pt p : next)
            {
                Pt rep = p.rep();
                if(hs.contains(rep)) continue;
                hs.add(rep);
                Q.add(p);

                //                System.out.println(p);
            }
        }

        long lo = (long)(order);
        long tot = 3*(lo+1)*lo+1;
        System.out.println(soln);
        System.out.println(tot);

        System.out.println( tot-6*soln-1);

    }
    static class Pt
    {
        int x, y, depth;

        public Pt(int x, int y, int depth)
        {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        public String toString()
        {
            return String.format("(%d, %d, %d) ",x,y,depth);
        }

        public ArrayList<Pt> move()
        {
            ArrayList<Pt> next = new ArrayList<Pt>();
            if(depth==1)
                return next;
            next.add(new Pt(x-1, y+1, depth-1));
            next.add(new Pt(x+1, y+1, depth-1));
            //next.add(new Pt(x+1, y, depth-1));
            return next;
        }

        public int GCD(int a, int b)
        {
            if(a==0) return b;
            return GCD(b%a, a);
        }

        public Pt rep()
        {
            if(x==0) return new Pt(0,2, depth);
            int tx = x;
            int ty = y;
            int val = x<0 ? -1 : 1;
            tx = tx*val;
            int g = tx>ty ? GCD(tx,ty) : GCD(ty,tx);
            return new Pt(val*tx/g, ty/g, depth);
        }

        public int hashCode()
        {
            return x*y;
        }

        public boolean equals(Object o)
        {
            Pt p = (Pt)o;
            return p.x==x && p.y==y;
        }
    }
}
