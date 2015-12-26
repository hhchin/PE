import java.util.*;

public class e494
{
    public static int MAXN = 90;
    public static void main (String [] args)
    {
        int LIM = 20;
        long [] move = new long [3];
        move[1] = 1;
        for(int i=1; i<LIM; i++)
        {
            long [] next = new long[3];
            next[0] = move[0];
            next[1] = 2*move[2];
            next[2] = move[1];
            move = next;
            System.out.println(i+":"+Arrays.toString(move));

        }

        System.out.println(move[0]+move[1]+move[2]);
    }
}
