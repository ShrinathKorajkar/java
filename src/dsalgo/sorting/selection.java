package dsalgo.sorting;

// Java program for implementation of Selection Sort
class seletion {
    void sort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Prints the array
    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        seletion ob = new seletion();
        int arr[] = { 64, 25, 12, 22, 11 };
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
