import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * timeout
 * public static List<List<Integer>> threeSum(int[] nums) {
 *         List<List<Integer>> res = new ArrayList<>();
 *         Arrays.sort(nums);
 *         int len = nums.length;
 *         //loop1
 *         for (int i = 0; i < len - 2; i++) {
 *             if (i > 0 && nums[i] == nums[i - 1]) {
 *                 continue;
 *             }
 *             if (nums[i] > 0) break;
 *             //loop2
 *             for (int j = i + 1; j < len - 1; j++) {
 *                 if (j > i + 1 && nums[j] == nums[j - 1]) {
 *                     continue;
 *                 }
 *                 if(nums[i] + nums[j] > 0){
 *                     break;
 *                 }
 *                 //loop3
 *                 //int k = len - 1;
 *                 //while (k > j && ){
 *                 //    k--;
 *                 //}
 *                 for (int k = j + 1; k < len; k++) {
 *                     if (k > j + 1 && nums[k] == nums[k - 1]) {
 *                         continue;
 *                     }
 *                     if (nums[i] + nums[j] + nums[k] == 0) {
 *                         List<Integer> list = new ArrayList<>();
 *                         list.add(nums[i]);
 *                         list.add(nums[j]);
 *                         list.add(nums[k]);
 *                         res.add(list);
 *                         break;
 *                     } else if (nums[i] + nums[j] + nums[k] > 0) {
 *                         break;
 *                     }
 *                 }
 *             }
 *         }
 *         return res;
 *     }
 */

public class ThreeSum_15 {
    /**
     * 先排序后遍历
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        ////官方解答
        //int n = nums.length;
        //Arrays.sort(nums);
        //List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //// 枚举 a
        //for (int first = 0; first < n; ++first) {
        //    // 需要和上一次枚举的数不相同
        //    if (first > 0 && nums[first] == nums[first - 1]) {
        //        continue;
        //    }
        //    // c 对应的指针初始指向数组的最右端
        //    int third = n - 1;
        //    int target = -nums[first];
        //    // 枚举 b
        //    for (int second = first + 1; second < n; ++second) {
        //        // 需要和上一次枚举的数不相同
        //        if (second > first + 1 && nums[second] == nums[second - 1]) {
        //            continue;
        //        }
        //        // 需要保证 b 的指针在 c 的指针的左侧
        //        while (second < third && nums[second] + nums[third] > target) {
        //            --third;
        //        }
        //        // 如果指针重合，随着 b 后续的增加
        //        // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
        //        if (second == third) {
        //            break;
        //        }
        //        if (nums[second] + nums[third] == target) {
        //            List<Integer> list = new ArrayList<Integer>();
        //            list.add(nums[first]);
        //            list.add(nums[second]);
        //            list.add(nums[third]);
        //            ans.add(list);
        //        }
        //    }
        //}
        //return ans;

        // 再次尝试
        //双指针，n^2时间复杂度
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;//避免nums[i]重复
            }
            int j = i + 1, k = n - 1;
            while(j < k){
                if(j != i + 1 && nums[j] == nums[j - 1]) {
                    j++; continue;//避免nums[j]重复
                 }
                if(k != n - 1 && nums[k] == nums[k + 1]){
                    k--; continue;//避免nums[k]重复
                }
                if(nums[j] + nums[k] > -nums[i]){//值比较
                    k--;
                }else if(nums[j] + nums[k] < -nums[i]){
                    j++;
                }else{//匹配成功
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[j]); list.add(nums[k]);
                    res.add(list);
                    j++; k--;//继续推进，否则卡在这
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43,
                57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82,
                76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49}));
        //System.out.println(threeSum(new int[]{-1, -1, 1, 0}));
    }
}
