public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        // `curMax` and `curMin` both matter because multiplying by a negative
        // number can flip the sign and turn the smallest product into the largest.
        int curMax = nums[0];
        int curMin = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // Save the next state before overwriting the current one.
            int tempMax = Math.max(num, Math.max(curMax * num, curMin * num));
            int tempMin = Math.min(num, Math.min(curMax * num, curMin * num));

            curMax = tempMax;
            curMin = tempMin;
            // Keep the best product seen anywhere in the array so far.
            answer = Math.max(answer, curMax);
        }

        return answer;
    }

    public static void main(String[] args) {
        // Simple local example so the file can be run directly in VS Code.
        MaximumProductSubarray sol = new MaximumProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.out.println(sol.maxProduct(nums));
    }
}