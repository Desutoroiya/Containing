package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.renderer.RenderManager;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;


/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication 
{
    public static void main(String[] args) 
    {
        Main app = new Main();
        app.start();        
    }
    
    @Override
    public void simpleInitApp()
    {  
        cam.setLocation(new Vector3f(0,10,0));
        flyCam.setMoveSpeed(25);

        /** A white, directional light source */ 
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection((new Vector3f(-0.5f, -0.5f, -0.5f)).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun); 

        AmbientLight ambLight = new AmbientLight();
        ambLight.setColor(new ColorRGBA(1f, 1f, 0.8f, 0.2f));
        rootNode.addLight(ambLight);
        
        
        Terrain terrain = new Terrain(assetManager, rootNode); 
        terrain.initTerrain();
        viewPort.setBackgroundColor(ColorRGBA.Blue);      

        AGV agv = new AGV(assetManager);
        agv.CreateAGV();
        agv.setLocalTranslation(4.6f, 0.9f, -19.5f);
        rootNode.attachChild(agv);
        agv.move();
        
        Truck truck = new Truck(assetManager);
        truck.CreateTruck();
        truck.setLocalTranslation(69.5f,0,24f);
        rootNode.attachChild(truck);
        truck.move();
    }    
    
    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
