import java.util.*;
public class trial 
{
    static int count=0;
    public static void main(String[] args) 
    {
        String str = "abcdefg";
        replacealphabet(str);
    }
    static void replacealphabet(String str)
    {
        char c;
        String newstr,x,y;

       for(int i=0;i<str.length();i++)
        {
            x=str.substring(0, i);
            y=str.substring(i,str.length());

            for(c = 'a'; c <= 'z'; ++c)
            {
                newstr=x+c+y;
              //  System.out.println(newstr);

            }
        }
        x=str.substring(0, str.length()-1);
        y=str.substring(str.length()-1, str.length());
        for(c = 'a'; c <= 'z'; ++c)
        {
            newstr=x+c+y;
        }
        for(c = 'a'; c <= 'z'; ++c)
        {
            newstr=str+c;
            newstr=newstr.toLowerCase();
          //  System.out.println(newstr);
        }
       // System.out.print(count+" ");

    }
    static String listtoString(ArrayList<String>strList)
    {
        String list = Arrays.toString(strList.toArray()).replace("[", "").replace("]", ""); 
        list = list.replaceAll(", ", "");
        return list;
    }
    
}

