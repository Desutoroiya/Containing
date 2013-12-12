package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.renderer.RenderManager;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;

/**
 * test
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        cam.setLocation(new Vector3f(0, 10, 0));
        flyCam.setMoveSpeed(25);

        /**
         * A white, directional light source
         */
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
        truck.setLocalTranslation(69.5f, 0, 24f);
        rootNode.attachChild(truck);
        truck.move();

        Truck truc = new Truck(assetManager);
        truc.CreateTruck();
        truc.setLocalTranslation(69.5f, 0, 24f);
        rootNode.attachChild(truc);


        Train train = new Train(assetManager);
        train.createTrain();
        train.setLocalTranslation(-63, 0.1f, -28);
        rootNode.attachChild(train);


        /*
         * Truck cranes maken
         */
        float X = 69.5f;
        float Y = 0;
        float Z = 24f;

        for (int i = 0; i < 20; i++) {
            TruckCrane tc = new TruckCrane(assetManager);
            tc.createTruckCrane();
            tc.setLocalTranslation(X, Y, Z);
            rootNode.attachChild(tc);
            tc.moveBase(X, Y, Z);

            X -= 3;
        }
        float Xtraincrane = -62.5f;
        float Ytraincrane = 0;
        float Ztraincrane = -28;
        
        for (int i = 0; i < 4; i++){
            TrainCrane trainc = new TrainCrane(assetManager);
            trainc.createTrainCrane();
            trainc.setLocalTranslation(Xtraincrane, Ytraincrane, Ztraincrane);
            rootNode.attachChild(trainc);
            Xtraincrane += 10;
        }
        
        float Xstorecrane = 0;
        float Ystorecrane = 0;
        float Zstorecrane = 0;
        
        for (int i = 0; i < 12; i++){
            StoreCrane storec = new StoreCrane(assetManager);
            storec.createStoreCrane();
            storec.setLocalTranslation(Xstorecrane, Ystorecrane, Zstorecrane);
            rootNode.attachChild(storec);
            Xstorecrane +=5;
            
        }
            
        
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
