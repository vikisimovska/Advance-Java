//****************************************************************************
//  IPAddress.java
//  Course: cs 211s
//  Homework 1
//  Author: Violeta Simovska
//  date : 09.08.2016
//  IPAddress class that randomly generates,sorts and manipulates IP Addresses
//****************************************************************************

public class IPAddress
{
    //*******************************rand()***********************************
    //random number generator
    public static int rand (int a, int b)
    {
        return ((int)((b-a+1)*Math.random()+a));
    }
    //*******************************ipAddress()******************************
    //creating an IP Address
    public String ipAddress()
    {
        int r1 = rand (0,255);
        int r2 = rand (0,255);
        int r3 = rand (0,255);
        int r4 = rand (0,255);
        
        String s1 = Integer.toString(r1);
        String s2 = Integer.toString(r2);
        String s3 = Integer.toString(r3);
        String s4 = Integer.toString(r4);
        
        String ipAddress = s1.concat(".").concat(s2).concat(".")
        .concat(s3).concat(".").concat(s4);
        return ipAddress;
    }
    //*******************************gen()************************************
    //generating 'n' IP addresses
    public String[] gen(int n)
    {
        String [] ipArray = new String[n];
        for(int i = 0; i < n; i++)
        {
            ipArray[i] = ipAddress();
            //System.out.println(ipArray[i]);
        }
        return ipArray;
    }
    //******************************ugen()************************************
    //generating 'n' unique IP addresses
    public String[] ugen(int n)
    {
        String [] ipArray = new String[n];
        String temp;
        int i;
        for (i = 0; i < n; i++)
        {
            temp = ipAddress();
            for (int j = 0; j < i; j++)
            {
                if(temp.equals(ipArray[j]))
                {
                    temp = ipAddress();
                    j=0;
                }
            }
            ipArray[i]=temp;
            System.out.println(ipArray[i]);
        }
        return ipArray;
    }
    //*******************************head()***********************************
    //displaying the first 'n' elements of an array
    public void head (String[] ipArray, int n)
    {
        if (n > ipArray.length)
        {
            n = ipArray.length;
        }
        for (int i = 0; i < n; i++)
        {
            System.out.println(ipArray[i]);
        }
    }
    //*******************************tail()***********************************
    //displays the last 'n' elements of an array
    public void tail (String[] ipArray, int n)
    {
        if (n > ipArray.length)
        {
            n = ipArray.length;
        }
        for (int i = ipArray.length-1; i > (ipArray.length-1-n); i--)
        {
            System.out.println(ipArray[i]);
        }
    }
    //*******************************sort()************************************
    //sorting the IP Addresses in assending order
    public String [] sort(String ipstring[])
    {
        String [] SortedIp = new String[ipstring.length];
        int [][] a = new int[ipstring.length][4];
        String[] tempArray = new String[4];
        
        for (int i=0; i < ipstring.length; i++)
        {
            tempArray = ipstring[i].split("\\.");
            
            for (int j=0; j < 4; j++)
            {
                a[i][j] = Integer.parseInt(tempArray[j]);
            }
        }
        
        int pass, in, temp;
        for (pass=1; pass < ipstring.length; pass++)
        {
            // count how many times
            // This next loop becomes shorter and shorter
            for (in=0; in < (ipstring.length) - pass; in++)
            {
                if(a[in][0] > a[in+1][0])    // out of order
                {
                    temp = a[in][0];
                    a[in][0] = a[in+1][0];
                    a[in+1][0] = temp;
                    //swap(in, in+1);     // swap them
                    temp = a[in][1];
                    a[in][1] = a[in+1][1];
                    a[in+1][1] = temp;
                    //swap(in, in+1);     // swap them
                    temp = a[in][2];
                    a[in][2] = a[in+1][2];
                    a[in+1][2] = temp;
                    //swap(in, in+1);     // swap them
                    //swap(in, in+1);     // swap them
                    temp = a[in][3];
                    a[in][3] = a[in+1][3];
                    a[in+1][3] = temp;
                    //swap(in, in+1);     // swap them
                }
                if(a[in][0] == a[in+1][0])
                {
                    if(a[in][1] > a[in+1][1])    // out of order
                    {
                        temp = a[in][0];
                        a[in][0] = a[in+1][0];
                        a[in+1][0] = temp;
                        //swap(in, in+1);     // swap them
                        temp = a[in][1];
                        a[in][1] = a[in+1][1];
                        a[in+1][1] = temp;
                        //swap(in, in+1);     // swap them
                        temp = a[in][2];
                        a[in][2] = a[in+1][2];
                        a[in+1][2] = temp;
                        //swap(in, in+1);     // swap them
                        //swap(in, in+1);     // swap them
                        temp = a[in][3];
                        a[in][3] = a[in+1][3];
                        a[in+1][3] = temp;
                        //swap(in, in+1);     // swap them
                    }
                    if(a[in][1] == a[in+1][1])    // out of order
                    {
                        if(a[in][2] > a[in+1][2])
                        {
                            temp = a[in][0];
                            a[in][0] = a[in+1][0];
                            a[in+1][0] = temp;
                            //swap(in, in+1);     // swap them
                            temp = a[in][1];
                            a[in][1] = a[in+1][1];
                            a[in+1][1] = temp;
                            //swap(in, in+1);     // swap them
                            temp = a[in][2];
                            a[in][2] = a[in+1][2];
                            a[in+1][2] = temp;
                            //swap(in, in+1);     // swap them
                            //swap(in, in+1);     // swap them
                            temp = a[in][3];
                            a[in][3] = a[in+1][3];
                            a[in+1][3] = temp;
                            //swap(in, in+1);     // swap them
                        }
                        if(a[in][2] == a[in+1][2])
                        {
                            if(a[in][3] > a[in+1][3])
                            {
                                temp = a[in][0];
                                a[in][0] = a[in+1][0];
                                a[in+1][0] = temp;
                                //swap(in, in+1);     // swap them
                                temp = a[in][1];
                                a[in][1] = a[in+1][1];
                                a[in+1][1] = temp;
                                //swap(in, in+1);     // swap them
                                temp = a[in][2];
                                a[in][2] = a[in+1][2];
                                a[in+1][2] = temp;
                                //swap(in, in+1);     // swap them
                                //swap(in, in+1);     // swap them
                                temp = a[in][3];
                                a[in][3] = a[in+1][3];
                                a[in+1][3] = temp;
                                //swap(in, in+1);     // swap them
                            }
                        }
                        
                    }
                }
            }
        }
        for(int cntr = 0; cntr<ipstring.length;cntr++)
        {
            for(int i=0;i<4;i++)
            {
                if(i==0)
                {
                    SortedIp[cntr] = Integer.toString(a[cntr][i]);
                }
                else
                {
                    SortedIp[cntr] = SortedIp[cntr] +"."
                    +Integer.toString(a[cntr][i]);
                }
            }
        }
        
        return SortedIp;
    }
    //*******************************main()**************************************
    //main method
    public static void main(String[] args)
    {
        IPAddress ip = new IPAddress();
        
        System.out.println("Printing 10 unique IPAddresses: ");
        String[] ugenArray = ip.ugen(10);
        
        System.out.println("");
        System.out.println("Printing the first 5 using head method: ");
        ip.head(ugenArray,5);
        
        System.out.println("");
        System.out.println("Printing the last 5 using tail method: ");
        ip.tail(ugenArray,5);
        System.out.println("");
        
        //sorting 5 randomly generated IPAddresses
        System.out.println("Sorting 10 randomly generated IPAddresses: ");
        String[] genArray = ip.gen(10);
        String[] genSortArray = ip.sort(genArray);
        //traversing and printing the unsorted array
        for (int i = 0; i < genArray.length; i++)
        {
            System.out.println("Ip given : "+ genArray[i]);
        }
        System.out.println("");
        //traversing and printing the sorted array
        for (int i = 0; i<genSortArray.length; i++)
        {
            System.out.println("Ip sorted : "+ genSortArray[i]);
        }
        System.out.println("..end of test");
        
    }
}
