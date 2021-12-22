import java.util.*;
public class U4AIE20144
{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception 
    {
        String elem = in.nextLine();
        String bran = in.nextLine();
        ArrayList<Integer> Elements=new ArrayList<Integer>();
        ArrayList<Integer> Branches=new ArrayList<Integer>();
        Elements=StrToArray(elem);
        Branches=StrToArray(bran);
        pairs(Branches);

    }
    static void pairs(ArrayList<Integer> Branches)
    {
        for(int i=0;i<Branches.size();i++)
        {
            int P1=Branches.get(i);
            i++;
            int P2=Branches.get(i);
            UnionFind.union(P1, P2);
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
class UnionFind
{
    static ArrayList<Integer> Tree=new ArrayList<Integer>();
    static void union(int a, int b)
    {
        // find the root of the sets in which elements `x` and `y` belongs
        int x = find(a);
        int y = find(b);
         
        if(x>=y)
        {
            int temp =x;
            x=y;
            y=temp;
        }
        parent[x]=y;
        
    }
}
