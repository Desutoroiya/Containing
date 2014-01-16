package controller.containing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * class.Dijkstra
 * @author Johan
 */
public class DijkstraAlgorithm 
  {
    /**
     * Method that computes the shortest path based on 
     * the weight that is given to each Vertex.
     * @param source
     */
    public static void computePaths(Vertex source)
      {
         source.minDistance = 0.;
          PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
  	vertexQueue.add(source);
        
        /*
         * While the priority queue isn't empty, the head of the queue gets placed in Vertex u.
         */
  
  	while (!vertexQueue.isEmpty()) {
 	    Vertex u = vertexQueue.poll();

             /*
              * Visit each edge connected to Vertex u.
              * your target edge gets placed in Vertex v 
              * and your target weight gets placed in double weight.
              */
            for (Edge e : u.adjacencies)
              {
                 Vertex v = e.target;
                  double weight = e.weight;
                  double distanceThroughU = u.minDistance + weight;
                  /*
                   * If distanceThroughU is less than your target distance,
                   * the target gets removed from the queue.
                   * the target minDistance becomes the previous minDistance, 
                   * and the previous Vertex you were at gets placed in Vertex v previous.
                   * It than gets added to the queue.
                   * It will keep doing this till it has reached the target given by the user, 
                   * with the lowest weight of course.
                   * 
                   */
 		if (distanceThroughU < v.minDistance) {
 		    vertexQueue.remove(v);
 
 		    v.minDistance = distanceThroughU ;
 		    v.previous = u;
 		    vertexQueue.add(v);
  		}
              }
         }
     }
      /**
       * The list that is used to save all the points in the path.
       * At the end the path is reversed to secure that it's in the right order,
       * after that the list path is returned.
     * @param target
     * @return
     */
    public static List<Vertex> getShortestPathTo(Vertex target)
      {
          List<Vertex> path = new ArrayList<Vertex>();
         for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
              path.add(vertex);
 
         Collections.reverse(path);
          return path;
    }
    /**
     *
     */
    public DijkstraAlgorithm(){
        
    }
    /**
     * Method that gives a path based on the vehicle it gets from the xml-reader.
     * @param a
     */
    public void makePath(String a){
        
        Points p = new Points(); 
        
        /*
         * If the string equals one of the four vehicle it will create a path.
         * The starting point is where the AGV is standing and the end point is
         * the first crane for the chosen vehicle.
         */
        if(a.equals("zeeschip")){
                
                computePaths(p.WP8);
                List<Vertex> path = getShortestPathTo(p.CSC1);
                System.out.println("Path: " + path);
                
            }
        if (a.equals("vrachtauto")){
            
                computePaths(p.WP8);
                List<Vertex> path = getShortestPathTo(p.TCC1);
                System.out.println("Path: " + path);
            
        }
        if (a.equals("trein")){
            
                computePaths(p.WP8);
                List<Vertex> path = getShortestPathTo(p.TC1);
                System.out.println("Path: " + path);
            
        }
        if (a.equals("binnenschip")){
            
                computePaths(p.WP8);
                List<Vertex> path = getShortestPathTo(p.BC1);
                System.out.println("Path: " + path);
            
        }
    }
    
 }
