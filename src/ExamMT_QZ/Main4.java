package ExamMT_QZ;
import java.util.*;
public class Main4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int k = reader.nextInt();
        int[] num = new int[n+1];
        int[] tag = new int[n+1];
        Arrays.fill(tag,0);
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1;i<=100;i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 1;i<=n;i++) {
            int temp = reader.nextInt();
            num[i] = temp;
            map.get(temp).add(i);
        }
        for (int i = 1;i<=100;i++) {
            if (map.get(i).size()!=0) {
                int mid;
                if (map.get(i).size()%2==1){
                    mid = map.get(i).size()/2+1;
                }
                else {
                    mid = map.get(i).size()/2;
                }
                for (int j = 0;j<mid;j++) {
                    tag[map.get(i).get(j)] = 1;
                }
            }
        }
        for (int i = 1;i<=n;i++) {
            if (tag[i]==1) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
        for (int i = 1;i<=n;i++) {
            if (tag[i]==0) {
                System.out.print(i+" ");
            }
        }
    }
}
