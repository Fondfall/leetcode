/**
 * 2.
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以0开头
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

/**
 * 1.简单等长，没有进位的情况
 *      public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
 *         ListNode head = new ListNode();
 *         ListNode res = head;
 *         while (true){
 *             res.next = new ListNode(l1.val+ l2.val);
 *             if(l1.next !=null){
 *                 l1 = l1.next;
 *                 l2 = l2.next;
 *                 res = res.next;
 *             }else {
 *                 break;
 *             }
 *         }
 *         return head.next;
 *     }
 *
 * 2.考虑不等长问题
 *      public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
 *         ListNode head = new ListNode();
 *         ListNode res = head;
 *         while (true){
 *             res.next = new ListNode(l1.val+ l2.val);
 *             if(l1.next !=null && l2.next != null){
 *                 l1 = l1.next;
 *                 l2 = l2.next;
 *                 res = res.next;
 *             }else {
 *                 //存在为空
 *                 res.next.next = l1.next == null ? l2.next :l1.next;
 *                 break;
 *             }
 *         }
 *         return head.next;
 *     }
 *
 *3.考虑进位的问题
 * 代码如下
 */
public class AddTwoNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode res = head;
        while (true){
            res.next = new ListNode(l1.val+ l2.val);
            if(l1.next !=null && l2.next != null){
                l1 = l1.next;
                l2 = l2.next;
                res = res.next;
            }else {
                //存在为空
                res.next.next = l1.next == null ? l2.next :l1.next;
                break;
            }

        }
        //进位处理
        res = head;
        while (res != null) {
            if (res.val < 10) {
                res = res.next;
            } else {
                res.val -= 10;
                if (res.next == null) {
                    res.next = new ListNode(1);
                } else {
                    res.next.val += 1;
                }
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5,new ListNode(2,new ListNode(3,new ListNode(3))));
        ListNode l2 = new ListNode(6,new ListNode(3,new ListNode(1,new ListNode(8))));
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
