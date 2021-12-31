package assignments.chapter4;

public class IterationQ5
{
    public static void main(String[] args)
    {
        for(int i=5; i>=2; i--)
        {
            switch (i)
            {
                case 1: case 3: System.out.println("YES"); break;
                case 2: case 4: case 5: System.out.println("NO");
            }
        }
        System.out.println("OK");
    }
}
