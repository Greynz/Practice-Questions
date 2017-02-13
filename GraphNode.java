/**
 * Created by DrDan on 2/9/2017.
 */
import java.util.*;

public class GraphNode {

    public boolean visited = false;
    private int v;
    private LinkedList<GraphNode> adjacent = new LinkedList<>();


    public GraphNode(int V){
        v = V;
    }

    public int getV(){
        return v;
    }

    public void addEdge(GraphNode g){
        adjacent.add(g);
    }

    public Iterator<GraphNode> getEdges(){
        return adjacent.listIterator();
    }


}
