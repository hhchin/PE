import java.util.*;

public class e506
{
    public static void main (String [] args)
    {
        int [] arr = {1,2,3,4,3,2};
        int an = 0;
        for(int i=1; i<=30; i++)
        {
            int acc = 0;
            while(acc<i)
            {
                System.out.print(arr[an]);
                acc+=arr[an];
                an = (an+1)%arr.length;
            }
            System.out.println();
        }
    }
}
