import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.*;

final class e516 {
    private static BigInteger TWO = BigInteger.valueOf(2);
    private static BigInteger THREE = BigInteger.valueOf(3);
    private static BigInteger FIVE = BigInteger.valueOf(5);
    private static BigInteger LIM = (BigInteger.valueOf(10)).pow(12);
    private static BigInteger BASE = TWO.pow(32);
    private static BigInteger soln= BigInteger.ZERO;

    private static BigInteger [] arr_soln = new BigInteger[3000000];
    private static ArrayList<BigInteger> arr_temp = new ArrayList<BigInteger>();

    private static void updateFrontier(BigInteger x,
            PriorityQueue<BigInteger> pq) {
        pq.offer(x.shiftLeft(1));
        pq.offer(x.multiply(THREE));
        pq.offer(x.multiply(FIVE));
    }

    public static BigInteger hamming(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Invalid parameter");
        PriorityQueue<BigInteger> frontier = new PriorityQueue<BigInteger>();
        updateFrontier(BigInteger.ONE, frontier);
        BigInteger lowest = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            lowest = frontier.poll();
            while (frontier.peek().equals(lowest))
                frontier.poll();
            updateFrontier(lowest, frontier);
        }
        return lowest;
    }

    public static void main(String[] args) {

        int ind=1;
        BigInteger cur = hamming(ind);
        while(cur.compareTo(LIM) < 0)
        {
            BigInteger testp = cur.add(BigInteger.ONE);
            if(testp.isProbablePrime(15))
                arr_temp.add(testp);
            ind++;
            cur = hamming(ind);
        }
        Collections.sort(arr_temp);
        System.out.println("finished hamming ");
        
        int soln_ind = 0;
        for(int a=0; a<40; a++)
        for(int b=0; b<26; b++)
        for(int c=0; c<18; c++)
        {
            BigInteger pow1 = TWO.pow(a);
            BigInteger pow2 = THREE.pow(b);
            BigInteger pow3 = FIVE.pow(c);
            BigInteger powc = (pow1.multiply(pow2)).multiply(pow3);
            if(powc.compareTo(LIM)<=0)
            {
                soln = soln.add(powc).mod(BASE);
                arr_soln[soln_ind] = powc;
                soln_ind++;
            }
        }
        Arrays.sort(arr_soln,0,soln_ind);

  /*      for(int i=0; i<20; i++)
            System.out.println(arr_soln[i]);*/

        for(int i=3; i<arr_temp.size(); i++)
        {
            BigInteger I = arr_temp.get(i);
            ArrayList<BigInteger> temp = new ArrayList<BigInteger>();
            BigInteger [] arr_new = new BigInteger[3000000];
            for(int j=0; j<soln_ind; j++)
            {
                BigInteger curI = arr_soln[j].multiply(I);
                if(curI.compareTo(LIM) <= 0)
                {
                    soln = soln.add(curI).mod(BASE);
                    temp.add(curI);
                }
                else
                {
                    System.out.printf("%d %d,%d,%d\n",i ,temp.size(), soln_ind, arr_soln[0]);
                    int end_ind = Math.min(j, arr_new.length-temp.size());
                    for(int k=0; k<end_ind; k++)
                        arr_new[k] = arr_soln[k];
                    for(int k=0; k<temp.size(); k++)
                        arr_new[k+end_ind] = temp.get(k);
                    Arrays.sort(arr_new,0,end_ind+temp.size());
                    arr_soln = arr_new;
                    soln_ind = end_ind+temp.size();
                    break;
                }
            }
            

            
        }

        System.out.println(soln);
    }



}
