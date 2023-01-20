import java.util.Random;
import java.util.Scanner;

public class mergeSort
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

    public static void sort(int l, int h)
    {
        int mid;
        if (l < h)
        {
            mid = (l+h)/2;
            sort(l,mid);
            sort(mid+1,h);
            merge(l,mid,h);
        }
    }

    public static void merge(int low, int mid, int high)
    {
        int[] b = new int[MAX];
        int i, h, j, k;
        h = i = low;
        j = mid + 1;
        while ((h <= mid) && (j <= high))
            if (a[h] < a[j])
                b[i++] = a[h++];
            else
                b[i++] = a[j++];
        if (h > mid)
            for (k = j; k <= high; k++)
                b[i++] = a[k];
        else
            for (k = h; k <= mid; k++)
                b[i++] = a[k];
        for (k = low; k <= high; k++)
            a[k] = b[k];
    }
}
