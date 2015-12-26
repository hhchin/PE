import java.util.*;

public class e336
{
    public static void main (String [] args)
    {
              int [] arr = {2,0,1,3,4,5,6,7,8,9,10};
        //        int [] arr = {3,0,2,1};
        //int [] arr = {0,1,2,3,4,5};
        int count = 0;
        int check = 2011;
        int maxval = 2*9+1;
        //        System.out.println(solve(arr));

SOLVE:
        while(true)
        {
            int [] temp = new int[arr.length];
            System.arraycopy(arr,0,temp,0,arr.length);
            int cur = solve(temp);

            if(cur>maxval)
            {
                count=0;
                maxval = cur;
            }
            else
            {
                if(cur == maxval)
                {
                    count++;
                    System.out.print(count+":");
                    for(int i=0; i<arr.length; i++)
                        System.out.print((char)(arr[i]+'A'));
                    System.out.println();
                    if(count==check)
                        break SOLVE;

                }
            }
            hasNext(arr);
            if(arr==null) break SOLVE;
            //System.out.println(Arrays.toString(arr));
        }

    }

    public static int solve(int [] arr)
    {
        Stack<Integer> stk = new Stack<Integer>();
        int move = 0;
        for(int i=0; i<arr.length-1; i++)
        {
            int pos = i;
            if(arr[pos] == i) continue;
            while(arr[pos] != i)
            {
                stk.push(arr[pos]);
                pos++;
            }

            if(pos<arr.length-1) move++;
            for(int j=arr.length-1; j>=pos; j--)
                stk.push(arr[j]);

            //            System.out.println(i+":"+stk);

            if(stk.size()>0) move++;
            for(int j=i; stk.size()>0; j++)
                arr[j] = stk.pop();

        }
        //if(move>0) move--;
        return move;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int [] hasNext(int[] a) {
        int N = a.length;

        // find rightmost element a[k] that is smaller than element to its right
        int k; 
        for (k = N-2; k >= 0; k--)
            if (a[k] < a[k+1]) break;
        if (k == -1) return null;

        // find rightmost element a[j] that is larger than a[k]
        int j = N-1;
        while (a[k] > a[j])
            j--;
        swap(a, j, k);

        for (int r = N-1, s = k+1; r > s; r--, s++)
            swap(a, r, s);

        return a;
    }


}
