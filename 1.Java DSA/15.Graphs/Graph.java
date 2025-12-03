import java.util.*;

public class Graph {
    static class Edge{
        int src;    //source
        int dest;   //destination
        int wt;   //weight

        Edge(int s,int d, int w){
            src = s; dest = d; wt = w;
        }
    }
    
    public static void creatGraph(ArrayList<Edge> graph[]){
        // use for remove null otherwise Nullpointer Exception When not use
        for(int i=0; i<graph.length; i++){
            graph[i] = new Arraylist<Edege>();
        }
        graph[0].
    }

    public static void main(String[] a){
        int V = 4; //vertex
        ArrayList<Edge> graph[] = new ArrayList[V];
        System.out.println(graph);
    }
}
