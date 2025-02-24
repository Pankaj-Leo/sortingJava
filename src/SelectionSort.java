import java.util.Arrays;

public class SelectionSort {
    // Selection Sort method
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum element
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Main method to test the sorting
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 5};

        System.out.println("Unsorted Array:");
        System.out.println(Arrays.toString(arr));

        // Call the selectionSort method
        selectionSort(arr);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}