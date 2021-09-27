import java.util.*;
public class JonSnow_TheKingofNorth
{
    static int array[];
    static int a,b,c;
    static int val,sum;
    public static void main(String args[] ) throws Exception 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        
        //System.out.println(" enter testcases: ");
        int t = in.nextInt();
        array = new int[3];  

        for(int i = 1;i <= t;i++)
        {       
            for(int j=0; j<3;j++)
            {
                //System.out.println("enter elements: ");
                array[j]=in.nextInt(); 
            }
            a = array[0];
            b = array[1];
            c = array[2];

            sum=a+b+c;
            val=check();
            System.out.println(val);
        }
    }
    static int check()
    {
        if(sum%9==0 && a>(sum/7)-1 && b>(sum/7)-1 && c>(sum/7)-1)
        {
            val=1;
        }
        else if(sum%9==0 && a<(sum/7)-1 && b<(sum/7)-1 && c<(sum/7)-1)
        {
            val=0;
        }
        else if(a==0 ||b==0 ||c==0)
        {
            val=0;
        }
        else
        {
            val=0;
        }
        return val;
    }
}
