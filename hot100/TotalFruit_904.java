import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TotalFruit_904 {
    public static int totalFruit(int[] fruits) {
        //思路：滑动窗口法
        //1. 定义左指针和右指针l和r，初始值为0
        //2.当l~r之间只有一个种类时，r++，当超过2个种类时，l++直至有两个种类

        int sum = 0;//save result
        int l = 0, r = 0;
        HashSet set = new HashSet();
        int n = fruits.length;//length

        while(l < n){
            if(set.size() <= 2){
                if(r != n){//防止越界
                    set.add(fruits[r++]);
                    if(set.size() <= 2) {
                        sum = Math.max(sum, r - l);
                    }
                }else{
                    break;
                }
            }else{//left pointer move to right
                set = new HashSet();
                l = r - 1;//from behind to front
                while(set.size() <= 2){
                    set.add(fruits[l--]);
                }
                set.remove(fruits[l + 1]);
                l = l + 2;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
