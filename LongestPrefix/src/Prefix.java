import java.util.*;
public class Prefix
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

            text=text.toUpperCase();
            pattern=pattern.toUpperCase();

            KMP_Search obj = new KMP_Search();
            obj.PatternSearch(pattern, text);
        } 
        in.close();
    }
}
class KMP_Search
{
    int T;
    int P;
    int a;
    String [] txt;
    String [] pattern;
    int loc; 
    int len=0;
    void PatternSearch(String pat, String text)
    {
        T = text.length();
        P = pat.length();
        txt = new String [T];
        pattern = new String[P];

        //inserting the text into an array
        for (int i = 0; i < T; i++) 
        {
            txt[i]=text.charAt(i) + " ";
        }

        //inserting the pattern into an array
        for (int i = 0; i < P; i++) 
        {
            pattern[i]=pat.charAt(i) + " ";
        }

        //FindLongSubStr(text, pat);
        a = FindPrefix(pattern);

        //gets the longest pattern
        String mat = FindLongSubStr(text, pat); 

        int index = text.indexOf(mat);

        //gets the length of the longest substring
        int b = mat.length(); 
        if(b==0)
        {
            loc=-1;
        }
        else
        {
            loc=index;
        }

        // prints the output
        System.out.println(a+" "+b+" "+loc);
    }
    String FindLongSubStr(String  text, String Pattern)
    {
        String resultStr="";
        boolean f=false;
        String str="";
        int temp=FindPrefix(pattern);
        int tem=0;

        if(temp>0)
        {
            tem=temp;
        }
        else
        {
            tem=0;
        }
        for(int i=tem;i<=P;i++)
        {
            resultStr=Pattern.substring(0,i);
            if(text.contains(resultStr))
            {
                f=true;
                str=resultStr;
            }
        }
        if(f==true)
        {
            return str;
        }
        else
        {
            return "";
        }
    }
	int FindPrefix(String [] pattern)
    {
        int lps[] = new int[P];
        lps[0] = 0;
        len = 0;
        int i = 1;
        
        while (i < P)
        {
            if (pattern[i].equals(pattern[len]))
            {
            	len++;
                lps[i] = len;
                i++;
            }
            else
            {
            	if (len != 0)
                {
                    len = lps[len-1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
        int res=0;
        int count=0;
        for (int k=0;k<P;k++)
        {
            if(lps[k]==0)
            {
                count++;
            }
        }
        res=pattern.length-count;
        return res;
    }
}