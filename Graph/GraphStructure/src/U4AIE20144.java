import java.util.*;
public class U4AIE20144
{
    static int ver;
    static int [][] graph;
    static int [][] mat;

    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        ver=in.nextInt();
        mat=new int [ver][ver];
        mat=arrayinit(mat, ver, ver);
        ArrayList<Integer> values=new ArrayList<Integer>();
        in.nextLine();
        for(int i=0;i<ver;i++)
        {
            String str = in.nextLine();
            values=StrToArray(str);
            Graph.main(str, values);
            int op=in.nextInt();
            chooseOption(op);

        }
        in.close();
    }
    static void chooseOption(int op)
    {
        switch (op)
        {
            case 1:
            {
                Graph.degree();
                break;
            }
            case 2:
            {
                Graph.weight();
                break;
            }
            case 3:
            {
                Graph.nonzeroelem();
                break;
            }
            case 4:
            {
                Graph.cumulativeWeight();
                break;
            }
            case 5:
            {
                Graph.uppertriangle();
                break;
            }
        }

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
    static ArrayList<Integer> StrToArray(String str)
    {
        String temp[]=str.split(" ");
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i =0;i<temp.length;i++)
        {
            arr.add(Integer.valueOf(temp[i]));
        }
        return arr;
    }
}
class Graph
{
    static int [][] mat=U4AIE20144.mat;
    static void main(String str, ArrayList<Integer> values)
    {
        MatrixDevelop(mat, values);
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[i].length; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }
    static void MatrixDevelop(int[][]mat,ArrayList<Integer> values)
    {
        int row=values.get(0);
        int Noelem=values.get(1);

        for(int i=2;i<=Noelem+3;i++)
        {
            int col=values.get(i);
            i++;
            mat[row-1][col-1]=values.get(i);
        }
    }
    static void uppertriangle()
    {

    }
    static void cumulativeWeight()
    {

    }
    static void nonzeroelem()
    {

    }
    static void weight()
    {

    }
    static void degree()
    {

    }

}
