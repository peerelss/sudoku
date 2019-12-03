package leet.leet_1;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwo {
    public static void main(String[] args) {
        AddTwo a = new AddTwo();
        int[] i1 = {1, 8};
        int[] i2 = {0};
        //  int2List(i1);
        ListNode n = a.addTwoNumbers(int2List(i1), int2List(i2));
        printListNode(n);
    }

    public static ListNode int2List(int[] ints) {
        ListNode listNode = new ListNode(0);
        ListNode l = listNode;
        for (int i : ints) {
            l.next = new ListNode(i);
            l = l.next;
        }
        //   printListNode(listNode.next);
        return listNode.next;
    }

    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "   ");
            node = node.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int tempInt = 0;
        ListNode l1Head = l1, l2Head = l2;
        while (l1Head != null || l2Head != null) {
            if (l1Head == null) {
                l1Head = new ListNode(0);
            }
            if (l2Head == null) {
                l2Head = new ListNode(0);
            }
            l2Head.val = l1Head.val + l2Head.val + tempInt;
            tempInt = 0;
            if (l2Head.val >= 10) {
                l2Head.val = l2Head.val - 10;
                tempInt = 1;
            }
            l1Head = l1Head.next;
            if (l1Head != null && l2Head.next == null) {
                l2Head.next = new ListNode(0);
            }
            l2Head = l2Head.next;
        }
        if (tempInt == 1) {
            l2Head = l2;
            while (l2Head.next != null) {
                l2Head = l2Head.next;
            }
            l2Head.next = new ListNode(1);
        }
        return l2;
    }
}
