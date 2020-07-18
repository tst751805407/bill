package fucking_algorithm;

//快慢指针解决链表，左右指针解决数组
public class 双指针 {
    //定义链表
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    boolean hasCycle_err(ListNode head){
        while (head!=null){
            head=head.next;
        }
        return false;
        //有环就死循环；
    }
    //双指针，一快一慢
    boolean hasCycle(ListNode head) {
        ListNode fast,slow;
        fast=slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow)
                return true;
            //有环
        }
        return false;
    }
    //返回链表中，环的起始位置
    ListNode detectCycle(ListNode head){
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
            //相遇点为k,环内m,头结点到环是k-m，环内剩下k-m
        }
        slow=head;
        while (slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;

    }
    //寻找倒数第K个元素
    ListNode detectlastk(ListNode head,int k){
        ListNode fast, slow;
        fast = slow = head;
        while (k-- > 0)
            fast = fast.next;
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    //二分查找
    int binarySearch(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=(right+left)/2;
            if (nums[mid]==target)
                return mid;
            else if (nums[mid]<target)
                left=mid+1;
            else if (nums[mid]>target)
                right=mid+1;
        }
        return -1;
    }
    //找和
    int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left<right){
            int sum=nums[left]+nums[right];
            if (sum==target){
                return new int[]{left+1,right+1};
            }else if (sum<target){
                left++;
            }else if (sum>target){
                right--;
            }
        }
        return new int[]{-1,-1};
    }
    //翻转数组
    void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=nums[left];
            left++;right--;
        }
    }

}
