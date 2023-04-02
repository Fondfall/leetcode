public class RemoveElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0, head);
        ListNode temp = res;//指针，操作链表
        while(temp.next != null){
            if(temp.next.val == val){//删除下一个节点
                if(temp.next.next == null){
                    temp.next = null;
                    break;//防止空指针异常
                }else{
                    temp.next = temp.next.next;
                }
            }
            temp = temp.next;
        }
        return res.next;
    }
    //class ListNode {
    //    int val;
    //    ListNode next;
    //    ListNode() {}
    //    ListNode(int val) { this.val = val; }
    //    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    //}

    public static void main(String[] args) {
        RemoveElements_203 entity = new RemoveElements_203();
        //System.out.println(entity.removeElements(new ListNode(1, new ListNode(2, new ListNode(6,
        //        new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))), 6));
        System.out.println(entity.removeElements(new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7)))), 7));
    }
}



