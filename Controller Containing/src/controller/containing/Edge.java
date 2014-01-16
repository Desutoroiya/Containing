package controller.containing;

/**
 *
 * @author Johan
 * /
 
 /* 
 * This class is used in the creation of the graph. 
 * It is used to link points to each other, 
 * the actual graph however is created in the Points class.
 */
public class Edge {
    
     public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
    
}
