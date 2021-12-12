package ru.job4j.array;

public class RightShift {

    public static void shift(int[] nums, int count) {
        for (int i = 0; i < count; i++) {
            shift(nums);
        }
    }

    public static void shift(int[] nums) {
        int size = nums.length;
        int tmp = nums[size - 1];
        for (int i = size - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = tmp;
    }
}
