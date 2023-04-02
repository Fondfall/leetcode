import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        //三数求和基础上再套一层for循环，时间复杂度n^3
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int h = 0; h < n - 3; h++){
            if(h != 0 && nums[h] == nums[h - 1]){
                continue;//避免nums[h]重复,for循环会自增
            }
            for(int i = h + 1; i < n - 2; i++){
                if(i != h + 1 && nums[i] == nums[i - 1]){
                    continue;//避免nums[i]重复,for循环会自增
                }
                int j = i + 1, k = n - 1;
                while(j < k){
                    if(j != i + 1 && nums[j] == nums[j - 1]) {
                        j++; continue;//避免nums[j]重复
                    }
                    if(k != n - 1 && nums[k] == nums[k + 1]){
                        k--; continue;//避免nums[k]重复
                    }
                    if((long) nums[h] + nums[i] + nums[j] + nums[k] > target){//值比较
                        k--;
                    }else if((long) nums[h] + nums[i] + nums[j] + nums[k] < target){
                        j++;
                    }else{//匹配成功
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[h]); list.add(nums[i]); list.add(nums[j]); list.add(nums[k]);
                        res.add(list);
                        j++; k--;//继续推进，否则卡在这
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }
}
