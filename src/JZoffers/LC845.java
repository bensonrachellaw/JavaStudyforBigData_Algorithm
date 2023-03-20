package JZoffers;

public class LC845 {
    //数组中的最长山脉或者最长V字型字串的长度（字节）。
    public static void main(String[] args) {

    }
    public int longestMountain(int[] arr) {
        int max = 0;
        int i = 0;
        int n = arr.length;
        int st = -1;
        while(i<n){
            if(i<n-1 && arr[i]<arr[i+1]){
                st = i;
                while (i<n-1 && arr[i]<arr[i+1]){
                    i++;
                }
                if(i==n-1) break;
                if(arr[i]>arr[i+1]){
                    while (i<n-1 && arr[i]>arr[i+1]){
                        i++;
                    }
                    max = Math.max(max,i-st+1);
                    i--;
                }
            }
            i++;
        }
        return max;
    }
}
