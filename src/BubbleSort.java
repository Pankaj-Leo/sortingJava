public class BubbleSort {
    // Method to perform Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean madeASwap;
        do {
            madeASwap = false;
            // Traverse the array
            for (int i = 0; i < n - 1; i++) {
                // Swap if the element is greater than the next element
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    madeASwap = true; // A swap was made
                }
            }
            // After each pass, the largest element is in its correct position
            n--; // Reduce the range for the next pass
        } while (madeASwap);
    }

}