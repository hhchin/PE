

public class e449
{
    public static void main (String [] args)
    {
        double a = 3;
        double b = 1;
        double half_vol = 0.0;
        double x1 = a+1;
        double y1 = 0;
        int part = 2000000;
        double delta_t = Math.PI/(2*(part+0.0));
        double t=0;
        for(int i=0; i<part; i++)
        {
            t+=delta_t;
            double [] nv = norm_vec(a, b, t);
            half_vol += Math.PI/3.0*(Math.pow(nv[0]+x1,2)-nv[0]*x1)*(nv[1]-y1);
            x1 = nv[0];
            y1 = nv[1];
        }

        double soln = 2*half_vol - ellipse_vol(a,b);
        System.out.printf("%1.9f\n", soln);
    }

    private static double ellipse_vol(double a, double b)
    {
        return 4*Math.PI/3*Math.pow(a,2)*b;
    }
    private static double [] norm_vec(double a, double b, double t)
    {
        double [] vec = new double[2];
        double x0 = a*Math.cos(t);
        double y0 = b*Math.sin(t);
        double c = 1.0/Math.sqrt(Math.pow(x0,2)/Math.pow(a,4) + Math.pow(y0,2)/Math.pow(b,4));
        vec[0] = x0 + c*x0 /Math.pow(a,2);
        vec[1] = y0 + c*y0 /Math.pow(b,2);
        return vec;
    }
}
