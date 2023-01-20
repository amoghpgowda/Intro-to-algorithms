import java.util.Scanner;

public class floydsAlgorithm
{
    static final int MAX = 20;
    static int[][] costADJ;
    static int n;
    public static void main(String[] args)
    {
        readMatrix();
        Floyds();
        printMatrix();
    }
    static void readMatrix()
    {
        costADJ = new int[MAX][MAX];
        System.out.print("Enter the number of vertices: ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println("Enter the Cost Adjacency Matrix (999 for infinity) \n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                costADJ[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }
    static void Floyds()
    {
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if ((costADJ[i][k] + costADJ[k][j]) < costADJ[i][j])
                        costADJ[i][j] = costADJ[i][k] + costADJ[k][j];
    }
    static void printMatrix() {
        System.out.println("The All Pair Shortest Path Matrix is:\n");
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
                System.out.print(costADJ[i][j] + "\t");
            System.out.println("\n");
        }
    }
}

