import java.util.Scanner;

public class warshalsAlgorithm
{
    static final int MAX = 20;
    static int[][] costADJ;
    static int n;
    public static void main(String[] args)
    {
        readMatrix();
        warshall();
        printMatrix();
    }
    static void readMatrix()
    {
        costADJ = new int[MAX][MAX];
        System.out.print("Enter the number of vertices: ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println("Enter the Cost Adjacency Matrix (0 for non existing edge) \n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                costADJ[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }
    static void warshall()
    {
        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if((costADJ[i][k]==1 && costADJ[k][j]==1) || (costADJ[i][j]==1))
                        costADJ[i][j]=1;
    }

    static void printMatrix() {
        System.out.println("Transitive closure is:\n");
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
                System.out.print(costADJ[i][j] + "\t");
            System.out.println("\n");
        }
    }
}
