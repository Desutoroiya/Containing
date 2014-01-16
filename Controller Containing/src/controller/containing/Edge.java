package controller.containing;

/**
 * class.Edge
 * @author Johan
 * /
 
 /* 
 * This class is used in the creation of the graph. 
 * It is used to link points to each other, 
 * the actual graph however is created in the Points class.
 */
public class Edge {
    
     /**
     * Target vertex
     */
    public final Vertex target;
    /**
     * Weight (=length)
     */
    public final double weight;
    /**
     *
     * @param argTarget
     * @param argWeight
     */
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
    
}
