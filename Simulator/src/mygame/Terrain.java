package mygame;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Fons
 */
public class Terrain 
{       
    private AssetManager assetManager;
    private Node rootNode;
    
    public static void main(String[] args){        
    } 
    
    public Terrain(AssetManager assetManager, Node rootNode)
    {
        this.assetManager = assetManager;   
        this.rootNode = rootNode;
    }
    
    //Returns a complete terrain with all it's attributes
    public void initTerrain()
    {   
        rootNode.attachChild(loadTerrain());
    }    
    
    /*
     * In total 24 storage cranes on the terrain
     */
    
    
    /*
     * Terrain set on -1 position so every model will be placed on the surface
     */
    public Spatial loadTerrain()
    {
       Spatial terrain = assetManager.loadModel("Models/terrain.j3o");
       terrain.setLocalTranslation(0, -1, 0);
       return terrain;
    }    
    
}

