import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 10
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串
 */
public class IsMatch_10 {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile("^"+p+"$");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }
}
