import java.util.*;
public class trial
{
    static int count=0;
    public static void main(String[] args) 
    {
        String str = "abcdef";
        String key = "acbdef";
        swap(key, str);

    }
    static void swap(String key,String str)
    {
        int len=key.length();
        String[] array=new String[len-1];
        String newstring=key;
        StringBuilder string = new StringBuilder(key);
        for(int x=0;x<len-1;x++)
        {
            char temp=key.charAt(x);
            string.setCharAt(x, key.charAt(x+1));
            string.setCharAt(x+1,temp);
            array[x]=string.toString();
            key=newstring;
            StringBuilder string1 = new StringBuilder(key);
            string=string1;
        }	
        List check = Arrays.asList(array);
        System.out.println(check);
        if(check.contains(str))
        {  
            count++;
        }
    }
}
