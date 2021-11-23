import java.util.*;
public class ass6{
public static void main(String[] args)
{
    int itpovistfo;
    int itpovistso;
    String novotwg;
    String tvitelaasfp;
    String togtafc1ac2;
   Scanner myObj = new Scanner(System.in);
    int dotvm = 0;
    novotwg = myObj.nextLine();
    int[][] amfftg = new int[Integer.parseInt(novotwg) + 1][Integer.parseInt(novotwg) + 1];
    for (int i = 0; i < Integer.parseInt(novotwg); i++)
    {
        tvitelaasfp = myObj.nextLine();
        String[] tvitelaasfpIntoWords = tvitelaasfp.split(" ");
        int tiiftcl = Integer.parseInt(tvitelaasfpIntoWords[0]);

        for (int j = 2, counter =1; counter<=((tvitelaasfpIntoWords.length)-2)/2; j++, counter++)
        {
            //System.out.println(tvitelaasfpIntoWords[j]);
            amfftg[tiiftcl][Integer.parseInt(tvitelaasfpIntoWords[j])] = Integer.parseInt(tvitelaasfpIntoWords[j + 1]);
            amfftg[Integer.parseInt(tvitelaasfpIntoWords[j])][tiiftcl] = Integer.parseInt(tvitelaasfpIntoWords[j + 1]);
            j++;
        }
    }
    String cftotp;
    cftotp = myObj.nextLine();
    cftotp = cftotp.replaceAll("\\s", "");

    if (Integer.parseInt(cftotp) == 1)
    {
        togtafc1ac2 = myObj.nextLine();
        

        String[] aiw = togtafc1ac2.split(" ");


        for (int j = 1; j<=Integer.parseInt(aiw[0]); j++)
        {

            for (int k = 1; k <= Integer.parseInt(novotwg); k++)
            {
                if (amfftg[k][Integer.parseInt(aiw[j])] != 0)
                {
                    dotvm = dotvm + 1;
                }
            }
            System.out.print(dotvm);
            System.out.print(" ");
            dotvm = 0;
        }
    }
    else if (Integer.parseInt(cftotp) == 2)
    {
        togtafc1ac2 = myObj.nextLine();
        String[] aiw = togtafc1ac2.split(" ");



        for (int j = 1; j<=((aiw.length)-1); j = j + 2)
        {
            itpovistfo = Integer.parseInt(aiw[j]);
            itpovistso = Integer.parseInt(aiw[j + 1]);
            System.out.print(amfftg[itpovistfo][itpovistso]);
            System.out.print(" ");
        }
    }

    else if (Integer.parseInt(cftotp) == 3)
    {
        int zlt = 0;
        int i;
        int j;
        for (i = 1; i <= Integer.parseInt(novotwg); i++)
        {
            for (j = 1; j <= Integer.parseInt(novotwg); j++)
            {
                if (i >= j)
                {
                    if (amfftg[i][j] != 0)
                    {
                        zlt++;
                    }
                }
            }
        }

        System.out.print(zlt);
    }
    else if (Integer.parseInt(cftotp) == 4)
    {
        int vfsceotlt = 0;
        int i;
        int j;
        for (i = 1; i <= Integer.parseInt(novotwg); i++)
        {
            for (j = 1; j <= Integer.parseInt(novotwg); j++)
            {
                if (i >= j)
                {
                    if (amfftg[i][j] != 0)
                    {
                        vfsceotlt = vfsceotlt + amfftg[i][j];
                    }
                }
            }
        }
        System.out.print(vfsceotlt);
    }
    else if (Integer.parseInt(cftotp) == 5)
    {
        int i;
        int j;
        for (i = 1; i <= Integer.parseInt(novotwg); i++)
        {
            for (j = 1; j <= Integer.parseInt(novotwg); j++)
            {
                if (i <= j)
                {
                    if (amfftg[i][j] != 0)
                    {
                        System.out.print(i);
                        System.out.print(" ");
                        System.out.print(j);
                        System.out.print(" ");
                        System.out.print(amfftg[i][j]);
                        System.out.print("\n");
                    }
                }
            }
        }
    }
}}
