import java.util.List;

public interface GraphSystemInterface<NodeType, EdgeType extends Number> extends GraphADT<NodeType, EdgeType> 
{
    public NodeType getNodeData(NodeType data);// gets the nodes data
    public List<NodeType> allNodes(); // All Nodes In graph
    public List<NodeType> leastNodePath(NodeType start, NodeType end); //  creates the path with the least amount of nodes required for reaching end node // acts like a direct flight were cost means nothing
    //public SearchNode computeShortestPath((NodeType start, NodeType end)); //last week's dijkstra method cheapest flight
     public List<NodeType> shortestPathData(NodeType start, NodeType end); //data of the nodes
     public double shortestPathCost(NodeType start, NodeType end) ; //cost of the path
}

