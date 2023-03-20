package ExamWY;
import java.util.*;
public class test1 {
    static Map<Integer,Integer> position=new HashMap<>();
    static int res=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] inorder=new int[n];
        int[] postorder=new int[n];
        for(int i=0;i<n;i++){
            inorder[i]=sc.nextInt();
            position.put(inorder[i],i);
        }
        for(int i=0;i<n;i++){
            postorder[i]=sc.nextInt();
        }

        TreeNode root=build(inorder,0,n-1,postorder,0,n-1);
//        dfs01(root);
        dfs(root);
        System.out.println(res);
    }

    public static TreeNode build(int[] inorder,int left1,int right1,int[] postorder,int left2,int right2){
        if(left1>right1){
            return null;
        }
        int index=position.get(postorder[right2]);
        TreeNode root=new TreeNode(postorder[right2]);
        root.left=build(inorder,left1,index-1,postorder,left2,left2+index-1-left1);
        root.right=build(inorder,index+1,right1,postorder,left2+index-left1,right2-1);
        return root;
    }

    public static void dfs01(TreeNode root){
        if(root==null){
            return ;
        }
        System.out.println(root.val);
        dfs01(root.left);
        dfs01(root.right);
    }

    public static int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=0,right=0;
        if(root.left!=null){
            left=dfs(root.left);
        }
        if(root.right!=null){
            right=dfs(root.right);
        }
//        System.out.println("root.val"+root.val);
        res=Math.max(res,left+right);
        return Math.max(left,right)+1;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val=val;
    }
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
