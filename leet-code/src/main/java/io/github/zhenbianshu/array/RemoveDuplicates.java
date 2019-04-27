package io.github.zhenbianshu.array;

/**
 * @author zbs 2019/2/22
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[length - 1] == nums[i]) {
                continue;
            }
            nums[length] = nums[i];
            length++;
        }

        return length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 7, 7};
        int length = removeDuplicates(nums);
        System.out.println(length);
        for (int j=0;j<length;j++) {
            System.out.println(nums[j]);
        }
    }
}
