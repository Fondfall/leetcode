public class MinSubArrayLen_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        //滑动window
        int l = 0, r = 0;//双指针
        int n = nums.length;
        int ans = n + 1;
        int sum = 0;
        while(l < n){
            if(sum >= target){
                ans = Math.min(ans, r - l);
                sum -= nums[l++];
            }else{
                if(r != n) {
                    sum += nums[r++];
                }else {
                    break;//结束循环
                }
            }

        }
        return ans == n + 1 ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(15,new int[]{5,1,3,5,10,7,4,9,2,8}));
    }
}
