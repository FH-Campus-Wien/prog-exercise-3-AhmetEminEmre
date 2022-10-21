package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static

    public static void main(String[] args) {
        //One Month Calendar
        oneMonthCalendar(31, 3);
        System.out.println();

        //Pseudo Random Numbers
        int count = 1;
        long[] randomnumbers = lcg(11);
        for (int i = 1; i < randomnumbers.length; i++)
        {
            System.out.printf("Number" + count + ": " + randomnumbers[i]);
            count++;
            System.out.println();
        }

        //Guessing Game
        guessingGame(randomNumberBetweenOneAndHundred());

        //swapArrays
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] array2 = new int[]{100, 202, 30, 14, 15, 16};
        swapArrays(array1, array2);

        //camelCase
        System.out.println(camelCase("AnY noise annoYs an oYster but a noisY noise annoYs an oYster more."));

        //checkDigit
        int[] input = new int[]{3, 9, 1, 5, 8};
        checkDigit(input);
    }
    public static void oneMonthCalendar(int days, int startday)        //if start is 3 first day in this month is wednesday
    {
        for ( int j = 1; j < startday; j++)
        {
            System.out.print("   ");
        }

        for (int i = 1; i <= days; i++)
        {
            if ((i + startday - 2) % 7 == 0)
            {
                System.out.println();
            }
            if ( i < 10)
            {
                System.out.print(" ");
            }
            System.out.print(i + " ");
        }

        System.out.println();
    }

    public static long[] lcg(long seed)
    {
        long faktor = 1103515245L;
        long inkrement = 12345;
        long modul = 2147483648L;

        long[] randomNumbers = new long[10];

        for (int i = 0; i < 10; i ++)
        {
            seed = (faktor * seed + inkrement) % modul;
            randomNumbers[i] = seed;
        }
        return randomNumbers;
    }

    public static void guessingGame(int numberToGuess)
    {
        int count = 1;
        Scanner sc = new Scanner(System.in);

        while(count != 11)
        {
            System.out.print("Guess number " + count + ": ");
            int number1 = sc.nextInt();

            if (numberToGuess > number1 && count != 10)
            {
                System.out.println("The number AI picked is higher than your guess.");
            }
            else if (numberToGuess < number1 && count != 10)
            {
                System.out.println("The number AI picked is lower than your guess.");

            }
            else if (numberToGuess == number1)
            {
                System.out.println("You won wisenheimer!");
                break;
            }
            else if(count == 10)
            {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
            }
            count++;
        }
    }

    public static int randomNumberBetweenOneAndHundred()
    {
        Random rndm = new Random();
        return rndm.nextInt(100) + 1;
    }

    public static boolean swapArrays (int[] first, int[] second)
    {
        boolean check = false;
        if (first.length != second.length)
        {
            check = false;
        }
        else
        {
            for(int i = 0 ; i < first.length; i++)
            {
                first[i] = first[i] ^ second[i];
                second[i] = first[i] ^ second[i];
                first[i] = first[i] ^ second[i];

                check = true;
            }
        }

        return check;
    }

    public static String camelCase(String value)
    {
        // Mit Hilfe aus Internet und Videos erledigt. Eine andere Version folgt ohne .replace (habe die API Klasse kurz vor der Abgabe bemerkt)..
        char[] stringValue = value.toCharArray();
        if (stringValue[0] >= 97 && stringValue[0] <= 122)
        {
            stringValue[0] -= 32;
        }

        for (int i = 0; i < stringValue.length; i++)
        {
            if (i >= 1 && stringValue[i -1] == ' ')
            {
                if (stringValue[i] >= 97)
                {
                    if (stringValue[i] <= 122)
                    {
                        stringValue[i] -= 32;
                    }
                }

            }
            if (i >= 1 && stringValue[i -1] != ' ')
            {
                if (stringValue[i] >= 65)
                {
                    if (stringValue[i] <= 90)
                    {
                        stringValue[i] += 32;
                    }
                }

            }
        }

        for (int i = 0; i < stringValue.length; i++)
        {
            if ((stringValue[i] > 0 && stringValue[i] <= 64) || (stringValue[i] >= 91 && stringValue[i] <= 96) || (stringValue[i] >= 123 && stringValue[i] <= 127))
            {
                stringValue[i] = 32;
            }
        }
        String sol = String.valueOf(stringValue).replaceAll(" ","");
        return sol;
    }

    public static int checkDigit(int[] code)
    {
        //Aray + 2
        //Produkte werden summiert
        //Summe/11 und rest wird gespeichert
        //Prüfziffer -> 11 - Rest von oben
        // Wenn Diff. 10 dann Ziffer -> 0, Diff 11 -> Ziffer ->5

        int sum = 0;

        for(int i = 0; i < code.length; i++)
        {
            int weight = i + 2;
            int product = weight * code[i];
            sum = sum + product;
        }

        int sum2 = sum % 11;
        int pruefziffer = 11 - sum2;

        if(pruefziffer == 10)
        {
            pruefziffer = 0;
        }
        if(pruefziffer == 11)
        {
            pruefziffer = 5;
        }

        return pruefziffer;
    }
}