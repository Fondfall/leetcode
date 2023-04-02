import java.util.ArrayList;
import java.util.List;

/**
 * 17
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations_17 {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<List<String>> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        if(len == 0) return new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(transfer(digits.charAt(i)+""));
        }
        for (int i = 0; i < list.size(); i++) {

        }

        return null;
    }

    public static List<String> transfer(String number){
        Integer num = Integer.parseInt(number);
        List<String> res = new ArrayList<>();
        if(num > 9 || num < 2){
        }
        if(num <= 6){
            res.add((char)('a' +(num - 2) * 3) +"");
            res.add((char)('b' +(num - 2) * 3) +"");
            res.add((char)('c' +(num - 2) * 3) +"");
        }
        if(num == 7){
            res.add('p'+"");
            res.add('q'+"");
            res.add('r'+"");
            res.add('s'+"");
        }
        if(num == 8){
            res.add('t'+"");
            res.add('u'+"");
            res.add('v'+"");
        }
        if(num == 9){
            res.add('w'+"");
            res.add('x'+"");
            res.add('y'+"");
            res.add('z'+"");
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(transfer("6"));
    }
}
