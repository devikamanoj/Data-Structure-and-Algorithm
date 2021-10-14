import java.util.*;
import java.util.prefs.Preferences;

public class Trial 
{
    static String text;
    static String pattern;
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int TC = in.nextInt();
        in.nextLine();
        for(int i=0;i<TC ; i++)
        {
            text = in.nextLine();
            pattern = in.nextLine();

            text=text.replace(" ", "");
            pattern=pattern.replace(" ", "");

            text=text.replaceAll("[^a-zA-Z0-9]", "");
	        pattern=pattern.replaceAll("[^a-zA-Z0-9]", "");

            text=text.toLowerCase();
            pattern=pattern.toLowerCase();

            KMP_Search obj = new KMP_Search();
            obj.PatternSearch(pattern, text);
        } 
        in.close();
    }    
}
class kmp
{
    HashMap<String, String> map = new HashMap<>();
    void insertMap(String pattern, String text)
    {
        
        String [] Pattern;
        int P;
        P = pattern.length();
        Pattern = new String[P];
        for (int i = 0; i < P; i++) 
        {
            Pattern[i]=pattern.charAt(i) + " ";
        }
        System.out.println(longestCommonPrefix(Pattern));
    }
    String longestCommonPrefix(String[] strs) 
    {
        if(strs.length==0)
    		return "";
        HashMap <Integer,HashMap<Integer,String>> map = new HashMap();
        HashMap<Integer,String> temp;
        
        int count=0;
        //find length of shortest given string
        int len=Integer.MAX_VALUE;
		//build string prefixes
        for(String str:strs)
        {
        	if(str.length()<len)
            {
        		len=str.length();
            }
        	temp = new HashMap();
        	//find prefix array
        	for(int i=1;i<=str.length();i++)
            {
        		temp.put(i-1, str.substring(0, i));
        	}
        	
        	map.put(count , temp);
        	count++;
        }
        int check=0;
        for(int i=len-1;i>=0;i--)
        {
        	check=0;
        	for(int j=0;j<map.size()-1;j++)
            {
        		if(!map.get(j).get(i).equals(map.get(j+1).get(i)))
                {
        			check=1;
        			break;
        		}
        	}
        	if(check==0)
            {
        		return map.get(0).get(i);
            }
        }
        return "";
    }
}
