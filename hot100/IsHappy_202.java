import java.util.HashSet;

public class IsHappy_202 {
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            String numStr = n + "";
            int numLen = numStr.length();
            int sum = 0;
            for (int i = 0; i < numLen; i++){
                int num = Integer.parseInt(numStr.charAt(i) + "");
                sum += num * num;
            }
            if((n = sum) == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
