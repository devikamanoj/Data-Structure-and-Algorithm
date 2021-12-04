import java.util.*;
public class U4AIE20144
{
    static int ver;
    static int [][] graph;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception 
    {
        ver=in.nextInt();
        graph=new int [ver][ver];
        ArrayList<String> values=new ArrayList<String>();
        in.nextLine();
        for(int i=0;i<ver;i++)
        {
            String str = in.nextLine();
            values=StrToArray(str);
            Graph.main(values);
        }
        Graph.print(graph);
    }
    static ArrayList<String> StrToArray(String str)
    {
        String temp[]=str.split(" ");
        ArrayList<String> arr=new ArrayList<String>();
        for(int i =0;i<temp.length;i++)
        {
            arr.add(temp[i]);
        }
        return arr;
    }
}
class Graph
{
    static int size =U4AIE20144.ver;
    static int [][] graph=U4AIE20144.graph;
    
    static void main(ArrayList<String>values)
    {
        MatrixDevelop(graph, values);
    }
    static void MatrixDevelop(int[][]graph,ArrayList<String> values)
    {
        int row=getASCII(values.get(0));
        for(int i=2;i<values.size();i++)
        {
            int col=getASCII(values.get(i));
            i++;
            graph[row][col]=Integer.valueOf(values.get(i));
        }
        
    }
    static void print(int[][]mat)
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0; j<size;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int getASCII(String s)
    {
        char a=s.charAt(0);
        int num=a;
        int N=getIndex(num);
        return N;
    }
    static int getIndex(int num)
    {
        int Num=num-65;
        return Num;
    }
}
