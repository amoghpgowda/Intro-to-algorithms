import java.util.Scanner;
public class dijkstrasAlgorithm
{
    final static int MAX = 20;
    final static int infinity = 9999;
    static int n;
    static int[][] costADJ;
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args)
    {
        readMatrix();
        System.out.print("Enter starting vertex: ");
        int s = scan.nextInt();
        Dijkstras(s);
    }
    static void readMatrix()
    {
        costADJ = new int[MAX][MAX];
        System.out.print("Enter the number of vertices: ");
        n = scan.nextInt();
        System.out.println("Enter the cost adjacency matrix:");
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                costADJ[i][j] = scan.nextInt();
    }
    static void Dijkstras(int s)
    {
        int[] S = new int[MAX];
        int[] d = new int[MAX];
        int u, v, i;
        for (i = 1; i <= n; i++)
        {
            S[i] = 0;
            d[i] = costADJ[s][i];
        }
        S[s] = 1;
        d[s] = 1;
        i = 2;
        while (i <= n)
        {
            u = Extract_Min(S, d);
            S[u] = 1;
            i++;
            for (v = 1; v <= n; v++)
            {
                if ((d[u] + costADJ[u][v] < d[v]) && (S[v] == 0))
                    d[v] = d[u] + costADJ[u][v];
            }
        }
        for (i = 1; i <= n; i++)
            if (i != s)
                System.out.println(i + ":" + d[i]);
    }
    static int Extract_Min(int[] S, int[] D)
    {
        int i, j = 1, min;
        min = infinity;
        for (i = 1; i <= n; i++)
        {
            if ((D[i] < min) && (S[i] == 0))
            {
                min = D[i];
                j = i;
            }
        }
        return (j);
    }
}
