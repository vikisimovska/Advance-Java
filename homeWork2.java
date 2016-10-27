//********************************************************************
//  homeWork2.java
//  Course: cs 211s
//  Author: Violeta Simovska
//  date : 09.20.2016
//  This program loads a file or just parts of it, if range is given
//********************************************************************
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class homeWork2
{
    private static String[] fileArray;
    private static String r;
    private static ArrayList<String> rangeArray;
    
    //*************loadFile*****************
    public static String[] loadFile (String fileName, String...range)
    {
        File file = new File(fileName);
        
        //checks and loads the file into a array
        checkFile(file);
        //checks the user-given range
        if (!checkRange(range))
        {
            displayFile();
        }
        else
        {
            //checks if the chars are valid
            if (validityCheck(r))
            {
                int[] parsedArray = new int[2];
                
                for(int i=0; i < rangeArray.size(); i++)
                {
                    //parses the range and loads the file lines
                    parsedArray = parseLineNumber(rangeArray.get(i));
                    displayFile(parsedArray[0], parsedArray[1]);
                }
            }
            else
            {
                throw new IllegalArgumentException("Invalid characters "
                + "have been entered. ");
            }
        }
        return fileArray;
    }
    //*************displayFile***************
    //loads the whole file
    public static void displayFile()
    {
        for (int i = 0; i < fileArray.length; i++)
        {
            System.out.println("line "+ (i+1) +" "+ fileArray[i]);
        }
    }
    //***********displayFile(to, from)**************
    public static void displayFile(int from, int to)
    {
        for (int i = from - 1; i <= to-1; i++)
        {
            println("line "+ (i+1) +" "+ fileArray[i]);
        }
        println();
    }
    //***********validityCheck**************
    public static boolean validityCheck(String a)
    {
        char[] possibleChars = 
        {
            '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', '-' , '$', ' ', ','
        };
        int count = 0;
        for (int i = 0; i < a.length(); i++)
        {
            for (int j = 0; j < possibleChars.length; j++)
            {
                if (a.charAt(i) == possibleChars[j] )
                {
                    count++;
                }
            }
        }
        return (count == a.length());
    }
    //**************checkFile*******************
    public static void checkFile(File newFile )
    {
        if (!newFile.isDirectory() && newFile.canRead()
        && newFile.isFile())
        {
            try
            {
                Scanner scanner = new Scanner(newFile);
                ArrayList<String> tempArraylist = new ArrayList<>();
                while (scanner.hasNextLine())
                {
                    tempArraylist.add(scanner.nextLine());
                }
                scanner.close();
                fileArray =  tempArraylist.toArray(new String[ tempArraylist.size()]);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
        }
    }
    //***************checkRange**************
    public static boolean checkRange(String[] range)
    {
        if (range.length != 0)
        {
            String temp = range[0];
            r = temp.replaceAll(" ", "");
            println("Ranges that need to be displayed: " + r);
            rangeArray = new ArrayList<>(Arrays.asList(r.split(",")));
            return true;
        }
        return false;
    }
    
    //****************parseLineNumber*************
    public static int[] parseLineNumber(String str)
    {
        int fromTo[] = {-1, -1};
        String from="", to="";
        String numlines ="" + fileArray.length;
        String t = str;
        
        if (!str.isEmpty())
        {
            if(t.contains("-"))
            {
                int position = t.indexOf("-");
                if(t.length() == 1)
                {
                    from="1";
                    to = numlines;
                   
                }
                else if (position == 0)
                {
                    from = "1";
                    to = t.substring(position + 1);
                }
                else if (position == t.length() - 1)
                {
                    from = t.substring(0, position);
                    to = numlines;
                }
                else
                {
                    from = t.substring(0, position);
                    to = t.substring(position+1);
                }
            }
            else
            {
                from = to = t;
            }
            if (from.equals("$"))
            {
                from = numlines;
            }
            if (to.equals("$"))
            {
                to = numlines;
            }
            if (from.equals("0"))
            {
                from = "-1";
            }
            if (to.equals("0"))
            {
                to = "1";
            }
            if(from.matches("^\\d+$") && to.matches("^\\d+$"))
            {
                fromTo[0] = Integer.parseInt(from);
                fromTo[1]=Integer.parseInt(to);
            }
            if(fromTo[0] > fromTo[1])
            {
                fromTo[0] = fromTo[1] = -1;
            }
        }
        return fromTo;
        
    }
    //***********println**************
    public static void println (Object...o)
    {
        if (o.length == 0)
        System.out.println();
        else
        System.out.println(""+ o[0]);
    }
    //***********main**************
    public static void main(String[] args)
    {
        println("********displaying the whole file*******");
        println();
        homeWork2.loadFile("sample.txt");
        
        println();
        println("********displaying valid ranges********");
        println();
        homeWork2.loadFile("sample.txt", "1- 3,5,$,7 -" );
        
        println("********displaying invalid ranges********");
        println();
        homeWork2.loadFile("sample.txt", "1 -3, 5, &**" );
    }
    
}


********displaying the whole file*******

line 1 table
line 2 table-caption
line 3 table-column-group
line 4 table-header-group
line 5 table-footer-group
line 6 table-row-group
line 7 table-cell
line 8 table-column
line 9 table-row

********displaying valid ranges********

Ranges that need to be displayed: 1-3,5,$,7-
line 1 table
line 2 table-caption
line 3 table-column-group

line 5 table-footer-group

line 9 table-row

line 7 table-cell
line 8 table-column
line 9 table-row

********displaying invalid ranges********

Ranges that need to be displayed: 1-3,5,&**
Exception in thread "main" java.lang.IllegalArgumentException: Invalid characters have been entered.
at homework2_advJava.homeWork2.loadFile(homeWork2.java:44)
at homework2_advJava.homeWork2.main(homeWork2.java:222)



