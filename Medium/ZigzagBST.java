package Medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagBST {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        head.left = nine;
        head.right = twenty;
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        twenty.left = fifteen;
        twenty.right = seven;

        System.out.println("Zigzag print BST: " + zigzagPrint(head));

    }

    private static List<List<Integer>> zigzagPrint(TreeNode head) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean rotate=false;
        if(head==null)
            return ans;
        q.add(head);
        while(!q.isEmpty()){
            //take the count of nodes in queue
            int count = q.size();
            List<Integer> sub = new LinkedList<>();
            //run a for loop that many times to get its all siblings
            for (int i = 0; i < count; i++) {
                //Get the current node from queue
                TreeNode node = q.peek();
                //check its left and right subtrees and store in queue
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                //remove the peeked element from queue and add to sublist of answer
                sub.add(q.poll().val);
            }
            rotate=!rotate;
            if(!rotate){
                Collections.reverse(sub);
            }
            ans.add(sub);
        }
        return ans;

    }

}
