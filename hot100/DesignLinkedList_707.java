
class MyLinkedList {
    private LinkNode head;

    public MyLinkedList() {
        head = new LinkNode();
    }

    public int get(int index) {
        int res = -1;
        LinkNode cur = head;
        while(cur != null){
            if(index-- == 0){
                res = cur.val;
                break;
            }else{
                cur = cur.next;
            }
        }
        return res;
    }

    public void addAtHead(int val) {
        if(head.next == null){//初始化
            head.val = val;
            return;
        }
        LinkNode insertNode = new LinkNode();
        insertNode.val = val;
        insertNode.next = head;
        head.prev = insertNode;
        head = insertNode;
    }

    public void addAtTail(int val) {
        LinkNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        LinkNode insertNode = new LinkNode();
        insertNode.val = val;
        insertNode.prev = cur;
        cur.next = insertNode;
    }

    public void addAtIndex(int index, int val) {
        LinkNode cur = head;
        while(cur != null){
            if(index-- == 0){
                //插入
                if(cur == head){
                    addAtHead(val);
                }else{
                    LinkNode insertNode = new LinkNode();
                    insertNode.val = val;
                    //改变指向
                    cur.prev.next = insertNode;
                    insertNode.prev = cur.prev;
                    insertNode.next = cur;
                    cur.prev = insertNode;
                }
                break;
            }else{
                cur = cur.next;
            }
        }
        if(index == 0){//插入末尾
            addAtTail(val);
        }
    }

    public void deleteAtIndex(int index) {
        LinkNode cur = head;
        while(cur != null){
            if(index-- == 0){
                if(cur == head){//首位
                    head = cur.next;
                    if(head != null){//防止只有一个元素下空指针异常
                        head.prev = null;
                    }
                }else if(cur.next == null){//末尾
                    cur.prev.next = null;
                }else{
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                break;
            }else{
                cur = cur.next;
            }
        }
    }
}
class LinkNode{
    int val;
    LinkNode prev;
    LinkNode next;
}

public class DesignLinkedList_707 {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(7);
        obj.addAtHead(2);
        obj.addAtHead(1);
        obj.addAtIndex(3,0);
        obj.deleteAtIndex(2);
        obj.addAtHead(6);
        obj.addAtTail(4);
        int param_1 = obj.get(4);
        System.out.println(param_1);
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */