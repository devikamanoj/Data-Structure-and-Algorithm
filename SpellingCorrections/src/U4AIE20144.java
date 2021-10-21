import java.util.*;
public class U4AIE20144 
{
    static String str;
    static ArrayList<String> newstr ;
    static int len;
    static String[] string;
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int n=3;
        for(int i=0;i<n;i++)
        {
            str=in.nextLine();
            str=str.toLowerCase(); 
            string = str.split(" ");
            String ts=string[1];
            len=Integer.parseInt(ts);

            ArrayListInsert();
            if(string[0].startsWith("a"))
            {

                for(int j=0;j<len;j++)
                {
                    SpellingCorrection.insert(newstr.get(j),j);
                }
            }
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
        in.close();
    }
    static void ArrayListInsert()
    {
        newstr = new ArrayList<String>(len+2);
        for(int j=2;j<len+2;j++)
        {
            newstr.add(string[j]);
        }
    }
}
class SpellingCorrection
{
    static Hashtable<String,Integer> HT = new Hashtable<String,Integer>();
    static int count=0;
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
        if(HT.containsKey(string))
        {
            System.out.print("Y"+" ");
        }
        else
        {
            CheckElements(string);
            insertSpace(string);
            replacealphabet(string);
            System.out.print(count+" ");
            count=0;
        }
    }
    static void CheckElements(String str)
    {
        String x,y;
        for(int j=0;j<str.length();j++)
        {
            x=str.substring(0,j);
            y=str.substring(j+1);
            if(HT.containsKey(x+y))
            {
                count++;
            }
            if(j<str.length()-1 &&HT.containsKey(x+str.charAt(j+1)+str.charAt(j)+str.substring(j+2)))
            {
                count++;
            }
        }
    }
    static void replacealphabet(String str)
    {
        char c;
        for(int j=0;j<str.length();j++)
        {
            for(c = 'a'; c <= 'z'; ++c)
            {
                if(SpellingCorrection.HT.containsKey(str.substring(0,j)+c+str.substring(j)))
                {
                    count++;
                }
                if(SpellingCorrection.HT.containsKey(str.substring(0,j)+c+str.substring(j+1)))
                {
                    count++;
                }
            }
        }
        for(c = 'a'; c <= 'z'; ++c)
        {
            if(SpellingCorrection.HT.containsKey(str+c))
            {
                count++;
            }
        }
    }
    static void insertSpace(String str)
    {
        String x,y;
        for(int i=1;i<str.length();i++)
        {
            x=str.substring(0, i);
            y=str.substring(i, str.length());
            if(HT.containsKey(x) && HT.containsKey(y))
            {
                count++;
            }
        }
    }
}