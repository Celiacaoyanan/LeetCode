//hashmap contains key(old node) value(new node)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return head;
        RandomListNode dummy=new RandomListNode(0);
        RandomListNode curt1=head;// traverse original linked list
        RandomListNode curt2=dummy;// traverse new linked list
        RandomListNode newNode;
        HashMap<RandomListNode,RandomListNode> nodes=new HashMap<RandomListNode,RandomListNode>();
        while (curt1!=null) {
            if (nodes.containsKey(curt1)) {
                newNode=nodes.get(curt1);
            } else {
                newNode=new RandomListNode(curt1.label);
                nodes.put(curt1,newNode);
            }
            curt2.next=newNode;
            
            if (curt1.random!=null) {
                if (nodes.containsKey(curt1.random)) {
                    newNode.random=nodes.get(curt1.random);
                } else {
                    newNode.random=new RandomListNode(curt1.random.label);
                    nodes.put(curt1.random,newNode.random);
                }
            }
            
            curt1=curt1.next;
            curt2=newNode;
        }
        
        return dummy.next;
    }
}
