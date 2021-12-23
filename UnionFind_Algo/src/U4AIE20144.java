import java.util.*;
public class U4AIE20144
{
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> find=new ArrayList<String>();
    static ArrayList<String> Elements=new ArrayList<String>();
    public static void main(String[] args) throws Exception 
    {
        UnionFind.initialise(2000);
        String elem = in.nextLine();
        String bran = in.nextLine();
        ArrayList<String> Branches=new ArrayList<String>();
        Elements=StrToArray(elem);
        Branches=StrToArray(bran);
        pairs(Branches);

        String str=in.nextLine();
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
                        UnionFind.size(find,i);
                    }
                    break;
                }
                case "F":
                {
                    for(int i=0;i<num;i++)
                    {
                        UnionFind.rootnode(find,i);
                    }
                    break;
                }
                case "D":
                {
                    for(int i=0;i<num;i++)
                    {
                        UnionFind.depth(find,i);
                    }
                    break;
                }
                case "S":
                {
                    for(int i=0;i<num;i++)
                    {
                        UnionFind.sibling(find,i);
                    }
                    break;
                }
            }
        }
        else
        {
            UnionFind.disjoint(Elements);
        }
    }
    static void pairs(ArrayList<String> Branches)
    {
        for(int i=1;i<Branches.size();i++)
        {
            int P1=Integer.parseInt(Branches.get(i));
            i++;
            int P2=Integer.parseInt(Branches.get(i));
            UnionFind.union(P1, P2);
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
    static ArrayList<Integer>Parent=new ArrayList<Integer>();
    static ArrayList<Integer> Child=new ArrayList<Integer>();
    static int count;
    static int C,root,FC;

    static void initialise(int num)
    {
        count=num;
        for(int i=0;i<num;i++)
        {
            Parent.add(i);
            Child.add(1);
        }
    }
    static void union(int P1, int P2)
    {
        int root_P1=find(P1);
        int root_P2=find(P2);
        int c1 = Child.get(root_P1);
        int c2 = Child.get(root_P2);
        if(root_P1==root_P2)
        {
            return;
        }
        if(c1<c2)
        {
            Parent.set(root_P1, root_P2);
            c2 += c1;
        }
        else if(c1==c2)
        {
            if(root_P1>root_P2)
            {
                Parent.set(root_P2, root_P1);
                c1+=c2;
            }
            else
            {
                Parent.set(root_P1, root_P2);
                c2 += c1;
            }
        }
        else
        {
            Parent.set(root_P2, root_P1);
            c1+=c2;
        }
    }
    static int find(int elem)//return root of the element
    {
        FC=0;
        while(elem != Parent.get(elem))
        {
            FC++;
            elem=Parent.get(elem);
        }
        return elem;
    }
    static void disjoint(ArrayList<String>Elements)
    {
        C=0;
        int i=1;
        while(i<=Integer.parseInt(Elements.get(0)))
        {
            if(find(Integer.parseInt(Elements.get(i)))==Integer.parseInt(Elements.get(i)))
            {
                C++;
            }
            i++;
        }
        System.out.print(C);
    }
    static void size(ArrayList<String>find,int i)
    {
        int j=1;
        C=0;
        while(j<=Integer.parseInt(U4AIE20144.Elements.get(0)))
        {
            if(find(Integer.parseInt(U4AIE20144.Elements.get(j)))==find(Integer.parseInt(find.get(i+2))))
            {
                C++;
            }
            j++;
        }
        System.out.print(C+" ");
    }
    static void rootnode(ArrayList<String>find,int i)
    {
        System.out.print(find(Integer.parseInt(find.get(i+2)))+" ");
    }
    static void depth(ArrayList<String>find,int i)
    {
        find(Integer.parseInt(find.get(i+2)));
        System.out.print(FC+" ");
    }
    static void sibling(ArrayList<String>find,int i)
    {
        C=0;
        int j=1;
        int rootG=find(Integer.parseInt(find.get(i+2)));
        int countG=FC;
        while(j<=Integer.parseInt(U4AIE20144.Elements.get(0)))
        {
            int rootN=find(Integer.parseInt(U4AIE20144.Elements.get(j)));
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
