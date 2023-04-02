import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix[0].length;//长度
        int n = matrix.length;//宽度
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while(m > 1 && n > 1){//内圈至少有两行两列
            for(int l = 0; l < m - 1; l++){//向右
                res.add(matrix[i][j++]);
            }
            for(int l = 0; l < n - 1; l++){//向下
                res.add(matrix[i++][j]);
            }
            for(int l = 0; l < m - 1; l++){//向左
                res.add(matrix[i][j--]);
            }
            for(int l = 0; l < n - 1; l++){//向上
                res.add(matrix[i--][j]);
            }
            i++; j++;//一圈之后回到原始位置，调整位置到内圈
            m-=2; n-=2;
        }
        if(m == 1){
            for(int l = 0; l < n; l++){//竖排遍历
                res.add(matrix[i++][j]);
            }
        }else if(n == 1){//横排遍历n=1
            for(int l = 0; l < m; l++){
                res.add(matrix[i][j++]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}}));
    }
}
