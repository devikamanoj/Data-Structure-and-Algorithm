import java.util.*;
public class U4AIE20144 
{
    static String str;
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int n=3;
        //in.nextLine();
        for(int i=0;i<n;i++)
        {
            str=in.nextLine();
            str=str.toLowerCase(); 
            String[] string = str.split(" ");
            String ts=string[1];
            int len=Integer.parseInt(ts);

            ArrayList<String> newstr = new ArrayList<String>(len+2);
            for(int j=2;j<len+2;j++)
            {
                newstr.add(string[j]);
            }
          //  System.out.print(newstr+" ");
            if(string[0].startsWith("a"))
            {

                for(int j=0;j<len;j++)
                {
                    SpellingCorrection.insert(newstr.get(j),j);
                }
            }
            SpellingCorrection.print();
            if(string[0].startsWith("d"))
            {
                for(int j=0;j<len;j++)
                {
                    SpellingCorrection.delete(newstr.get(j));
                }
            }
            if(string[0].startsWith("f"))
            {
                for(int j=0;j<len;j++)
                {
                    SpellingCorrection.find(newstr.get(j));
                }
            }
        }
        SpellingCorrection.print();
        in.close();
    }
}
class SpellingCorrection
{
    static Hashtable<String,Integer> HT = new Hashtable<String,Integer>();

    static void insert(String string,int j)
    {
        HT.put(string,j);
    }
    static void delete(String string)
    {
        HT.remove(string);
    }
    static void find(String string)
    {
        //HT.containsKey(string);
    }
    static void print()
    {
        System.out.println("maps");
        for (Map.Entry<String, Integer> entry : HT.entrySet()) 
        {
            String key = entry.getKey();

            System.out.print(" " + key );

        }
        System.out.println();
    }
}
