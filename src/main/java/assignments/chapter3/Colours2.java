package assignments.chapter3;

import java.util.Scanner;

public class Colours2
{
    public static void main(String[] args)
    {
        int x;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a number: ");
        x = keyboard.nextInt();
        if (x > 10)
        {
            System.out.println("Green");
        } else
        {
            System.out.println("Blue");
        }
        System.out.println("Red");
    }
}