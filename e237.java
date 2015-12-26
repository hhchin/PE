import java.util.*;

public class e237
{

    public static String p0="\u250c";
    public static String p1="\u2510";
    public static String p2="\u2514";
    public static String p3="\u2518";
    public static String p4="\u2500";
    public static String p5="\u2502";

    public static long N = (long)1e12;
    public static ArrayList<slice> validSlice= new ArrayList<slice>();
    public static long [][] trans;

    public static void main (String [] args)
    {
       
        genSlice();
        genTrans();
/*
        for(int i=0; i<validSlice.size(); i++)
        {
            System.out.println(i);
            System.out.println(validSlice.get(i));
        }
  */

        for(int i=0; i<trans.length; i++)
        for(int j=0; j<trans.length; j++)
            if(trans[i][j]>0)
            {
                System.out.println("--------");
                System.out.println(validSlice.get(i));  
                System.out.println(validSlice.get(j));  
            }
        


        

    }

    public static void genTrans()
    {
        trans = new long [validSlice.size()][validSlice.size()];
        for(int i=0; i<validSlice.size(); i++)
        for(int j=0; j<validSlice.size(); j++)
        {
            slice s = validSlice.get(i);
            slice t = validSlice.get(j);
            if(s.checkSlice(t))
                trans[i][j] = 1;
        }
    }
    public static void genSlice()
    {
        for(int a=0; a<6; a++)
        for(int b=0; b<6; b++)
        for(int c=0; c<6; c++)
        for(int d=0; d<6; d++)
        {
            int [] P = {a,b,c,d};
            if(checkPiece(P))
            {
                slice S = new slice(P);
                validSlice.add(new slice(P));
            }
        }
    }
    
    public static boolean checkPiece(int [] P)
    {   
        for(int i=0; i<P.length-1; i++)
        {
            switch(P[i])
            {
                case 0: if(P[i+1]==0 || P[i+1]==1 || P[i+1]==4) return false; break;
                case 1: if(P[i+1]==0 || P[i+1]==1 || P[i+1]==4) return false; break;
                case 2: if(P[i+1]==2 || P[i+1]==3 || P[i+1]==5) return false; break;
                case 3: if(P[i+1]==2 || P[i+1]==3 || P[i+1]==5) return false; break;
                case 4: if(P[i+1]==2 || P[i+1]==3 || P[i+1]==5) return false; break;
                case 5: if(P[i+1]==0 || P[i+1]==1 || P[i+1]==4) return false; break;
            }
        }
        int lastP = P[P.length-1];
        if(lastP == 0 || lastP == 1 || lastP==5)
            return false;
        int firstP = P[0];
        if(firstP == 2 || firstP == 3 || firstP == 5)
            return false;
        return true;
    }
    static class slice
    {
        int [] P; 

        public slice (int [] P)
        {
            this.P = P;
        }

        public boolean checkSlice(slice S)
        {
            //check blockage
            for(int i=0; i<P.length; i++)
            {
                switch(P[i])
                {
                    case 0: if(S.P[i]==0 || S.P[i]==2 || S.P[i] == 5) return false; break;
                    case 1: if(S.P[i]==1 || S.P[i]==3 || S.P[i] == 4) return false; break;
                    case 2: if(S.P[i]==0 || S.P[i]==2 || S.P[i] == 5) return false; break;
                    case 3: if(S.P[i]==1 || S.P[i]==3 || S.P[i] == 4) return false; break;
                    case 4: if(S.P[i]==0 || S.P[i]==2 || S.P[i] == 5) return false; break;
                    case 5: if(S.P[i]==1 || S.P[i]==3 || S.P[i] == 4) return false; break;
                }
            }

            //check connectivity
            int conn = 0;
            for(int i=0; i<P.length; i++)
            {
                switch(P[i])
                {
                    case 0: if(S.P[i] == 1 || S.P[i] == 3 || S.P[i]== 4) conn++; break;
                    case 2: if(S.P[i] == 1 || S.P[i] == 3 || S.P[i]== 4) conn++; break;
                    case 4: if(S.P[i] == 1 || S.P[i] == 3 || S.P[i]== 4) conn++; break;
                }
            }
            return conn>1;
        }

        public String toString()
        {
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<P.length; i++)
            {
                switch (P[i])
                {
                    case 0: sb.append(p0); break;
                    case 1: sb.append(p1); break;
                    case 2: sb.append(p2); break;
                    case 3: sb.append(p3); break;
                    case 4: sb.append(p4); break;
                    case 5: sb.append(p5); break;
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}
