/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) return null;
        
        ArrayList<UndirectedGraphNode> nodes=new ArrayList<>();//record old nodes
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<>();//key is old node, value is new node
        
        nodes.add(node);
        map.put(node,new UndirectedGraphNode(node.label));
        
        //store new nodes in HashMap
        int start=0;
        while (start<nodes.size()) {
            UndirectedGraphNode head=nodes.get(start);
            start++;
            for (int i=0;i<head.neighbors.size();i++) {
                UndirectedGraphNode neighbor=head.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor,new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }
        
        //create new nodes and their neighbors
        for (int i=0;i<nodes.size();i++) {
            UndirectedGraphNode newNode=map.get(nodes.get(i));
            for (int j=0;j<nodes.get(i).neighbors.size();j++) {                
                newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }
        return map.get(node);
    }
}
