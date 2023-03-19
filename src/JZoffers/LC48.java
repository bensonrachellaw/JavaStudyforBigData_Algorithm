package JZoffers;

/**
 * Description: JavaStudyforBigData
 * Created by L6BD610_Luo on 2022/5/12
 * LC48《旋转图像》:只允许原地修改！
 */
public class LC48 {
    public static void main(String[] args) {

    }
    // 首先进行矩阵转置
    // 再进行中间垂线的镜像对称
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 首先进行矩阵转置,沿主对角线交换（翻转）。主对角线是左上->右下的那条。
        for (int i = 0;i<n;i++){
            for (int j = i + 1;j<n;j++){
                //两个循环其实遍历主对角线上方的全部元素即可，然后与主对角线下方的元素对称交换而已。
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 再进行中间垂线的镜像对称
        int l = 0;//左边
        int r = n-1;//右边
        while(l<r){
            for (int i = 0;i<n;i++){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
            }
            l++;
            r--;
        }
    }
}
