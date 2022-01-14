import java.util.*;
public class Union
{
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> find=new ArrayList<String>();
    static ArrayList<String> Elements=new ArrayList<String>();
    static UnionFind obj = new UnionFind(2000);
    public static void main(String[] args) throws Exception 
    {

        String elem = in.nextLine();
        String bran = in.nextLine();
        ArrayList<String> Branches=new ArrayList<String>();
        Elements=StrToArray(elem);
        Branches=StrToArray(bran);
        pairs(Branches);

        String str=in.nextLine();
        choice(str);
    }
    static void choice(String str)
    {
        if(str.length()>1)
        {
            find = StrToArray(str);
            String let= find.get(0);
            int num = Integer.parseInt(find.get(1));

            switch(let)
            {
                case "Z":
                {
                    for(int i=0;i<num;i++)
                    {
                        obj.size(find,i);
                    }
                    break;
                }
                case "F":
                {
                    for(int i=0;i<num;i++)
                    {
                        obj.rootnode(find,i);
                    }
                    break;
                }
                case "D":
                {
                    for(int i=0;i<num;i++)
                    {
                        obj.depth(find,i);
                    }
                    break;
                }
                case "S":
                {
                    for(int i=0;i<num;i++)
                    {
                        obj.sibling(find,i);
                    }
                    break;
                }
            }
        }
        else
        {
            obj.disjoint(Elements);
        }
    }
    static void pairs(ArrayList<String> Branches)
    {
        for(int i=1;i<Branches.size();i++)
        {
            int P1=Integer.parseInt(Branches.get(i));
            i++;
            int P2=Integer.parseInt(Branches.get(i));
            obj.union(P1, P2);
        }
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
class UnionFind
{
    static int []Parent;
    static int [] Child;
    static int count;
    static int C,root,FC;

    public UnionFind(int num)
    {
        count=num;
        Parent = new int[num];
        Child = new int[num];
        for(int i=0;i<num;i++)
        {
            Parent[i]=i;
            Child[i]=1;
        }
    }
    void union(int P1, int P2)
    {
        int root_P1=find(P1);
        int root_P2=find(P2);
        if(root_P1==root_P2)
        {
            return;
        }
        if( Child[root_P1]<Child[root_P2])
        {
            Parent[root_P1]=root_P2;
            Child[root_P2] +=  Child[root_P1];
        }
        else if( Child[root_P1]==Child[root_P2])
        {
            if(root_P1>root_P2)
            {
                Parent[root_P2]= root_P1;
                 Child[root_P1]+=Child[root_P2];
            }
            else
            {
                Parent[root_P1]=root_P2;
                Child[root_P2] +=  Child[root_P1];
            }
        }
        else
        {
            Parent[root_P2]= root_P1;
             Child[root_P1]+=Child[root_P2];
        }
    }
    int find(int elem)//return root of the element
    {
        FC=0;
        while(elem != Parent[elem])
        {
            FC++;
            elem=Parent[elem];
        }
        return elem;
    }
    void disjoint(ArrayList<String>Elements)
    {
        C=0;
        int i=1;
        while(i<=Integer.parseInt(Elements.get(0)))
        {
        //    System.out.println("Element: "+Elements.get(i));
        //    System.out.println("root: "+find(Integer.parseInt(Elements.get(i)))+"\n");
            if(find(Integer.parseInt(Elements.get(i)))==Integer.parseInt(Elements.get(i)))
            {
                C++;
            }
            i++;
        }
        System.out.print(C);
    }
    void size(ArrayList<String>find,int i)
    {
        int j=1;
        C=0;
        while(j<=Integer.parseInt(Union.Elements.get(0)))
        {
            if(find(Integer.parseInt(Union.Elements.get(j)))==find(Integer.parseInt(find.get(i+2))))
            {
                C++;
            }
            j++;
        }
        System.out.print(C+" ");
    }
    void rootnode(ArrayList<String>find,int i)
    {
        System.out.print(find(Integer.parseInt(find.get(i+2)))+" ");
    }
    void depth(ArrayList<String>find,int i)
    {
        find(Integer.parseInt(find.get(i+2)));
        System.out.print(FC+" ");
    }
    void sibling(ArrayList<String>find,int i)
    {
        C=0;
        int j=1;
        int rootG=find(Integer.parseInt(find.get(i+2)));
        int countG=FC;
        while(j<=Integer.parseInt(Union.Elements.get(0)))
        {
            int rootN=find(Integer.parseInt(Union.Elements.get(j)));
            int countN=FC;
            if(rootG==rootN && countG==countN)
            {
                C++;
            }
            j++;
        }
        System.out.print(C-1+" ");
    }
}
