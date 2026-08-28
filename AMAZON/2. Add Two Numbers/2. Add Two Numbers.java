class Solution:
   def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
       # We make sure l1 holds the largest number
       curL1 = l1
       curL2 = l2
       while curL1 and curL2:
           curL1 = curL1.next
           curL2 = curL2.next
       
       if curL2 and not curL1:
           l1, l2 = l2, l1
       
       cur = l1
       carry = 0
       while cur:
           result = cur.val + (l2.val if l2 else 0) + carry
           carry = result // 10
           newVal = result % 10

           cur.val = newVal

           # we store prevNode in case we need to add carry in last step
           prevNode = cur
           cur = cur.next
           l2 = l2.next if l2 else None
       
       if carry:
           prevNode.next = ListNode(1)
       
       return l1