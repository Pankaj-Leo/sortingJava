import java.util.*;

public class InsertInterval {

    public List<int[]> insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0, n = intervals.length;

        // Step 1: Add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        merged.add(newInterval); // Add the merged interval

        // Step 3: Add remaining intervals after newInterval
        while (i < n) {
            merged.add(intervals[i]);
            i++;
        }

        return merged;


    }

    // Helper function to format intervals for output
    private static String formatIntervals(List<int[]> intervals) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < intervals.size(); i++) {
            sb.append(Arrays.toString(intervals.get(i)));
            if (i < intervals.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();

        // Test case 1
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        System.out.println("Merged Intervals: " + formatIntervals(solution.insert(intervals1, newInterval1)));
        // Output: [[1, 5], [6, 9]]

        // Test case 2
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        System.out.println("Merged Intervals: " + formatIntervals(solution.insert(intervals2, newInterval2)));
        // Output: [[1, 2], [3, 10], [12, 16]]

    }
}




