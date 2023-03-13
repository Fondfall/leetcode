/**
* 利用hash表的特性
*/
class Solution {
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
        Solution solution = new Solution();
        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15, 9}, 9);
        System.out.println(Arrays.toString(ints));
    }
}
