import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int a){
            val=a;
            left=right=null;
        }
}
public class ConstructAllPossibleBSTs {
        public List<TreeNode> construct_BST(int n){
            List<TreeNode> list = new ArrayList<TreeNode>();
            TreeNode root = null;
            for(int i =0;i<=n;i++){
                root = TreeNode(i);

            }
        }

}
