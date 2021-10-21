import java.util.*;
public class U4AIE20144 
{
    static String str;
    static ArrayList<String> newstr ;
    static int len;
    static String[] string;
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int n=3;
        //in.nextLine();
        for(int i=0;i<n;i++)
        {
            str=in.nextLine();
            //str=str.toLowerCase(); 
            string = str.split(" ");
            String ts=string[1];
            len=Integer.parseInt(ts);

            ArrayListInsert();
          //  System.out.print(newstr+" ");
            if(string[0].startsWith("a"))
            {

                for(int j=0;j<len;j++)
                {
                    SpellingCorrection.insert(newstr.get(j),j);
                }
            }
            if(string[0].startsWith("d"))
            {
                for(int j=0;j<len;j++)
                {
                    SpellingCorrection.delete(newstr.get(j));
                }
            }
            if(string[0].startsWith("f"))
            {
                for(int j=0;j<len;j++)
                {
                    SpellingCorrection.find(newstr.get(j));
                }
            }
        }
       // SpellingCorrection.print();
        in.close();
    }
    static void ArrayListInsert()
    {
        newstr = new ArrayList<String>(len+2);
        for(int j=2;j<len+2;j++)
        {
            newstr.add(string[j]);
        }
    }
}
class SpellingCorrection
{
    static Hashtable<String,Integer> HT = new Hashtable<String,Integer>();
    static int count=0;
    static String newstr="";
    static void insert(String string,int j)
    {
        HT.put(string,j);
    }
    static void delete(String string)
    {
        HT.remove(string);
    }
    static void find(String string)
    {
        if(HT.containsKey(string))
        {
            System.out.print("Y"+" ");
        }
        else
        {
            replacealphabet(string);
            insertSpace(string);
            swappingnei(string);
            removeelem(string);
            replaceElem(string);
            System.out.print(count+" ");
            count=0;
        }
    }
    static void removeelem(String str)
    {
        String[] strSplit = str.split("");
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strSplit));
        for(int i=0;i<strList.size();i++)
        {
            String temp=strList.get(i);
            strList.remove(strList.get(i));
            String newstr=listtoString(strList);
            strList.add(i,temp);
            if(HT.containsKey(newstr))
            {
               count++;
            }
        }

    }

    static void swappingnei(String str)
    {
        String[] strSplit = str.split("");
        
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strSplit));

        for(int i=0;i<strList.size();i++)
        {
            if(i+1<strList.size())
            {
                Collections.swap(strList, i, i+1);
                newstr=listtoString(strList);
                Collections.swap(strList, i+1, i);
                if(HT.containsKey(newstr))
                {
                   count++;
                } 
            }
        }
    }
    static String listtoString(ArrayList<String>strList)
    {
        String list = Arrays.toString(strList.toArray()).replace("[", "").replace("]", ""); 
        list = list.replaceAll(", ", "");
        return list;
    }
    static void insertSpace(String str)
    {
        String x,y;
        for(int i=1;i<str.length();i++)
        {
            x=str.substring(0, i);
            y=str.substring(i, str.length());
            if(HT.containsKey(x)||HT.containsKey(y))
            {
                count++;
            }
        }
    }
    static void replacealphabet(String str)
    {
        char c;
        String newstr,x,y;

        for(int i=0;i<str.length();i++)
        {
            x=str.substring(0, i);
            y=str.substring(i,str.length());

            for(c = 'a'; c <= 'z'; ++c)
            {
                newstr=x+c+y;
                if(HT.containsKey(newstr))
                {
                    count++;
                }
                else
                {
                    newstr=str;
                }
            }
        }
        x=str.substring(0, str.length()-1);
        y=str.substring(str.length()-1, str.length());
        for(c = 'a'; c <= 'z'; ++c)
        {
            newstr=x+c+y;
            if(HT.containsKey(newstr))
            {
                count++;
            }
            else
            {
                newstr=str;
            }
        }
        for(c = 'a'; c <= 'z'; ++c)
        {
            newstr=str+c;
            if(HT.containsKey(newstr))
            {
                count++;
            }
            else
            {
                newstr=str;
            }
        }
    }
    static void replaceElem(String str)
    {
        char c;
        String newstr;
        
        String[] strSplit = str.split("");
        
        ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strSplit));
        
        String[] temp=new String[strList.size()];
        strList.toArray(temp);
 
      //  Collections.copy(strList, temp);
        for(int i=0;i<strList.size();i++)
        {
           strList = new ArrayList<String>(Arrays.asList(temp));

            for(c = 'a'; c <= 'z'; ++c)
            {
                String S=Character.toString(c);
                strList.set(i, S);
                newstr=listtoString(strList);
                if(HT.containsKey(newstr))
                {
                   count++;
                } 
            }

        }

    }
}
