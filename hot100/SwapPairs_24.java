public class SwapPairs_24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode l = null, m = head, r;
        if(head == null){
            return null;
        }else {
            r = head.next;
        }
        while(r != null){
            ListNode temp = r.next;//store
            m.next = r.next;
            r.next = m;
            if(l != null){
                l.next = r;
            }else{
                head = r;
            }
            //移动两格
            l = m;
            m = r;
            r = temp;
            if (r == null){
                break;
            }else{
                m = r;
                r = r.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(swapPairs(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))))));
    }
}
