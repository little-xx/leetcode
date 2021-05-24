package devideAndConquer;

/**
 * 求一组数据的逆序对个数
 */
public class MergeSortCount {

    private int num = 0;

    public int count(int a[], int n) {
        mergeSortCounting(a, 0, n - 1);
        return num;
    }

    public void mergeSortCounting(int a[], int s, int e) {
        if (s >= e) return;
        int mid = (s + e) / 2;
        mergeSortCounting(a, s, mid);
        mergeSortCounting(a, mid + 1, e);
        merge(a, s, mid, e);
    }

    public void merge(int a[], int s, int mid, int e) {
        int i = s, j = mid + 1, k = 0;
        int[] newArray = new int[e - s + 1];
        while (i <= mid && j <= e) {
            if (a[i] > a[j]) {
                newArray[k++] = a[j++];
                num += mid - i + 1;
            } else {
                newArray[k++] = a[i++];
            }
        }
        while (i <= mid) {
            newArray[k++] = a[i++];
        }
        while (j <= e) {
            newArray[k++] = a[j++];
        }
        for (i = 0; i < e - s + 1; i++) {
            a[s + i] = newArray[i];
        }
    }
}
