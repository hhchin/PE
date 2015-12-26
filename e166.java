import java.util.*;

public class e166
{
    public static void main (String [] args)
    {
        int count = 0;
        int [] num = new int[9];
        do
        {
            int sum = num[0]*2 + num[1] + num[2] + num[3] + num[4]*2 + num[5] + num[6] + num[7] + num[8]*2;
            if (sum % 3 != 0) continue;
            sum /= 3;  // The sum of each line
            int a = sum - num[0] - num[1] - num[2];  if (a < 0 || a > 9) continue;
            int b = sum - num[3] - num[4] - num[5];  if (b < 0 || b > 9) continue;
            int c = sum - num[6] - num[7] - num[8];  if (c < 0 || c > 9) continue;
            int d = sum - num[0] - num[3] - num[6];  if (d < 0 || d > 9) continue;
            int e = sum - num[1] - num[4] - num[7];  if (e < 0 || e > 9) continue;
            int f = sum - num[2] - num[5] - num[8];  if (f < 0 || f > 9) continue;
            int g = sum - d - e - f;  if (g < 0 || g > 9) continue;
            if (a + num[5] + num[7] + d != sum || num[0] + num[4] + num[8] + g != sum) continue;
            count++;

        }while(inc(num));
        System.out.println(count);

    }

    public static boolean inc(int [] num)
    {
        int i=0; 
        while(num[i]==9)
        {
            num[i] =0 ;
            i++;
            if(i==num.length) return false;
        }
        num[i]++;
        return true;
    }
}
