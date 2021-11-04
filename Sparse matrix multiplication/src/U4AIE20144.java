import java.util.*;
public class U4AIE20144
 {
    static Scanner in = new Scanner(System.in);
    static int m,n,p;
    static int [] size;
    static int [][] A;
    static int [][] B;
    public static void main(String[] args) throws Exception 
    {
        SizeAllot(size);
        System.out.println(m+" "+n+" "+p);

    }
    static void SizeAllot(int [] size)
    {
        size = new int [3]; 
        for(int i=0;i<size.length;i++)
        {
            size[i]=in.nextInt();
        }
        m=size[0];
        n=size[1];
        p=size[2];

        //alloting size of array to form matrix A and B
        A=new int[m][n];
        B=new int[n][p];
    }
}
