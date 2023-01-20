import java.util.Scanner;
public class kruskalsAlgorithm
{
    final static int MAX = 20;
    static int n;
    static int[][] costADJ;
    static int[] parent=new int[20];
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args)
    {
        readMatrix();
        Kruskals();
    }
    static void readMatrix()
    {
        int i, j;
        costADJ = new int[MAX][MAX];
        System.out.println("Implementation of Kruskal's algorithm");
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
    static void Kruskals() {
        int a = 0, b = 0, u = 0, v = 0, i, j, ne = 1, min, mincost = 0;
        System.out.println("The edges of Minimum Cost Spanning Tree are");
        while (ne < n)
        {
            for (i = 1, min = 999; i <= n; i++)
            {
                for (j = 1; j <= n; j++)
                {
                    if (costADJ[i][j] < min)
                    {
                        min = costADJ[i][j];
                        a = u = i;
                        b = v = j;
                    }
                }
            }
            u = find(u);
            v = find(v);
            if (u != v)
            {
                uni(u, v);
                System.out.println(ne++ + "edge (" + a + "," + b + ") =" + min);
                mincost += min;
            }
            costADJ[a][b] = costADJ[b][a] = 999;
        }
        System.out.println("Minimum cost :" + mincost);
    }
    static int find(int i)
    {
        while (parent[i] != 0)
            i = parent[i];
        return i;
    }
    static void uni(int i, int j)
    {
        parent[j] = i;
    }
}
