import java.util.*;

public class topKElements {

    public class Main {
    public static void main(String[] args) {
        // Example values for nums and k
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 5};
        int k = 2;

        System.out.println("Given nums: " + Arrays.toString(nums));
        System.out.println("Value of k: " + k);

        // Running both solutions
        HeapSolution heapSolution = new HeapSolution();
        BucketSolution bucketSolution = new BucketSolution();

        System.out.println("Heap Solution Output: " + Arrays.toString(heapSolution.topKFrequent(nums, k)));
        System.out.println("Bucket Solution Output: " + Arrays.toString(bucketSolution.topKFrequent(nums, k)));
    }
}

}
class HeapSolution {
    /**
     * Heap-based solution to find the k most frequent elements.
     * Time Complexity: O(n log k), Space Complexity: O(k)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        // Min-Heap to store k most frequent elements
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));


        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (heap.size() < k) {
                heap.offer(new int[]{entry.getValue(), entry.getKey()});
            } else {
                heap.offer(new int[]{entry.getValue(), entry.getKey()});
                heap.poll();
            }
        }

        // Extract k most frequent elements from the heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll()[1];
        }

        return result;
    }
}

class BucketSolution {
    /**
     * Bucket sort-based solution to find the k most frequent elements.
     * Time Complexity: O(n), Space Complexity: O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        // Create buckets where index represents frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(entry.getKey());
        }

        // Collect k most frequent elements starting from highest frequency
        List<Integer> resultList = new ArrayList<>();
        for (int i = nums.length; i >= 0 && resultList.size() < k; i--) {
            if (buckets[i] != null) {
                resultList.addAll(buckets[i]);
            }
        }

        // Convert result to array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}



