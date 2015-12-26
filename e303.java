import java.util.*;
import java.math.BigInteger;

public class e303 {

    static final int MAX = 10000 +1;

    public static void main (String [] args)
    {
        BigInteger soln = BigInteger.valueOf(2);
        for(int i=3; i<=10000; i++)
            soln = soln.add(solve(i));
        System.out.println(soln);
    }

    public static BigInteger solve(int n)
    {
 //       System.out.println("solving-> "+n);
        return find(n).divide(BigInteger.valueOf(n));
    }

    public static BigInteger find(int n)
    {
        boolean [][] start_arr = new boolean[3][n];
        LinkedList<boolean[][]> dp = new LinkedList<boolean[][]>();
        start_arr[0][0] = true; start_arr[1][1] = true; start_arr[2][2] = true;
        dp.push(start_arr);

        LinkedList<Integer> res = new LinkedList<Integer> ();
        res.push(1);
        int entry = 0;

        int counter = 0;
        while(counter>=0)
        {
            counter++;
            int cur_res = (res.peek()*10)%n;
            res.push(cur_res);
            boolean [][] prev = dp.peek();
            boolean [][] arr = new boolean[3][n];
            for(int c=0; c<3; c++)
                for(int i=0; i<n; i++)
                    if(prev[c][i])
                    {
                        for(int c2=0; c2<3; c2++)
                        {
                            int j = ((c2*cur_res)+i)%n;
                            arr[c2][j] = true;
                        }
                    }
            dp.push(arr);
            //scan for terminal
            for(int i=1; i<3; i++)
            {
                if(arr[i][0])
                {
                    entry = i;
                    break;
                }
            }
            if(entry!=0) break;
        }


        LinkedList<Integer> F = new LinkedList<Integer>();

        F.push(entry);
        dp.pop();
 //       System.out.println("debug:"+counter+":"+res.peek()+":"+entry);
        int cur_res = fixmod(-entry*res.pop(),n);
        while(dp.size()>0)
        {

            boolean [][] prev = dp.pop();
            //printArr(prev);
//            System.out.println(cur_res+":"+prev.length+":"+prev[0].length);
            for(int c2=0; c2<3; c2++)
            {
                if(prev[c2][cur_res])
                {
                    entry = c2;
                    break;
                }
            }
            F.push(entry);
            cur_res = fixmod(cur_res-entry*res.pop(), n);
        }
        BigInteger soln = BigInteger.valueOf(F.removeLast());
        while(F.size()>0)
            soln = soln.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(F.removeLast()));

        return soln; 
    }
    static int fixmod(int val, int b)
    {
        while(val<0) val+=b;
        return val%b;
    }
    static void printArr(boolean [][] A)
    {
        for(int r=0; r<A.length; r++)
            for(int c=0; c<A[r].length; c++)
                if(A[r][c]) System.out.printf("(%d, %d)\n",r,c);
    }

}
