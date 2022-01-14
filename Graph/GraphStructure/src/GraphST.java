import java.util.*;
public class GraphST
{
    static int ver;
    static int [][] mat;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception
    {
        ver=in.nextInt();
        mat=new int [ver][ver];
        ArrayList<Integer> values=new ArrayList<Integer>();
        in.nextLine();
        for(int i=0;i<ver;i++)
        {
            String str = in.nextLine();
            values=StrToArray(str);
            Graph.main(str, values);
        }
        int op=in.nextInt();
        chooseOption(op);
        in.close();
    }
    static void chooseOption(int op)
    {
        switch (op)
        {
            case 1:
            {
                in.nextLine();
                String str = in.nextLine();
                ArrayList<Integer> arr= new ArrayList<Integer>();
                arr=StrToArray(str);
                Graph.degree(arr);
                break;
            }
            case 2:
            {
                in.nextLine();
                String str = in.nextLine();
                ArrayList<Integer> arr= new ArrayList<Integer>();
                arr=StrToArray(str);
                Graph.weight(arr);
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
    static int size =GraphST.ver;
    static int [][] mat=GraphST.mat;
    static void main(String str, ArrayList<Integer> values)
    {
        MatrixDevelop(mat, values);
    }
    static void MatrixDevelop(int[][]mat,ArrayList<Integer> values)
    {
        int row=values.get(0);
        for(int i=2;i<values.size();i++)
        {
            int col=values.get(i);
            i++;
            mat[row-1][col-1]=values.get(i);
        }
    }
    static void uppertriangle()
    {
        for(int i= 0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i<=j)
                {
                    if(mat[i][j] !=0)
                    {
                        System.out.println((i+1)+" "+(j+1)+" "+mat[i][j]);
                    }
                }
            }
        }
    }
    static void cumulativeWeight()
    {
        int weight=0;
        for(int i= 0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i>=j)
                {
                    if(mat[i][j] !=0)
                    {
                        weight+=mat[i][j];
                    }
                }
            }
        }
        System.out.print(weight+" ");
    }
    static void nonzeroelem()
    {
        int nonzero=0;
        for(int i= 0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i>=j)
                {
                    if(mat[i][j] !=0)
                    {
                        nonzero++;
                    }
                }
            }
        }
        System.out.print(nonzero+" ");
    }
    static void weight(ArrayList<Integer> arr)
    {
        for(int i=1;i<=arr.size()-1;i++)
        {
            int r=arr.get(i);
            i++;
            int c=arr.get(i);
            System.out.print(mat[r-1][c-1]+" ");
        }
    }
    static void degree(ArrayList<Integer> arr)
    {
        int degree=0;
        int num=arr.get(0);
        for(int i=1;i<=num;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(mat[j][arr.get(i)-1] !=0)
                {
                    degree++;
                }
            }
            System.out.print(degree+" ");
            degree=0;
        }  
    }
}