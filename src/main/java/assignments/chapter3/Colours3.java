package assignments.chapter3;

import java.util.Scanner;
public class Colours3
{
    public static void main(String[] args)
    {
        int x;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a number: ");
        x = keyboard.nextInt();
        switch (x)
        {
            case 1: case 2: System.out.println("Green");
            case 3: case 4: case 5: System.out.println("Blue");
            default: System.out.println("numbers 1-5 only");
        }
        System.out.println("Red");
    }
}