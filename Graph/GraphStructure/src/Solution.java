import java.util.*;
public class Solution 
{
    public int find_degree(List<Integer> vertexlist,List<Integer> degreelist,int vertex)
    {
    	int index;
    	if(vertexlist.contains(vertex))
    	{	index=vertexlist.indexOf(vertex);
    	    return degreelist.get(index);
    	}
    	else
    		return -1;
    	
    }
    
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
       Scanner in=new Scanner(System.in);
       Solution sol=new Solution();
       int no_vertex;
       no_vertex=in.nextInt();
       in.nextLine();
       List<Integer> vertex_list=new ArrayList<Integer>();  
       List<Integer> degree_list=new ArrayList<Integer>();  
       int [][]adjmatrix=new int[no_vertex][no_vertex];
       int i=0;
       while(i<no_vertex)
       {
    	   String adj_list=in.nextLine();
    	   String array[]=adj_list.split(" ");
    	   vertex_list.add(Integer.parseInt(array[0]));
    	   degree_list.add(Integer.parseInt(array[1]));
    	   for(int j=2;j<array.length;j+=2)
    	   {
    			adjmatrix[Integer.parseInt(array[0])-1][Integer.parseInt(array[j])-1]=Integer.parseInt(array[j+1]);
    	   }
            i++;
       }
       
       int outputnum;
       String result="";
       outputnum=in.nextInt();
       in.nextLine();
       if(outputnum==1)
       {
    	String option1=in.nextLine();
    	String option1_array[]=option1.split(" ");
    	i=0;
    	while(i<Integer.parseInt(option1_array[0]))
    	{
    		result+=sol.find_degree(vertex_list,degree_list,Integer.parseInt(option1_array[i+1]));
    		result+=" ";
    		i++;
    	}
       }
       else if(outputnum==2)
       {
    	   String option2=in.nextLine();
           String option2_array[]=option2.split(" ");
           i=0;
           int j=1;
           while(i<Integer.parseInt(option2_array[0]))
       	   {
       		  result+=adjmatrix[Integer.parseInt(option2_array[j])-1][Integer.parseInt(option2_array[j+1])-1];
       		  result+=" ";
       		  j+=2;
       		  i++;
       	   }
       }
       else if(outputnum==3)
       {
    	   int nonzero=0;
    	   for(int m=0;m<no_vertex;m++)
           {
        	   for(int n=0;n<no_vertex;n++)
        	   {
        		   if(m>n||m==n)
        			   if(adjmatrix[m][n]!=0)
        				   nonzero++;
        			   
        	   }
           } 
    	   result=Integer.toString(nonzero);
       }
       else if(outputnum==4)
       {
    	   int sum=0;
    	   for(int m=0;m<no_vertex;m++)
           {
        	   for(int n=0;n<no_vertex;n++)
        	   {
        		  sum+=adjmatrix[m][n];   
        	   }
           } 
    	   result=Integer.toString(sum/2); 
       }
       else if(outputnum==5)
       {
    	   for(int m=0;m<no_vertex;m++)
           {
        	   for(int n=0;n<no_vertex;n++)
        	   {
        		  if(adjmatrix[m][n]!=0&&m<n)
        			  result+=Integer.toString(m+1)+" "+Integer.toString(n+1)+" "+Integer.toString(adjmatrix[m][n])+"\n";
        	   }
           } 
       }
       System.out.println(result);
	}

}
