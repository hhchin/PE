import java.util.*;

public class e105
{
    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int j = 0;

        while (sc.hasNextLine()) 
        {
            String[] seg = sc.nextLine().split(",");
            int dim = seg.length;
            int[] numbers = new int[dim];
            for(int i = 0; i < dim; i++){
                numbers[i] = Integer.parseInt(seg[i]);
            }

            Arrays.sort(numbers);
            if (rule2(numbers)) {
                int[] s = MakeSubsetSums(numbers);
                if (rule1(s)) {
                    for(int n: numbers)
                    result += n ;
                    j++;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean rule2(int [] a)
    {
        int sum1 = a[0];
        int sum2 = 0;

        for (int i = 0; i < a.length / 2; i++) 
        {
            sum1 += a[i + 1];
            sum2 += a[a.length - i - 1];

            if (sum1 <= sum2)
                return false;
        }
        return true;
    }

    private static boolean rule1(int[] a) 
    {
        for (int i = 0; i < a.length; i++) {
            int k = i;
            while (k != -1) {
                k++;
                if (k >= a.length)
                    break;
                k = scan(a[i], a, k);
                if (k != -1 && ( (i&k)==0))
                    return false;
            }
        }
        return true;
    }

    private static int scan(int n, int [] arr , int ind)
    {
        for(int i=ind; i<arr.length; i++)
            if(arr[i] == n) return i;
        return -1;
    }

    private static int[] MakeSubsetSums(int[] a) {
        int[] b = new int[(int)Math.pow(2, a.length)];
        for (int i = 1; i < b.length; i++) {
            b[i] = MakeSubsetSum(a, i);
        }
        return b;
    }

    private static int MakeSubsetSum(int[] a, int m)
    {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if ((m & 1) == 1) {
                sum += a[i];
            }
            m >>= 1;
        }
        return sum;
    }

}
