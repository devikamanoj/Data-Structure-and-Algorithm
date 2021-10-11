import java.util.*;

import org.w3c.dom.Text;
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
    void PatternSearch(String pat, String text)
    {
        int T = text.length();
        int P = pat.length();
        String [] txt = new String [T];
        String [] pattern = new String[P];

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
        for(int i =0; i<P;i++)
        {
            for(int j=0;j<T;j++)
            {
                if(pattern[i].equals(txt[j]))
                {
                    System.out.println("Matching");
                }
            }
        }
    }
    void patternCheck(String [] txt, String [] pattern)
    {
        
    }
}
