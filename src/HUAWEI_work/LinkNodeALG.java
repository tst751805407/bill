package HUAWEI_work;

public class LinkNodeALG {
    class ListNode {
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }


    }
    public ListNode reverseList(ListNode head) {

        // 正确性判断
        if (null == head || null == head.next) {
            return head;
        }

        ListNode pre = null;
        while (null != head) {
            ListNode temp = head;
            head = head.next;
            temp.next = pre;
            pre = temp;
        }

        return pre;
    }
    public static int binSearch(int srcArray[], int key) {
        int mid;
        int start = 0;
        int end = srcArray.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < srcArray[mid]) {
                end = mid - 1;
            } else if (key > srcArray[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String args[]){

    }
}
