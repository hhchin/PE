import java.util.*;
import java.math.*;

public class e181
{
    public static void main (String[] args)
    {
        int n = 1;
        int m = 3;
        BigInteger[][] ways = new BigInteger[n + 1][m + 1];
        for (int i = 0; i <= n; ++ i) {
            for (int j = 0; j <= m; ++ j) {
                ways[i][j] = BigInteger.ZERO;
            }
        }
        ways[0][0] = BigInteger.ONE;
        for (int a = 0; a <= n; ++ a) {
            for (int b = 0; b <= m; ++ b) {
                if (a + b > 0) {
                    for (int i = 0; i + a <= n; ++ i) {
                        for (int j = 0; j + b <= m; ++ j) {
                            ways[i + a][j + b] = ways[i + a][j + b].add(ways[i][j]);

                            System.out.println(a+":"+b+">"+i+":"+j);
                            for(int r = 0; r<ways.length; r++)
                                System.out.println(Arrays.toString(ways[r]));
                        }
                    }
                }
            }
        }
        System.out.println(ways[n][m]);
    }
}
