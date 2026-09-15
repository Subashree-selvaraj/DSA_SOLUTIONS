import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // Count frequencies
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // bucket[i] contains numbers appearing i times
        List<Integer>[] bucket = new List[n + 1];

        for (int num : frequency.keySet()) {
            int freq = frequency.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        // Collect from highest frequency to lowest
        int[] result = new int[k];
        int index = 0;

        for (int freq = n; freq >= 1 && index < k; freq--) {
            if (bucket[freq] == null) {
                continue;
            }

            for (int num : bucket[freq]) {
                result[index++] = num;

                if (index == k) {
                    break;
                }
            }
        }

        return result;
    }
}