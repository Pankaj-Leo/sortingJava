public class Main {

    public static void main(String[] args) {
        // Input array to be sorted
        int[] arr = {64, 34, 25, 12, 22, 11, 90, 4};

        System.out.println("Unsorted Array:");
        printArray(arr);

        // Call the bubbleSort method from BubbleSort class
        BubbleSort.bubbleSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }

    // Utility method to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
