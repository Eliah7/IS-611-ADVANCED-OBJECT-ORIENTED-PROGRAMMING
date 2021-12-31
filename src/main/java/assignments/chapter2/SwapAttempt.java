package assignments.chapter2;

import java.util.Scanner;

public class SwapAttempt
{
    public static void main(String[] args)
    {
        // declare variables
        int x, y, tmp;

        Scanner keyboard = new Scanner(System.in);
        // enter values
        System.out.print("Enter value for x ");
        x = keyboard.nextInt();
        System.out.print("Enter value for y ");
        y = keyboard.nextInt();

        // code attempting to swap two variables
        tmp = x;
        x = y;
        y = tmp;

        //display results
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
