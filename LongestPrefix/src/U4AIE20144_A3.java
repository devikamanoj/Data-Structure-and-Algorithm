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

            text=text.replace(" ", "");
            pattern=pattern.replace(" ", "");

            text=text.replaceAll("[^a-zA-Z0-9]", "");
	        pattern=pattern.replaceAll("[^a-zA-Z0-9]", "");

            text=text.toLowerCase();
            pattern=pattern.toLowerCase();

            KMP_Search obj = new KMP_Search();
            obj.PatternSearch(pattern, text);
        } 
    }
}
class KMP_Search
{
    int T;
    int P;
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

        String mat = FindLongSubStr(txt, pattern,T,P); //gets the longest patten
        mat=mat.replace(" ", "");

        int index = text.indexOf(mat);
        int a = FindPrefix(pattern); //finds the prefix
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
    String FindLongSubStr(String [] X, String [] Y, int m, int n)
    {
        int[][] LCSuff = new int[m + 1][n + 1];
 
        len = 0; //initialising len=0
 
        int row = 0, col = 0;
        for (int i = 0; i <= m; i++) 
        {
            for (int j = 0; j <= n; j++) 
            {
                if (i == 0 || j == 0)
                {
                    LCSuff[i][j] = 0;
                }
                else if (X[i-1].equals(Y[j-1])) 
                {
                    LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1;
                    if (len < LCSuff[i][j]) 
                    {
                        len = LCSuff[i][j];
                        row = i;
                        col = j;
                    }
                }
                else
                {
                    LCSuff[i][j] = 0;
                }
            }
        }
        if (len == 0) 
        {
            return " ";
        }
        String resultStr = "";
        while (LCSuff[row][col] != 0) 
        {
            resultStr = X[row - 1] + resultStr; 
            --len;
 
            row--;
            col--;
        }
        return resultStr;
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
