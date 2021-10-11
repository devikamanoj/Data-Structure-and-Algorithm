import java.util.*;
public class U4AIE20144_A3
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int TC = in.nextInt();
        in.nextLine();
        for(int i=0;i<TC ; i++)
        {
            String text = in.nextLine();
            text=text.replace(" ", "");

            String pattern = in.nextLine();
            pattern=pattern.replace(" ", "");
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
    int loc=0;
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

        String mat = printLCSubStr(txt, pattern,T,P);
        mat=mat.replace(" ", "");
        int index = text.indexOf(mat);
        System.out.print(prefix(text, pat)+" ");
        System.out.print(LCSubStr(txt, pattern,T,P)+" "); //3
        if (LCSubStr(txt, pattern,T,P)==0)
        {
            System.out.println("-1");
        }
        else
            System.out.println(index);

    }
    int LCSubStr(String[] s,String[] t,int n,int m)
    { 
        int dp[][]=new int[2][m+1];
        int res=0;
      
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s[(i-1)].equals(t[j-1]))
                {
                    dp[i%2][j]=dp[(i-1)%2][j-1]+1;
                    if(dp[i%2][j]>res)
                    {
                        res=dp[i%2][j];
                    }
                }
                else 
                {
                    dp[i%2][j]=0;
                }
            }
        }
        return res;
    }
    String printLCSubStr(String [] X, String [] Y, int m, int n)
    {
        int[][] LCSuff = new int[m + 1][n + 1];
 
        int len = 0;
 
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
    int prefix(String txt, String pat)
    {
        int len=0;
        boolean flag=false;
        String str = "";
        int n=pat.length();
        for(int i=0;i<=n;i++)
        {
            str=pat.substring(0,i);
            if(txt.contains(str))
            {
                flag=true;
                len=str.length();
            }
        }
        if(flag==true)
        {
            return len;
        }
        else
        {
            return 0;
        }
    }
}
