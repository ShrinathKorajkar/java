package dsa_apnacollege.heaps;

/*
    HEAP SORT
    inplace(no extra space) unstable(preserve order in similar element) algo

    heapify :- process of creating heap ds and reprenseting it in array
    HEAP DS :- Complete Bin Tree, max heap (parent is larger than children)
    complete bin tree :- all levels filled, leaf level is filled from left(can be half empty)

    heap sort :- remove max (send it at last), heapify rest
    non leaf nodes - n / 2 - 1          children - (n * 2) + 1, + 2
    N log(N)    O(1)
*/
public class HeapSort {

    // Bottom Up approach
    static void heapify(int arr[], int N, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < N && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < N && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, N, largest);
        }
    }

    // using max heap
    static void sort(int arr[]) {
        System.out.println("Before");
        printArray(arr);

        System.out.println("Heap Ds");
        int N = arr.length;
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);
        }
        printArray(arr);

        System.out.println("After sort");
        for (int i = N - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        printArray(arr);
    }

    static void printArray(int arr[]) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        sort(arr);
    }
}
