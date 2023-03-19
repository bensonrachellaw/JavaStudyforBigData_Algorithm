package ExamTME_QZ;
import java.util.*;
/**
 * Description: JavaStudyforBigData (2)
 * Created by L6BD610_Luo on 2022/9/8
 * 或者不在递归中取余，直接用long然后再最后返回答案时取一次余即可。
 */
public class Main3 {
    public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;
     public TreeNode(int val) {
       this.val = val;
      }
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<TreeNode> list = new ArrayList<>();
        System.out.println();
    }
    static int mod = 1000000007;
    public static int getTreeSum (TreeNode tree) {
        // write code here
        return dfs(tree) % mod;
    }
    public static int dfs (TreeNode tree) {
        // write code here
        if (tree.left == null && tree.right == null) {
            tree.val = 1;
            return 1;
        }
        int l = dfs(tree.left)% mod;
        int r = dfs(tree.right)% mod;

        tree.val = 1;
        int ans = Math.max(l,r) % mod;
        return (tree.val + ans + ans)%mod;
    }
}
