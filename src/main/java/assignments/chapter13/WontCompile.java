package assignments.chapter13;

interface Testable
{
    public void test(int x);
}

public class WontCompile
{
    public static void main(String[] args)
    {
        int x = 2;
        helper( (a) -> {
                    a = a * 2;
                    System.out.println(a);
                }, x
        );
    }

    static void helper(Testable objectIn, int g)
    {
        objectIn.test(g);
    }
}