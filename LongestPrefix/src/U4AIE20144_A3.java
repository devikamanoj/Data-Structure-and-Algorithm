import java.util.*;
public class U4AIE20144_A3
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

            text=text.toLowerCase();
            pattern=pattern.toLowerCase();

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
        String mat = FindLongSubStr(text, pat); //gets the longest pattern
        mat=mat.replace(" ", "");

        int index = text.indexOf(mat);
        int b = mat.length(); //gets the length of the longest substring
        if(b==0)
        {
            loc=-1;;
        }
        else
        {
            loc=index;
        }
        System.out.println(a+" "+b+" "+loc);
    }
    String FindLongSubStr(String  X, String Y)
    {
        String resultStr="";
        boolean f=false;
        String str="";
        for(int i=0;i<=P;i++)
        {
            resultStr=Y.substring(0,i);
            if(X.contains(resultStr))
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

	int FindPrefix(String[] s)
    {
        int lps[] = new int[P];
        lps[0] = 0;
        len = 0;
        int i = 1;
        
        while (i < P)
        {
            if (s[i].equals(s[len]))
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
                    lps[i] = 0;
                    i++;
                }
            }
        }
        int res=0;
        int max=lps[0];
        for (int k=1;k<P;k++)
        {
           
            if(lps[k]>max)
            {
                max=lps[k];
            }
        }
        res=max;
        return res;
    }
}