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
       // SizeAllot(size);
        //System.out.println(m+" "+n+" "+p);
     //   sparseMult.arrayinit(A, B);

        m=4;
        n=3;
        p=2;
        int A[][]={{1,2,3},
                    {4,5,6},
                    {6,7,8},
                    {7,8,9}};
        int B[][]={{3,4},{5,6},{0,2}};
        sparseMult.transpose(A, B);
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
class sparseMult
{    
    int [][] A=U4AIE20144.A;
    int [][] B=U4AIE20144.B;

    static int [] column,row,pointer;
    static void arrayinit(int [][] A, int [][] B)
    {
        int i,j;
        
        // initialising all element in tha matrix A as 0
        for(i=0;i<A.length;i++)
        {
            for(j=0;j<A.length;j++)
            {
                A[i][j]=0;
            }
        }

        // initialising all element in tha matrix B as 0
        for(i=0;i<B.length;i++)
        {
            for(j=0;j<B.length;j++)
            {
                B[i][j]=0;
            }
        }        
    }
    static void input()
    {
        String col = U4AIE20144.in.next();
        String [] C= col.split(" ");
        column=new int[C.length];
        for (int i = 0; i < C.length; i++) 
        {
            column[i] = Integer.valueOf(C[i]);
        }

        String poin = U4AIE20144.in.next();
        String [] p = poin.split(" ");
        pointer=new int[p.length];
        for (int i = 0; i < p.length; i++) 
        {
            pointer[i] = Integer.valueOf(p[i]);
        }

        String Row = U4AIE20144.in.next();
        String [] R = Row.split(" ");
        row=new int[R.length];
        for (int i = 0; i < R.length; i++) 
        {
            row[i] = Integer.valueOf(R[i]);
        }

      //  addingelem(column, pointer, row);
    }
  /*  static void addingelem(int [] column, int [] pointer,int [] row)
    {
        for(int i=0;i<column.length;i++)
        {
            for(int j=0;j<pointer.length-1;j++)
            {
                int place=pointer[j+1]-pointer[j];

            }
        }
    }*/
    static void transpose(int [][]A, int [][]B)
    {
        int [][] AT=new int[U4AIE20144.n][U4AIE20144.m];
        for (int i = 0; i < A.length-1; i++)
        {
            for (int j = 0; j < A.length; j++)
            {
                AT[i][j] = A[j][i];
            }
        }
        int [][] BT=new int[U4AIE20144.p][U4AIE20144.n];
        for (int i = 0; i < B.length-1; i++)
        {
            for (int j = 0; j < B.length; j++)
            {
                BT[i][j] = B[j][i];
            }
        }
    }

}