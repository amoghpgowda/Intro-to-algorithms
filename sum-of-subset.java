import java.util.Scanner;
public class sumOfSubset
{
    final static int MAX = 10;
    static int n;
    static int S[];
    static int solution[];
    static int d;
    public static void main(String args[])
    {
        S = new int[MAX];
        solution = new int[MAX];
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        n = scanner.nextInt();
        System.out.print("Enter the set in increasing order: ");
        for (int i = 1; i <= n; i++)
            S[i] = scanner.nextInt();
        System.out.print("Enter the max. subset value(d): ");
        d = scanner.nextInt();
        for (int i = 1; i <= n; i++)
            sum = sum + S[i];
        if (sum < d || S[1] > d)
            System.out.println("No Subset possible");
        else
            sumOfSubsetAlgorithm(0, 0, sum);
        scanner.close();
    }
    static void sumOfSubsetAlgorithm(int i, int weight, int total)
    {
        if (promising(i, weight, total))
        {
            if (weight == d)
            {
                for (int j = 1; j <= i; j++)
                {
                    if (solution[j] == 1)
                        System.out.print(S[j] + " ");
                }
                System.out.println();
            }
            else
            {
                solution[i + 1] = 1;
                sumOfSubsetAlgorithm(i + 1, weight + S[i + 1], total - S[i + 1]);
                solution[i + 1] = 0;
                sumOfSubsetAlgorithm(i + 1, weight, total - S[i + 1]);
            }
        }
    }
    static boolean promising(int i, int weight, int total)
    {
        return ((weight + total >= d) && (weight == d || weight + S[i + 1] <= d));
    }
}
