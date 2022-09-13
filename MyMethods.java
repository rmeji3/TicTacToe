/**
 * @file:  MyMethods.java
 * @author: Kevin Walsh <kwalsh@bhsd228.com>
 * @date: 9/24/19
 *
 * This is going to be software that will contain several methds that will be used through out the year.
 */

// import statements
import java.util.Random;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class MyMethods
{
    // Doesn't need a main method - it will not run on it's own.
    
    /** Recieves and Prints the Program Title<br>
     *  Prints the programmer<br>
     *  Prints the Date<br>
     *  @param incomingTitle     Title of the program to be printed
     */
    public static void programTitle(String programmerName)
    {
        System.out.println("Program Name:\tHello World");
        System.out.println("Written By:\t" + programmerName);
        System.out.println("Date:\t\t" + getDate());
    }
    
    public static void programTitle(String incomingTitle, int num1)
    {
        System.out.println("Program Name:\t" + incomingTitle);
        System.out.println("Written By:\tKevin Walsh");
        System.out.println("Date:\t\t" + getDate());
    }
    
    /**
     *Prints the date in "MM-dd-yy" format
     *Uses SimpleDateFormat
     *@return the current date formatted as a String
     */
    public static String getDate()
    {
        Date today = new Date();
        // set the date format i want
        String format = "MM-dd-yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.format(today);
    }

    // Add a random number generator
    /**
     *Generates a psuedo-random int
     *@return The randomly generated int
     */
    public static int getRandomInt()
    {
        // will return just any old random number
        Random gen = new Random();

        return gen.nextInt();
    }

    // Add another random number generator
    /**
     *Generates a psuedo-random between 1 and the incomingLimit
     *@param incomingLimit Top limit of the randomly generated number
     *@return The randomly generated int between 1 and the incomingLimit
     */
    public static int getRandomInt(int incomingLimit)
    {
        // will return a random number with a top limit
        Random gen = new Random();

        return (gen.nextInt(incomingLimit) + 1);
    }

    // Create some scanners for user input
    // String input
    /**
     *Creates a scanner for and receives user input of a string
     *@return String from the user input
    */
    public static String getString()
    {
        String returnString;
        Scanner input = new Scanner(System.in);

        returnString = input.nextLine();

        return returnString;
    }
    // String input - with prompt
    /**
    *Creates a scanner for and receives user input of a string
     *@param prompt Prompt to user that is printed to the console
     *@return String from the user input
    */
    public static String getString(String prompt)
    {
        // Prompt to user:
        System.out.print(prompt);

        return getString();
    }

    // int input
    public static int getInt()
    {
        Integer stringInt = new Integer(0);
        boolean inputIsANumber;
        
        do{
            try{
                stringInt = new Integer(getString());
                inputIsANumber = true;
                //return stringInt.intValue();
            }catch(NumberFormatException e){
                inputIsANumber = false;
                System.out.print("Please enter a NUMBER!!!: ");
            }
        }while(!inputIsANumber);
        
        return stringInt.intValue();
        
    }
    // int input with the prompt
    public static int getInt(String prompt)
    {
        System.out.print(prompt);

        return getInt();
    }

    // double input
    public static double getDouble()
    {
        Double stringDouble = new Double(0.0);
        boolean inputIsANumber;
        
        do{
            try{
                stringDouble = new Double(getString());
                inputIsANumber = true;
            }catch(NumberFormatException e){
                inputIsANumber = false;
                System.out.print("Please enter a decimal!!: ");
            }
        }while(!inputIsANumber);
        
        return stringDouble.doubleValue();
    }

    public static double getDouble(String prompt)
    {
        System.out.print(prompt);

        return getDouble();
    }
    
    public static String getPercent(double incomingNumber, int places)
    {
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMinimumFractionDigits(places);

        return(percent.format(incomingNumber));
    }
    
    public static String getDecimal(double incomingNumber, int places)
    {
        String decimalString = "#.";
        
        for(int i = 1; i <= places; i++)
            decimalString += "#";

        DecimalFormat decimal = new DecimalFormat(decimalString);

        return(decimal.format(incomingNumber));
    }

    // Helper method to change text to a boolean
    public static boolean toBool(String input)
    {
        char firstLetter = input.toUpperCase().charAt(0);

        // Modified version of the if statement
        return firstLetter == 'Y' ? true:false;
    }
}