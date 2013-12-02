/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.containing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Iva
 */
public class DijkstraAlgorithm
  {
    public static void computePaths(Vertex source)
      {
         source.minDistance = 0.;
          PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
  	vertexQueue.add(source);
  
  	while (!vertexQueue.isEmpty()) {
 	    Vertex u = vertexQueue.poll();

             // Visit each edge exiting u
            for (Edge e : u.adjacencies)
              {
                 Vertex v = e.target;
                  double weight = e.weight;
                  double distanceThroughU = u.minDistance + weight;
 		if (distanceThroughU < v.minDistance) {
 		    vertexQueue.remove(v);
 
 		    v.minDistance = distanceThroughU ;
 		    v.previous = u;
 		    vertexQueue.add(v);
  		}
              }
         }
     }
  
      public static List<Vertex> getShortestPathTo(Vertex target)
      {
          List<Vertex> path = new ArrayList<Vertex>();
         for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
              path.add(vertex);
 
         Collections.reverse(path);
          return path;
    }
    public static void makePath(Vertex a,Vertex b){
        
            computePaths(a);
	    List<Vertex> path = getShortestPathTo(b);
	    System.out.println("Path: " + path);
        
    }
    
 
     public static void main(String[] args)
     {
         
         Points p = new Points();
         makePath(p.CSC5,p.WP7); 

	
    }
 }
