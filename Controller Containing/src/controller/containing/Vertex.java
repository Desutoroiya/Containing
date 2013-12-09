package controller.containing;

/**
 *
 * @author Johan
 * 
 * This class is used in the calculation of the shortest path, 
 * it doesn't actually calculate but the elements in this class are needed in the DijkstraAlgorithm class. 
 * The name String is the name given to a Vertex in the points class.
 * Edge[] are the points connected to the Vertex, 
 * these can also be seen in the points class.
 * 
 * The other attributes are explained in the DijkstraAlgotrithm class.
 */
public class Vertex implements Comparable<Vertex> {
        
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
    
}
