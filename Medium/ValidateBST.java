package Medium;

public class ValidateBST {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        head.left = one;
        head.right = three;

        System.out.println("Is BST valid?: " + isValid(head));

    }

    public static boolean isValid(TreeNode head) {
        return check(head, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean check(TreeNode node, long left, long right) {
        if (node == null)
            return true;
        if (node.val <= left || node.val >= right)
            return false;
        return (check(node.left, left, node.val) && check(node.right, node.val, right));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
