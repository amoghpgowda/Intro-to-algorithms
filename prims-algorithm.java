import java.util.Scanner;

public class primsAlgorithm
{
    final static int MAX = 20;
    static int n;
    static int[][] costADJ;
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args)
    {
        readMatrix();
        Prims();
    }
    static void readMatrix()
    {
        int i, j;
        costADJ = new int[MAX][MAX];
        System.out.println("Implementation of prims's algorithm");
        System.out.print("Enter the no. of vertices: ");
        n = scan.nextInt();
        System.out.println("Enter the cost adjacency matrix");
        for (i = 1; i <= n; i++)
        {
            for (j = 1; j <= n; j++)
            {
                costADJ[i][j] = scan.nextInt();
                if (costADJ[i][j] == 0)
                    costADJ[i][j] = 999;
            }
        }
    }
    static void Prims()
    {
        int[] visited = new int[10];
        int ne = 1, i, j, min, a = 0, b = 0, u = 0, v = 0;
        int mincost = 0;
        visited[1] = 1;
        while (ne < n)
        {
            for (i = 1, min = 999; i <= n; i++)
                for (j = 1; j <= n; j++)
                    if (costADJ[i][j] < min)
                        if (visited[i] != 0)
                        {
                            min = costADJ[i][j];
                            a = u = i;
                            b = v = j;
                        }
            if (visited[u] == 0 || visited[v] == 0)
            {
                System.out.println("Edge" + ne++ + ":(" + a + "," + b + ")" + "cost:" + min);
                mincost += min;
                visited[b] = 1;
            }
            costADJ[a][b] = costADJ[b][a] = 999;
        }
        System.out.println("\n Minimun cost" + mincost);
    }
}
