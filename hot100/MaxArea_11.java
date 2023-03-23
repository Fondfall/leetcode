/**
 * 11
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 超时了
 * public class MaxArea_11 {
 *     public int maxArea(int[] height) {
 *         int capacity = 0;
 *         for (int i = 0; i < height.length - 1; i++) {
 *             for (int j = i + 1; j < height.length; j++) {
 *                 int h = Math.min(height[i], height[j]);
 *                 int l = j - i;
 *                 capacity = Math.max(capacity, h * l);
 *             }
 *         }
 *         return capacity;
 *     }
 * }
 */
public class MaxArea_11 {
    //双指针
    public int maxArea(int[] height) {
        int capacity = 0;
        int l = 0, r = height.length - 1;
        while (l < r){
            capacity = Math.max(capacity, (r-l)*Math.min(height[l],height[r]));
            if(height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return capacity;
    }
}
