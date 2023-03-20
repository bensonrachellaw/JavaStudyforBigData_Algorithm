package ExamShein_QZ;
import java.util.*;

/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/8/25
 * 在有序数组中使用递归找到目标元素，二分法，输出元素下标和查找次数。题目说：如果数组长度为偶数，
 */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        int[] arr = { 1, 2, 3, 4, 5 };
        printArray(intArray);
//        printArray(arr);
        System.out.println();
    }
    public String binSearch (int[] arr , int key) {
        return binSearch1(arr,key,1,0,arr.length-1);
    }
    public String binSearch1 (int[] arr, int key,int cnt,int l,int r) {
        if (l>r) return "";
        int mid = (l+r)>>1;
        if (arr[mid] == key) {
            return "\""+mid + "," + cnt + "\"";
        }
        if (key<=arr[mid]) {
            return binSearch1(arr,key,cnt+1,l,mid-1);
        }
        else {
            return binSearch1(arr,key,cnt+1,mid+1,r);
        }
    }
    // 泛型方法 printArray 不能是基本数据类型
    public static < E > void printArray( E[] inputArray )
    {
        // 输出数组元素
        for ( E element : inputArray ) {
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }
}


