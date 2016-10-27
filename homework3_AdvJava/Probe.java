//**********************************************************
//  Probe.java
//  Course: cs 211s
//  Homework 3
//  Author: Violeta Simovska
//  date : 10.07.2016
//  Probe class shows the power of Reflection
//**********************************************************
import java.util.*;
import java.lang.reflect.*;

class Probe
{
    public static String t[];
    public static Class obj;
    
    //****************** displayConstructors ***************
    public static void displayConstructors(Class obj)
    {
        System.out.println();
        System.out.println("Constructors for this class are:");
        Constructor[] con = obj.getConstructors();
        for(Constructor k: con)
        {
            System.out.println(k);
        }
    }
    //****************** displayInterfaces *****************
    public static void displayInterfaces(Class obj)
    {
        System.out.println();
        System.out.println("Interfaces for this class are:");
        Class[] i = obj.getInterfaces();
        for(Class k: i)
        {
            System.out.println(k);
        }
    }
    //****************** displayFields *********************
    public static void displayFields(Class obj) throws Exception
    {
        System.out.println();
        System.out.println("Fields for this class are:");
        Field[] f = obj.getDeclaredFields();
        
        for(Field k: f)
        {
            if(!k.isAccessible())
                k.setAccessible(true);
            if(k.get(obj.newInstance()) != null)
                System.out.println(k + "=" + k.get(obj.newInstance()));
            else
                System.out.println(k);
        }
    }
    
    //****************** displayConstants *****************
    public static void displayConstants(Class obj)
    {
        System.out.println();
        System.out.println("Constants for this class are:");
        
        Field[] f = obj.getDeclaredFields();
        for(Field k: f)
        {
            if(Modifier.isFinal(k.getModifiers()))
            {
                System.out.println(k);
            }
        }
    }
    //****************** displayMethods *******************
    public static void displayMethods(Class obj)
    {
        System.out.println();
        System.out.println("Methods for this class are:");
        Method[] m = obj.getDeclaredMethods();
        for(Method k: m)
        {
            System.out.println(k);
        }
    }
    //****************** allOfTheAbove *******************
    public static void allOfTheAbove(Class obj)throws Exception
    {
        displayInterfaces(obj);
        displayConstants(obj);
        displayFields(obj);
        displayMethods(obj);
        displayConstructors (obj);
    }
    //****************** main ****************************
    public static void main(String args[]) throws Exception
    {
        if(args.length == 0)
        {
            System.err.println("Missing command line argument!");
            System.exit(-1);
        }
        
        GetOpt g = new GetOpt(args, "iCvmac");
        int c = 0;
        
        g.opterr(false);
        t = g.getarg();
        
        System.out.print("Class name is: ");
        for(String s: t) if(!s.equals("")) System.out.print(s);
        
        try
        {
            obj = Class.forName(t[0]);
            System.out.println();
            //System.out.println("Obj is: " + obj.getName());
            
            while( (c = g.getopt()) != -1)
            {
                switch(c)
                {
                    case 'i': displayInterfaces(obj);break;
                    case 'C': displayConstants(obj);break;
                    case 'v': displayFields(obj);break;
                    case 'm': displayMethods(obj);break;
                    case 'c': displayConstructors(obj); break;
                    case 'a': allOfTheAbove(obj); break;
                    case '?': System.out.println("Wrong option: "
                                                 + g.optopt());
                        System.exit(-1);
                }
            }
        }catch (ClassNotFoundException e)
        {
            System.out.println();
            System.out.println("Class not found!");
        }
    }
}
