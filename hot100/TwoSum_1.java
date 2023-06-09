import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 
 * 利用hash表的特性
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int index0 = map.get(target - nums[i]);
                return new int[]{index0, i};
            }
            map.put(nums[i], i);
        }
        return null;

    }

    public static void main(String[] args) {
        TwoSum_1 solution = new TwoSum_1();
        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15, 9}, 9);
        System.out.println(Arrays.toString(ints));
    }
}
