import java.util.*;
public class U4AIE20144_A3
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter testcases: ");
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

        //pattern checking
        patternCheck(txt, pattern);
    }
    void patternCheck(String [] txt, String [] pattern)
    {
        int i=0;
        int j=0;
        while(i<T)
        {
            while(j<P)
            {
                if(pattern[j].equals(txt[i]))
                {
                    System.out.println("Matching");
                    j++;
                }
                else
                {
                    i++;
                }
            }
        }
    }
}
