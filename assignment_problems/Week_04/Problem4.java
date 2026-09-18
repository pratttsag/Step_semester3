import java.util.HashMap;

public class Problem4 {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        // Empty prefix sum
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum = currentSum + num;

            // Check if an earlier prefix sum exists
            int requiredSum = currentSum - k;

            if (prefixSumCount.containsKey(requiredSum)) {
                count = count + prefixSumCount.get(requiredSum);
            }

            // Store current prefix sum
            prefixSumCount.put(
                currentSum,
                prefixSumCount.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println(result);
    }
}