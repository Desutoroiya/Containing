/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.containing;

/**
 *
 * @author Iva
 */
public class Edge {
    
     public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
    
}
