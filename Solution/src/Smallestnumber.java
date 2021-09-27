import java.util.*;
public class Smallestnumber 
{   
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int testcase=in.nextInt();

        for(int i=1; i<=testcase;i++)
        {
            ArrayList<Integer>digits = new ArrayList<Integer>();
            int k;
            int ex=0;
            int nodigi = in.nextInt();
            for(int j=0; j<nodigi;j++)
            {
                digits.add(in.nextInt());
            }
            for(k =nodigi-1; k>0;k--)
            {
                if(digits.get(k)<digits.get(k-1))
                {
                    break;
                }
            }
            if(k==0)
            {
                ex=-1;
                System.out.println(ex);
            }
            if(ex!=-1)
            {
                int value=digits.get(k-1);
                int max=k;
                for(int l=i;l<nodigi;l++)
                {
                    if(digits.get(l)<value && digits.get(l)>digits.get(max))
                    {
                        max=l;
                    }
                }
                Collections.swap(digits, max, k-1);
                Collections.sort(digits.subList(k, nodigi),Collections.reverseOrder());
                    
                String list = Arrays.toString(digits.toArray()).replace("[", "").replace("]", ""); 
                list = list.replaceAll(", ", "");
                System.out.println(list);
            }
        }
    }
}
