import java.util.*;

public class e407
{
    public static EulerPack EP = new EulerPack();

    public static void main (String [] args)
    {
        long soln =0L;
        int N = 10000000;
//        int N = 10;

        ArrayList<ArrayList<Pair<Integer>>> fac = EP.genFactorsList(N);
        for(ArrayList<Pair<Integer>> n : fac)
        {
            if(n.size()==0) continue;
            if(n.size()==1) 
            {
                soln++;
                continue;
            }

            int [] mods = new int[n.size()];
            int [] cons = new int[n.size()];
            int cmax = 1;
            for(int i=0; i<mods.length; i++)
            {
                cmax *= 2;
                int p = n.get(i).x;
                int q = n.get(i).y;
                mods[i] = 1;
                for(int e=0; e<q; e++)
                    mods[i]*=p;
            }

            int comp_soln = 0;

            for(int c=0; c<cmax; c++)
            {
                for(int i=0; i<cons.length; i++)
                    cons[i] = (c&(1<<i))>>i;
                comp_soln = Math.max(comp_soln, CRT.solve(cons, mods));
            }
//            System.out.println(n+":"+comp_soln);
            soln+= comp_soln;

        }
        System.out.println(soln);
    }

    static class CRT
    {

        public static int[] euclidean(int a, int b)
        {
            if(b > a)
            {
                int[] coeffs = euclidean(b, a);
                int[] output = {coeffs[1], coeffs[0]};
                return output;
            }

            int q = a/b;
            int r = a -q*b;

            if(r == 0)
            {
                int[] output = {0, 1};
                return output;
            }

            int[] next = euclidean(b, r);

            int[] output = {next[1], next[0] - q*next[1]};
            return output;
        }

        //finds the least positive integer equivalent to a mod m
        public static int leastPosEquiv(int a, int m)
        {
            if(m < 0)
                return leastPosEquiv(a, -1*m);
            if(a >= 0 && a < m)
                return a;

            if(a < 0)
                return -1*leastPosEquiv(-1*a, m) + m;

            int q = a/m;

            return a - q*m;
        }


        public static int solve(int [] constraints, int [] mods)
        {

            //M is the product of the mods
            int M = 1;
            for(int i = 0; i < mods.length; i++)
                M *= mods[i];

            int[] multInv = new int[constraints.length];

            for(int i = 0; i < multInv.length; i++)
                multInv[i] = euclidean(M/mods[i], mods[i])[0];

            int x = 0;

            for(int i = 0; i < mods.length; i++)
                x += (M/mods[i])*constraints[i]*multInv[i];

            x = leastPosEquiv(x, M);

            return x;

        }

    }
}
