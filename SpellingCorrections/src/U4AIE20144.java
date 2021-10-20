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
            if(string[0].startsWith("a"))
            {
                for(int j=2;j<len;j++)
                {
                    SpellingCorrection.insert(string[j]);
                }
            }
            if(string[0].startsWith("d"))
            {
                for(int j=2;j<len;j++)
                {
                    SpellingCorrection.delete(string[j]);
                }
            }
            if(string[0].startsWith("f"))
            {
                for(int j=2;j<len;j++)
                {
                    SpellingCorrection.find(string[j]);
                }
            }
        }
        in.close();
    }
    
}
class SpellingCorrection
{
    static void insert(String string)
    {

    }
    static void delete(String string)
    {

    }
    static void find(String string)
    {

    }
}
