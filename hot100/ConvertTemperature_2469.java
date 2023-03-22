import java.util.Arrays;

/**
 * 2469
 * 给你一个四舍五入到两位小数的非负浮点数 celsius 来表示温度，以 摄氏度（Celsius）为单位。
 * 你需要将摄氏度转换为 开氏度（Kelvin）和 华氏度（Fahrenheit），并以数组 ans = [kelvin, fahrenheit] 的形式返回结果。
 * 返回数组 ans 。与实际答案误差不超过 10-5 的会视为正确答案。
 * 注意：
 * 开氏度 = 摄氏度 + 273.15
 * 华氏度 = 摄氏度 * 1.80 + 32.00
 */
public class ConvertTemperature_2469 {
    public static double[] convertTemperature(double celsius) {
        double[] res = new double[2];
        res[0] = celsius + 273.15;
        res[1] = celsius * 1.80 + 32;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(convertTemperature(36.50)));
    }
}
