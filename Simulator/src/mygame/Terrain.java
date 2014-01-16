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
 * class.Terrain
 * @author Fons
 */
public class Terrain 
{       
    private AssetManager assetManager;
    private Node rootNode;

    /**
     * Terrain
     * @param assetManager
     * @param rootNode
     */
    public Terrain(AssetManager assetManager, Node rootNode)
    {
        this.assetManager = assetManager;   
        this.rootNode = rootNode;
    }
    
    /**
     * loads the terrain
     */
    public void initTerrain()
    {   
        rootNode.attachChild(loadTerrain());
    }    
    
    /**
     * load terrain at y = -1 so every model will be placed on surface (=0)
     * @return
     */
    public Spatial loadTerrain()
    {
       Spatial terrain = assetManager.loadModel("Models/terrain.j3o");
       terrain.setLocalTranslation(0, -1, 0);
       return terrain;
    }    
    
}

