import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 3
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 我的思路：放弃了
 * public static int lengthOfLongestSubstring(String s) {
 *         int maxLen = -1;
 *         int lastRep = 0;//最后一次出现重复的字符的所引
 *         int lastIndex = 0;//倒数第二次出现重复的字符的所引
 *         for (int i = 0; i < s.length(); i++) {
 *             String cur = s.charAt(i)+"";
 *             String before = s.substring(0,i);//扫描的前面那些字符串
 *             if(before.contains(cur)){//如果前置字符串含有当前字符，计算一下长度
 *                 //第一次出现重复，计算头开始的长度
 *                 if(maxLen == -1){
 *                     maxLen = i;//当前字符前面全是满足条件的
 *                 }
 *
 *                 lastIndex = before.lastIndexOf(s.charAt(i));//更新lastIndex索引
 *                 int len;//计算非重复字段的长度
 *                 if(lastRep == 0){
 *                     len = i - lastIndex;
 *                 }else {
 *                     len = i - lastRep + 1;
 *                 }
 *                 if(len > maxLen){
 *                     maxLen = len;//这次得到的更长
 *                 }
 *                 lastRep = i;
 *             }
 *             //如果到达结尾，计算最后这段非重复字符串的长度
 *             if(i == s.length()-1){
 *                 int len = i - lastRep + 1;//包括当前字符，"aab"，2-1+1
 *                 if(len > maxLen){
 *                     maxLen = len;//这次得到的更长
 *                 }
 *             }
 *         }
 *         //空字符串
 *         if(maxLen == -1){
 *             maxLen = s.length();
 *         }
 *         return maxLen;
 *     }
 */
public class LengthOfLongestSubstring_3 {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int right = 0;
        int ans = 0;
        for (int left = 0; left < s.length(); left++) {
            if(left != 0){
                hashSet.remove(s.charAt(left - 1));
            }
            while (right <s.length() && !hashSet.contains(s.charAt(right))){
                hashSet.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans,right-left);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
