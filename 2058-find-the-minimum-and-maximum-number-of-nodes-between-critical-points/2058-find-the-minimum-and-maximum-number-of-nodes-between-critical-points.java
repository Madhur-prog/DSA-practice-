/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        int pos = 2;
        ArrayList<Integer> critical = new ArrayList<>();

        while (next != null) {

            if ((prev.val < curr.val && curr.val > next.val) ||
                (prev.val > curr.val && curr.val < next.val)) {
                critical.add(pos);
            }

            prev = curr;
            curr = next;
            next = next.next;
            pos++;
        }

        if (critical.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDist = Integer.MAX_VALUE;

        for (int i = 1; i < critical.size(); i++) {
            minDist = Math.min(minDist, critical.get(i) - critical.get(i - 1));
        }

        int maxDist = critical.get(critical.size() - 1) - critical.get(0);

        return new int[]{minDist, maxDist};
    }
}