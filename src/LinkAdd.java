public class LinkAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0), top = listNode;
        int flag = 0;
        while (l1 != null || l2 != null){
            if(l1 == null){
                listNode.next = l2.next;
                listNode.val += l2.val + flag;

            }
            else if(l2 == null){
                listNode.next = l1.next;
                listNode.val += l1.val + flag;

            }
            int count = l1.val + l2.val + flag;

            if(count >= 10){
                flag = 1;
                count -= 10;
            }else {
                flag = 0;
            }
            listNode .val = count;

            l1 = l1.next;
            l2 = l2.next;

            if(l1 == null && l2 == null){
                if( flag == 1){
                    listNode.next = new ListNode(1);
                }
                break;
            }
            listNode.next = new ListNode(0);
            listNode = listNode.next;
        }
        System.out.println(top);
        return top;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            if(next != null)
                return ""+val + next.toString();
            else
                return "" + val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(9);
        listNode.next = new ListNode(9);
        //listNode.next.next = new ListNode(5);
        //listNode.next.next.next = new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        //listNode2.next = new ListNode(5);
        new LinkAdd().addTwoNumbers(listNode, listNode2).toString();
    }
}
