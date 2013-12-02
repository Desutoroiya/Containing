/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.bounding.BoundingBox;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.debug.Grid;

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
        rootNode.attachChild(loadContainer());
        int z = -26;
        for(int i = 0; i < 10; i++)
        {
                rootNode.attachChild(loadContainerCrane(z));
                z = z + 6;

        }

    }    
    
    public Node loadContainerCrane(int z)
    {
        float x = -77.0f;
        float y = 1;
        
        Spatial craneBase_model = assetManager.loadModel("Models/craneBase.j3o");
        Spatial cCraneLift_model = assetManager.loadModel("Models/cCraneLift.j3o");
        Spatial cCraneHook_model = assetManager.loadModel("Models/cCraneHook.j3o");
        /* This quaternion stores a 90 degree rolling rotation */ 
        Quaternion roll90 = new Quaternion(); 
        roll90.fromAngleAxis( -FastMath.PI/2 , new Vector3f(0,1,0) ); 
        /* The rotation is applied: The object rolls by 90 degrees. */ 
        craneBase_model.setLocalRotation( roll90 );
        craneBase_model.scale(0.5f);
        craneBase_model.setLocalTranslation(x, y, z);        
        
        cCraneLift_model.setLocalRotation( roll90 );
        cCraneLift_model.scale(0.5f);
        cCraneLift_model.setLocalTranslation(x, y, z);
                
        cCraneHook_model.setLocalRotation( roll90 );
        cCraneHook_model.scale(0.5f);
        cCraneHook_model.setLocalTranslation(x, y, z);       
        
        Node containerCrane = new Node();
        containerCrane.attachChild(craneBase_model);
        containerCrane.attachChild(cCraneLift_model);
        containerCrane.attachChild(cCraneHook_model);
        
        return containerCrane; 
    }
    
    public Spatial loadTerrain()
    {
        Spatial statTerrain = assetManager.loadModel("Models/statTerrain.j3o");
        statTerrain.setLocalTranslation(0, 0, 0);        
        return statTerrain;
    }    
    
    public Spatial loadContainer()
    {
        Spatial container = assetManager.loadModel("Models/container.j3o");
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        container.setMaterial(mat);
        return container;
    }
    
    private Geometry attachGrid(Vector3f pos, int sizez, int sizex, ColorRGBA color)
    {
        Geometry g = new Geometry("wireframe grid", new Grid(sizez, sizex, 0.25f) );
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.getAdditionalRenderState().setWireframe(true);
        mat.setColor("Color", color);
        g.setMaterial(mat);
        g.center().move(pos);
        rootNode.attachChild(g);
        return g;

  }
    
}

