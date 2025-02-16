public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next =n2;
        n2.next =n3;
        ListNode n = n1;
        while(n!=null){
            System.out.println("Node: "+n.val);
            n=n.next;
        }
        n = reverse(n1);
        System.out.println("Reversed");
        while(n!=null){
            System.out.println("Node: "+n.val);
            n=n.next;
        }
    }

    public static ListNode reverse(ListNode head){
        ListNode curNode = head,prev=null;
        while(curNode!=null){
            ListNode nn=curNode.next;
            curNode.next=prev;
            prev=curNode;
            curNode=nn;  
        }
        head=prev;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
