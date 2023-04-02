import java.util.Arrays;

public class GenerateMatrix_59 {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0, j = 0;
        int center_i, center_j;//中心点的坐标
        if(n % 2 == 0){
            center_i = n / 2;
            center_j = n / 2 - 1;
        }else{
            center_i = (n - 1) / 2;
            center_j = center_i;
        }
        int num = 1;
        int dire = 0;
        while(true){
            if(i == center_i && j == center_j){
                matrix[i][j] = num;
                break;
            }else{
                matrix[i][j] = num++;
            }
            if(dire == 0){//向右
                if(j == n - 1 || matrix[i][j + 1] != 0){
                    dire = 1;
                    i++;
                }else{
                    j++;
                }
            }else if(dire == 1){//向下
                if(i == n - 1 || matrix[i + 1][j] != 0){
                    dire = 2;
                    j--;
                }else{
                    i++;
                }
            }else if(dire == 2){//向左
                if(j == 0 || matrix[i][j - 1] != 0){
                    dire = 3;
                    i--;
                }else{
                    j--;
                }
            }else if(dire == 3){//向上
                if(i == 0 || matrix[i - 1][j] != 0){
                    dire = 0;
                    j++;
                }else{
                    i--;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(10);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
