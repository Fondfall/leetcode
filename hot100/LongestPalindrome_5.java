/**
 * 5.
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class LongestPalindrome_5 {
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        String res = "";
        for (int left = 0; left < s.length(); left++) {
            int right = s.length()-1;
            while (left<=right){
                int l = left,r= right;//指针，用于循环扫面left到right的字符串
                boolean flag = true;
                while (l <= r){
                    if(s.charAt(l) != s.charAt(r)){
                        flag = false;//匹配失败
                        break;
                    }else {
                        l++;r--;
                    }
                }
                if(flag){//匹配成功
                    break;
                }
                right--;
            }
            if(right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                res = s.substring(left, right + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
