package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraySum {
    public static int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        return sums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(ArraySum.runningSum(nums)));
    }
}
