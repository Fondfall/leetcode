public class MySqrt_69 {
    public static int mySqrt(int x) {
        int left = 0, right = x;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid * mid == x){
                return mid;
            }
            long y = (long)mid * (long)mid;
            if((long)mid * (long)mid > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
