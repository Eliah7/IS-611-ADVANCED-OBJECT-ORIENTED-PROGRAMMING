package assignments.chapter4;

import java.util.Scanner;
import java.lang.Math;

public class IterationQ7
{
    public static void main(String[] args)
    {
        int num, square;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a number ");
        num = keyboard.nextInt();
        System.out.print("Enter the square of this number ");
        square = keyboard.nextInt();
        // loop to check answer
        while (square != Math.sqrt(num))
        {
            System.out.println("Wrong answer, try again");
            square = keyboard.nextInt();
        }
        System.out.println("Well done, right answer");
    }
}