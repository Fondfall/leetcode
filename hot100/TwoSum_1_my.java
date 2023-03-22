/**
*思路分析：
*1.先找到target在nums中所处的位置，搜索时只找该索引前面的数，
比如nums = [2,7,11,15], target = 9，index = 1
*2.for循环i，j
i从0到index-1，j从index到i+1
*3.如果[i]+[j]<target，退出当次循环，i+1
4.直到匹配成功

*思路分析2：不是有序数组
*1.for循环i，j
i从0到len-1，j从len-1到i+1
*2.[i]+[j]==target

 */

public class TwoSum_1_my {
    public int[] twoSum(int[] nums, int target) {
        /*
        int index = nums.length - 1;
        int[] result = new int[]{0, 1};
        //1.找到target对应的位置
        for(int i = 0; i < nums.length; i++){
            if(target < nums[i]){
                index = i - 1;
                break;
            }
        }
        if(index == 1){
            return result;
        }
        //2.循环查找
        for(int i = 0; i < index; i++){
            for(int j = index; j > i; j--){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }else if(nums[i] + nums[j] < target){
                    break;
                }
            }

        }
        return result;
        */
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = nums.length-1; j > i; j--){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }

        }
        return result;
    
    }
}
