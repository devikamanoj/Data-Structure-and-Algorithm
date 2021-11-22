import java.util.*;
public class U4AIE20144
{
    static Scanner in = new Scanner(System.in);
    static int m,n,p;
    static int [] size;
    static int [][] A,B,M;
    public static void main(String[] args) throws Exception 
    {
        SizeAllot(size);
        sparseMult.manipulation(A, B);
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
    static int [] column,row,pointer,Num,res;
    static int [][] A=U4AIE20144.A; static int [][] B=U4AIE20144.B;
    static int m=U4AIE20144.m; static int n=U4AIE20144.n; static int p=U4AIE20144.p;
    static int [][] matrix,AT,BT;
    static int x=0;

    static void manipulation(int [][] A,int[][] B)
    {
        U4AIE20144.in.nextLine();
        A=arrayinit(A,m,n);
        B=arrayinit(B,n,p);
        input();
        A=addingelem(column, pointer, row, Num,A);
        input();
        B=addingelem(column, pointer, row, Num, B);
        AT=transpose(A,m,n);
        BT=transpose(B,n,p);
        matrix=Multiplication(BT, AT);
        
        Rankmatrix(A,B);
        System.out.println(getnonZero(matrix)+" "+getsum(matrix));
    
    }

    static int[][] arrayinit(int [][]mat, int r, int c)
    {
        // initialising all element in tha matrix A as 0
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                mat[i][j]=0;
            }
        }
        return mat;
    }
    static void input()
    {

        String col = U4AIE20144.in.nextLine();
        String C[]= col.split(" ");
        column=new int[C.length];
        for (int i = 0; i < C.length; i++) 
        {
            column[i] = Integer.valueOf(C[i]);
        }

        String poin = U4AIE20144.in.nextLine();
        String [] p = poin.split(" ");
        pointer=new int[p.length];
        for (int i = 0; i < p.length; i++) 
        {
            pointer[i] = Integer.valueOf(p[i]);
        }

        String Row = U4AIE20144.in.nextLine();
        String [] R = Row.split(" ");
        row=new int[R.length];
        for (int i = 0; i < R.length; i++) 
        {
            row[i] = Integer.valueOf(R[i]);
        }

        String num = U4AIE20144.in.nextLine();
        String [] N = num.split(" ");
        Num=new int[N.length];
        for (int i = 0; i < N.length; i++) 
        {
            Num[i] = Integer.parseInt(N[i]);
        }
    }
    static int[][] addingelem(int [] column, int [] pointer,int [] row, int[]Num, int[][]mat)
    {
        int x,j=0,k=0;
        for(int i=0;i<column.length;i++)
        {
            if(j<row.length)
            {
                if(k<pointer.length-1)
                {
                    x=pointer[k+1]-pointer[k];
                    for(int l=0;l<x;l++)
                    {
                        mat[row[j]-1][column[i]-1]=Num[j];
                        j++;
                    }
                    k++;
                }
            }
        }
        return mat;
    }
    static int[][] transpose(int [][]M, int r,int c)
    {
        int [][] MT=new int[c][r];
        for (int i=0; i<c; i++)
        {
            for (int j=0; j<r; j++)
            {
                MT[i][j] = M[j][i];
            }
        }
        return MT;
    }
    static int[][] Multiplication(int [][]BT, int[][]AT)
    {
        matrix = new int[p][m];
        for(int i=0; i<p; i++) 
        {    
            for(int j=0; j<m; j++)
            {       
                for(int k=0; k<n; k++)
                {
                    matrix[i][j] += BT[i][k] * AT[k][j];    
                }
            }
        }
        return matrix;
    }
    static int getsum(int[][] matrix)
    {
        int sum=0;
        for (int i=0; i<p; i++) 
        {
            for (int j=0; j<m; j++)
            {
                sum+=matrix[i][j];
            }
        }
        return sum;
    }
    static int getnonZero(int [][]matrix)
    {
        int count=0;
        for (int i=0; i<p; i++) 
        {
            for (int j=0; j<m; j++)
            {
                if(matrix[i][j]!=0)
                {
                    count++;
                }
            }
        }
        return count;
    }
    static void Rankmatrix(int [][]AT,int [][]BT)
    {
        int [][] matrix1=new int[p][m];
        x=0;
        ArrayList<Integer>res=new ArrayList<Integer>();
        while(x<n)
		{
			arrayinit(matrix1, p, m);
            rankmult(AT, BT, matrix1);
			int y=0;
		    for ( int k = 0; k <p; k++) 
			{
			    for (int  l = 0; l <m; l++) 
			    {
			    	if(matrix1[k][l]!=0)
			    	{
			    		y++;

			    	}
			    }
			}
            if(y!=0)
            {
                res.add(y);
            }
		    x++;
		}
        System.out.print(res.size()+" ");
        for(int i=0;i<res.size();i++)
        {
            System.out.print(res.get(i)+" ");
        }
    }
    static void rankmult(int [][]AT,int [][]B, int [][]matrix1)
    {
        for (int i = 0; i < p; i++) 
        {
            for (int j = 0; j < m; j++) 
            {
                for (int k = 0; k < n; k++)
                {
                    matrix1[i][j] = B[x][j]*AT[i][x] ;
                }

            }
        }
    }
}