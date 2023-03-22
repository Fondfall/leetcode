import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class FindMedianSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0, index2 = 0;
        List<Integer> merge = new ArrayList<>();
        int l1 = nums1.length, l2 = nums2.length;
        while (true) {
            if (index1 == l1) {
                //把nums2加入
                while (index2 != l2) {
                    merge.add(nums2[index2++]);
                }
                break;
            }
            if (index2 == l2) {
                //把nums1加入
                while (index1 != l1) {
                    merge.add(nums1[index1++]);
                }
                break;
            }
            if (nums1[index1] < nums2[index2]) {
                merge.add(nums1[index1++]);
            } else {
                merge.add(nums2[index2++]);
            }

        }
        //考虑长度为奇数或偶数
        return (l1 + l2) % 2 != 0 ? merge.get((l1 + l2) / 2)
                : (merge.get((l1 + l2) / 2) + merge.get((l1 + l2) / 2 - 1)) / 2.0;
    }
}
