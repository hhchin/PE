import java.util.*;

public class Euler
{
    public static ArrayList<Integer> genPrime(int n)
    {
        boolean [] arr = new boolean [n+1];
        ArrayList<Integer> prime = new ArrayList<Integer>();
        Arrays.fill(arr, true);
        for(int i=2; i<arr.length; i++)
        {
            if(arr[i])
            {
                prime.add(i);
                for(int j=2; i*j<arr.length; j++)
                    arr[i*j] = false;
            }
        }
        return prime;
    }
}
