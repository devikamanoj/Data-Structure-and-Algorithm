import java.util.Scanner;

public class NumberGame
{
    static int arr[];
    static int x,y;
    public static void main(String[] args) 
    {
        int t,n;
        Scanner in = new Scanner(System.in);
        t=in.nextInt();
        for(int k=0;k<t;k++)
        {
            n=in.nextInt();
            arr=new int[n];
            for(int i=0;i<n;i++) 
            {
                int v=in.nextInt();
                arr[i]=v;
            }
            for(int i=n-1;i>0;i--) 
            {
                if(arr[i]<arr[i-1]) 
                {
                    x=i;
                    break;
                }
                else
                    x=-1;
            }
            if(x==-1)
            {
                System.out.println(-1);
            }
            if(x!=-1)
            {
                y=x;
                for (int j=x;j<n;j++)
                    if (arr[j]<arr[x-1] && arr[j]>arr[y])
                        y=j;
                int temp=arr[x-1];
                arr[x-1]=arr[y];
                arr[y]=temp;
                dsort(arr,x,n);
            }
        }
        String strav=String.format("%.1f",16/3);
        float avg =Float.parseFloat(strav);
        if((avg)%1==0)
        {
            System.out.print((int)avg);
        }
        else
        {
            System.out.print(avg);
        }
    }
    public static void dsort(int[] arr, int x, int n) 
    {
        int max,temp;
        for (int i=x;i<n-1;i++) 
        {
            max = i;
            for (int j=max+1;j<n;j++)
            {
                if (arr[j]>arr[max])
                {
                    max=j;
                }
            }
            temp=arr[i];
            arr[i]=arr[max];
            arr[max]=temp;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]);
        }

        System.out.println();
        
    }
}
