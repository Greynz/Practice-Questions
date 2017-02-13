/**
 * Created by DrDan on 2/9/2017.
 */
import java.util.*;

public class BreadthFirstSearch {

    private LinkedList<GraphNode> nodes = new LinkedList<>();

    public void test(){
        GraphNode g0 = new GraphNode(0);
        GraphNode g1 = new GraphNode(1);
        GraphNode g2 = new GraphNode(2);
        GraphNode g3 = new GraphNode(3);
        GraphNode g4 = new GraphNode(4);
        GraphNode g8 = new GraphNode(8);

        g0.addEdge(g1);
        g0.addEdge(g3);
        g1.addEdge(g2);
        g1.addEdge(g8);
        g2.addEdge(g3);
        g2.addEdge(g1);
        g3.addEdge(g4);

        BFS(g0);
    }

    public void BFS(GraphNode g){

        LinkedList<GraphNode> q = new LinkedList<>();
        q.add(g);

        while( !q.isEmpty() ){

            GraphNode tmp = q.poll();
            System.out.println(tmp.getV());
            Iterator<GraphNode> i = tmp.getEdges();

            while (i.hasNext()){
                GraphNode n = i.next();
                if (!n.visited) {
                    n.visited = true;
                    q.add(n);
                }
            }

        }

    }

}
