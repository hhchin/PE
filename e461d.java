import java.util.*;

public class e461d
{

    //public static double lim = 116.0;
    public static double lim = 5796.0;
    public static double N= 10000;
    public static int MAXLEN = 14211;
    public static int MAXA = 5796;
    public static int MAXB = 7164;
    public static int MAXC = 9441;
    public static int MAXD = 14211;

    public static double G =0;
    public static double [] arr = new double [MAXLEN+1];
    public static double [] da, tempda;


    public static double diff = Double.POSITIVE_INFINITY;

    public static int bestD, bestC, bestA, bestB;
    public static double bestRes,d,c;


    public static double eps = 1e-16;
    public static void main (String [] args)
    {
        for(int i=0; i<arr.length; i++)
            arr[i] = eval((double)i);

        for(int a=4000; a>3000; a--)
            for(int b=a; b<=MAXB; b++)
                for(int c=b; c<=MAXC; c++)
                {
                    double res = (Math.PI+4 - arr[a] -arr[b] -arr[c]);
                    int pos = Arrays.binarySearch(arr, res);
                    int index = -1 - pos;

                    for(int z=Math.max(0, index-1); z<Math.min(index+2, arr.length); z++)
                    {
                        double val = Math.abs(res-arr[z]);
                        if(val<diff)
                        {
                            diff = val;
                            bestD = z;
                            bestC = c;
                            bestB = b;
                            bestA = a;
                            System.out.printf("%d %d %d %d res->%f \n", bestA, bestB, bestC, bestD, diff);
                        }
                    }

                }
        System.out.printf("%d %d %d %d\n", bestA, bestB, bestC, bestD);
        /* 
           tempda = new double[(MAXA+1)*(MAXB+1)];
           int cnt=0;
           for(int i=1; i<=MAXA; i++)
           for(int j=i; j<=MAXB; j++)
           {
           tempda[cnt] = (arr[i]*arr[j]);
           cnt++;
           }
           da = new double[cnt];
           for(int i=0; i<cnt; i++)
           da[i] = tempda[i];
           System.out.println(cnt);
           Arrays.sort(da);

           for(int i=MAXA; i<arr.length; i++)
           {
           d = arr[i];
           for(int j=0; j<=MAXC; j++)
           {   
           c = arr[j];
           double res = Math.PI+4-d-c;
           int pos = Arrays.binarySearch(da,res);
           int index = pos;
           if(pos<0) index = -1 - pos;


           for(int z=Math.max(0, index-1); z<Math.min(index+2, da.length); z++)
           {
           double val = Math.abs(res-da[z]);
           if(val<diff)
           {
           diff = val;
           bestD = i;
           bestC = j;
           bestRes = da[z];
        //   System.out.printf("%d %d %f res-> %f\n",i,j,bestRes, val);
        }
        }

        }
        }

        System.out.println("found soln"); 
        System.out.printf("%d %d %f \n",bestC,bestD,bestRes);
        diff = Double.POSITIVE_INFINITY;


        int pbestD = bestD;
        int pbestC = bestC;

        int ball = 0;

        for(int i=1; i<=MAXA; i++)
        for(int j=i; j<=MAXB; j++)
        {
        //double res = Math.abs(Math.PI-(F(i) + F(j) + F(bestC) + F(bestD)));
        double res = Math.abs(Math.PI+4-(eval(i) + eval(j) + eval(bestC) + eval(bestD)));
        if( res <= diff)
        {
        diff = res;
        bestA = i;
        bestB = j;
        }
        }

        System.out.printf("%d %d %d %d\n", bestA, bestB, bestC, bestD);
         */
        /*
           double diff = Double.POSITIVE_INFINITY;
           int ball = 400;

           int [] vector = {387, 3349, 908, 6534};

           for(int i=0; i<arr.length; i++)
           if(check(vector[0],vector[1],vector[2], i)) vector[3] = i;
           for(int i=0; i<arr.length; i++)
           if(check(vector[0],vector[1],i, vector[3])) vector[2] = i;
           for(int i=0; i<arr.length; i++)
           if(check(vector[0],i,vector[2], vector[3])) vector[1] = i;
           for(int i=0; i<arr.length; i++)
           if(check(i,vector[1],vector[2], vector[3])) vector[0] = i;

         */
    }

    public static boolean check(int a, int b, int c,int d)
    {
        double val = arr[a]*(1+arr[b]*(1+arr[c]*(1+arr[d])));
        double res = (Math.abs(val-4.0-Math.PI));
        boolean better = false;
        if(res <diff)
        {
            better = true;
            diff = res;
            System.out.printf("%d %d %d %d -> res: %f\n",a,b,c,d,res);
        }
        return better;

    }

    public static double F(double val)
    {
        return Math.exp(val/N)-1;
    }


    public static double getG(double a, double b, double c, double d)
    {
        return a*a+b*b+c*c+d*d;
    }
    public static double eval(double val)
    {
        return Math.exp(val/N);
    }
}
