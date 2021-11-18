import java.util.ArrayList;

public class Main {

    public static void squarePatch(int x)
    {
        int[][] result = new int[x][x];

        for(int i = 0; i < result.length; i++)
        {
            for(int j = 0; j < result.length; j++)
            {
                result[i][j] = x;
            }
        }

        for(int i = 0; i < result.length; i++)
        {
            System.out.print("[");

            for(int j = 0; j < result.length; j++)
            {
                System.out.print(result[i][j]);
            }
            System.out.println("]");
        }
    }

    public static boolean ascending(String x) {

        int current = 1;
        StringBuilder sb = new StringBuilder(x);
        ArrayList<Integer> numbers = new ArrayList<>();
        boolean check = false;

        while(current <= sb.length() / 2)
        {
            for(int i = 0; i < sb.length(); i += current)
            {
                int j;

                if(i + current <= sb.length())
                {
                    j = i + current;
                    Integer result = Integer.parseInt(String.valueOf(sb.substring(i, j)));
                    numbers.add(result);
                }
                else
                {
                    System.out.println("The string provided is not ascending:  false");
                    return false;
                }
            }
            check = checkArray(numbers);

            if(!check)
            {
                numbers.clear();
            }
            else
            {
                System.out.println("The string provided is ascending:  true");
                if(ascendingAndConsecutive(numbers))
                    System.out.println("The string provided is also consecutive. ");
                else
                    System.out.println("The string provided is ascending but not consecutive ");
                return true;
            }
            current++;
        }

        return false;
    }

    public static boolean checkArray(ArrayList<Integer> nums)
    {
        for(int i = 0; i < nums.size(); i++)
        {
            if(i + 1 < nums.size())
            {
                if(nums.get(i) >= nums.get(i + 1))
                    return false;
            }
        }
        return true;
    }

    public static boolean ascendingAndConsecutive(ArrayList<Integer> ascendingNumbers)
    {
        if(checkArray(ascendingNumbers))
        {
            for(int i = 0; i < ascendingNumbers.size(); i++)
            {
                if(i + 1 < ascendingNumbers.size())
                {
                    if(ascendingNumbers.get(i + 1) - ascendingNumbers.get(i) != 1)
                    {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        //test cases for ascending and or consecutive
        ascending("232425");
        ascending("2324256");
        ascending("444445");
        ascending("123456");

        //test cases for square patch
        squarePatch(5);
        System.out.println();
        squarePatch(0);
        System.out.println();
        squarePatch(1);
        System.out.println();
        squarePatch(10);
    }
}
