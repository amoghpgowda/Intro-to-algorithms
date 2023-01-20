import java.util.Random;
import java.util.Scanner;

public class quickSort
{
    static final int MAX = 10005;
    static int[] a = new int[MAX];
    public static void main(String[] args)
    {
        Scanner o = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = o.nextInt();
        Random r = new Random();
        for (int i = 0; i < n; i++)
        {
            a[i] = r.nextInt(10000);
        }
        System.out.println("Unsorted Array :-");
        for (int i = 0; i < n; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();

        long s = System.nanoTime();
        sort(0,n-1);
        long e = System.nanoTime();

        long T = e - s;
        System.out.println("Sorted Array:-");
        for (int i = 0; i < n; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println("Time complexity for n = " + n + " is " + (double)T/1000000);
        o.close();
    }

    public static void sort(int p,int r)
    {
        int i,j,pivot,temp;
        if (p < r)
        {
            i = p;
            j = r+1;
            pivot = a[p];
            while(true)
            {
                i++;
                while (a[i] < pivot && i < r)
                    i++;
                j--;
                while (a[j] > pivot)
                    j--;
                if (i<j)
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                else
                    break;
            }
            a[p] = a[j];
            a[j] = pivot;
            sort(p,j-1);
            sort(j+1,r);
        }
    }
}
