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
 *
 * @author Fons
 */
public class Container 
{
    AssetManager assetManager;
    Node rootNode;
    Node contNode = new Node();
    
    public static void main(String[] args){   
    } 

    
    public Container(AssetManager assetManager, Node rootNode)
    {
        this.assetManager = assetManager;   
        this.rootNode = rootNode;
    }
    
    /*
     * 
     */
    public void loadContainer()
    {
        Spatial container = assetManager.loadModel("Models/container.j3o");
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.randomColor());
        container.setMaterial(mat);
        
        //container.setName("hoi");
        contNode.attachChild(container);
    }
    
    /*
     * Get's the container by its type including it's data.
     */
//    public String getContainer()
//    {
//        String cont = container.getName();
//        return cont;
//    }
    

}
