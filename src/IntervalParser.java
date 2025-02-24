import java.util.*;

class MergeIntervals{
    public List <int []> merge (int [][] intervals){
        if (intervals.length == 0) return new ArrayList<>();

        //Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int []> merged = new ArrayList<>();

        for (int[] interval : intervals){
            //if merged is empty or current interval does not overlap with last merged interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                //Merge intervals by updating the end time
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }

        }
        return merged;
    }
}

class InPlaceMergeIntervals {
    /** Merges overlapping intervals in-place with O(1) extra space. */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];

        // Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0; // Index to track merged intervals

        for (int j = 1; j < intervals.length; j++) {
            // If current interval overlaps with previous one, merge
            if (intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            } else {
                i++;
                intervals[i] = intervals[j]; // Move to next non-overlapping interval
            }
        }

        return Arrays.copyOf(intervals, i + 1); // Return only the merged portion
    }
}

public class IntervalParser {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        //Prompt the user for input
//
//        System.out.println("Enter the intervals as space seperated (eg: 1 3 5 7 19):");
//        String input = scanner.nextLine();
//
//        //Convert input string into an integer list
//        String[] tokens = input.split(" "); //Split by spaces
//        List<Integer> intervalInput = new ArrayList<>();
//
//        for (String token : tokens) {
//            intervalInput.add(Integer.parseInt(token)); //Convert to integers`
//        }
//
//        // Convert flat list to interval pairs
//        int[][] intervals = new int[intervalInput.size() / 2][2];
//        for (int i = 0; i < intervalInput.size(); i += 2) {
//            if (i + 1 < intervalInput.size()) { // Ensure a valid pair
//                intervals[i / 2] = new int[]{intervalInput.get(i), intervalInput.get(i + 1)};
//            }
//        }

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        // Running both solutions
        MergeIntervals mergeSolution = new MergeIntervals();
        InPlaceMergeIntervals inPlaceSolution = new InPlaceMergeIntervals();

        System.out.println("\nOriginal Intervals: " + formatIntervals(intervals));

        // Calling MergeIntervals (Extra Space)
        List<int[]> mergedOutput1 = mergeSolution.merge(intervals);
        System.out.println("\nMergeIntervals Output: " + formatIntervals(mergedOutput1));

        // Calling InPlaceMergeIntervals (In-Place Optimization)
        int[][] mergedOutput2 = inPlaceSolution.merge(intervals);
        System.out.println("\nInPlaceMergeIntervals Output: " + formatIntervals(mergedOutput2));

//        scanner.close();


    }

    // Helper method to format intervals for output
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

    // Overloaded helper method for array formatting
    private static String formatIntervals(int[][] intervals) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < intervals.length; i++) {
            sb.append(Arrays.toString(intervals[i]));
            if (i < intervals.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}