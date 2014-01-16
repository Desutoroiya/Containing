/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 * class.Container
 * @author Fons
 */
public class Container 
{
    /*
     * Declaring values that are use in Container
     */
    AssetManager assetManager;
    Node rootNode;
    Node contNode = new Node();
    
    /**
     * Container
     * @param assetManager
     * @param rootNode
     */
    public Container(AssetManager assetManager, Node rootNode)
    {
        this.assetManager = assetManager;   
        this.rootNode = rootNode;
    }
    
    /**
     * Creates a container, with Material mat and Color : Random
     */
    public void loadContainer()
    {
        Spatial container = assetManager.loadModel("Models/container.j3o");
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.randomColor());
        container.setMaterial(mat);
        contNode.attachChild(container);
    }
    /**
     * detaches container from vehicle
     * @param container
     * @param vehicle
     */
    public void detachContainer(Node container,Node vehicle){
        vehicle.detachChild(container);
    }
    
    /**
     * attaches container to vehicle
     * @param container
     * @param vehicle
     */
    public void attachContainer(Node container, Node vehicle){
        vehicle.attachChild(container);
    }
}
