
package mygame;

/**
 * @author Fons
 */
public class AGV 
{   
    //tuple in twee dimentionale array
    //startPunt   finishPunt
    //(x,,y,z)    (x,y,x)

    
    public static void main(String[] args)
    {
        int x = 0;
        int z = 0;
        //voor de agv's blijft Y op de zelfde hoogte
        int[] startPunt = {x,1,z}; 
        int[] eindPunt = {x,1,z};
        
        
        int[] locArray[][] = {{startPunt, eindPunt}};
        System.out.println(locArray);
    }
    
    
    public void move(int startPoint, int finishPoint)
    {
         
         
    }
    
    public void checkCorners()
    {
        
    }
    
    public void checkOthers()
    {
        
    }
    
    public void pickUpContainer()
    {
        
    }
    
    public void dropContainer()
    {
        
    }        
}
