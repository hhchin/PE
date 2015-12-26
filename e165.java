import java.util.*;
import java.awt.geom.*;

public class e165
{

    public static long [] blum = new long[20001];
    public static ArrayList<Line2D> L = new ArrayList<Line2D>();
    public static double eps = 1e-6;
    public static void main (String [] args)
    {
        blum[0] = 290797;
        for(int i=1; i<blum.length; i++)
            blum[i] = (blum[i-1]*blum[i-1]) % 50515093;
        for(int i=1; i<blum.length; i++)
            blum[i] = blum[i]%500;

        for(int i=1; i<blum.length; i+=4)
            L.add(new Line2D.Double(blum[i],blum[i+1], blum[i+2], blum[i+3]));

        HashMap<Double,HashSet<Double>> soln = new HashMap<Double, HashSet<Double>>();
        for(int i=0; i<L.size(); i++)
            for(int j=i+1; j<L.size(); j++)
            {
                Point2D p = intersect(L.get(i), L.get(j));
                if(p != null)
                {
                    HashSet<Double> temp = null;
                    double x = p.getX();
                    double y = p.getY();
                    if(soln.containsKey(x)) temp = soln.get(x);
                    else temp = new HashSet<Double>();
                    temp.add(y);
                    soln.put(x, temp);
                }
            }
        
        int tot = 0;
        Set<Double> ks = soln.keySet();
        for(Double d: ks)
            tot+= soln.get(d).size();
        System.out.println(tot);

    }

    public static Point2D intersect(Line2D L1, Line2D L2)
    {
        double x1 = L1.getX1();
        double y1 = L1.getY1();
        double x2 = L1.getX2();
        double y2 = L1.getY2();
        double x3 = L2.getX1();
        double y3 = L2.getY1();
        double x4 = L2.getX2();
        double y4 = L2.getY2();

        if( (y2-y1)/(x2-x1) - (y4-y3)/(x4-x3) <eps) return null;
        double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
        if (Math.abs(d - 0)<eps) return null;

        double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
        double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;

        if( Math.abs(xi-x1) < eps && Math.abs(yi-y1)<eps) return null;
        if( Math.abs(xi-x2) < eps && Math.abs(yi-y2)<eps) return null;
        if( Math.abs(xi-x3) < eps && Math.abs(yi-y3)<eps) return null;
        if( Math.abs(xi-x4) < eps && Math.abs(yi-y4)<eps) return null;
        xi = round(xi, 1);
        yi = round(yi,1);
        return  new Point2D.Double(xi,yi);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
