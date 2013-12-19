package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.renderer.RenderManager;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import java.util.LinkedList;
import java.util.List;

/**
 * Main CONTROL SIM 
 *
 * @author GROEP 8
 */
public class Main extends SimpleApplication {
    //TERRAIN LIGHT
    DirectionalLight sun;
    AmbientLight ambLight;
    Terrain terrain;
    
    //variabelen voor containers
    int containerAmount;
    int containerAmountVar;
    
    // Aanroepen
    Ship[] schip;
    Barge[] barge;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        //SET LOCATION FOR CAMERA + SPEED
        cam.setLocation(new Vector3f(0, 10, 10));
        flyCam.setMoveSpeed(25);
        
        //LOAD ASSETS
        loadTerrainLight();
        loadAGV();
        CreateTrain(5);
        loadTruckCranes();
        loadTrainCranes();
        loadStorageCranes();
        loadShipCranes();
        loadBargeCranes();
        loadShips();
        loadBarges();
        
        //ALS LAATSTE IVM VERWIJZING NAAR SHIPS
        loadContainers();
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    public void CreateTrain(int wagons){
        Train train = new Train(assetManager);
        train.createTrain();
        train.setLocalTranslation(-63, 0.1f, -28);
        rootNode.attachChild(train);
        for(int i =0;i<wagons;i++){
            TrainWagon wagon = new TrainWagon(assetManager);
            wagon.CreateWagon();
            wagon.setLocalTranslation(-63+(1.43f*i), 0.1f, -28);
            rootNode.attachChild(wagon);
        }
    }
    
    public void loadTerrainLight(){
        /**
         * A white, directional light source
         */
        sun = new DirectionalLight();
        sun.setDirection((new Vector3f(-0.5f, -0.5f, -0.5f)).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);

        /*
         * Ambient Lightning
         */
        ambLight = new AmbientLight();
        ambLight.setColor(new ColorRGBA(1f, 1f, 0.8f, 0.2f));
        rootNode.addLight(ambLight);

        /*
         * Loading terrain
         */
        terrain = new Terrain(assetManager, rootNode);
        terrain.initTerrain();
        ColorRGBA backgroundColor = new ColorRGBA(0.3f,103,163,20);
        viewPort.setBackgroundColor(backgroundColor);
    }
    
    public void loadAGV(){
        /*
         * AGV lijst
         * 100 stuks
         */

        float Xagv = 6f;
        float Yagv = 0;
        float Zagv = -22f;

        List<AGV> AGVList = new LinkedList<AGV>();
        AGV[] agv = new AGV[100];

        for (int i = 0; i < 50; i++) {
            agv[i] = new AGV(assetManager);
            AGVList.add(agv[i]);

            agv[i].CreateAGV();
            agv[i].agv.setLocalTranslation(Xagv, Yagv, Zagv);
            rootNode.attachChild(agv[i].agv);

            Xagv += 1f;
        }
        
        Xagv = 6f;
        
        for (int i = 50; i < 100; i++) {
            agv[i] = new AGV(assetManager);
            AGVList.add(agv[i]);

            agv[i].CreateAGV();
            agv[i].agv.setLocalTranslation(Xagv, Yagv, Zagv - 2f);
            rootNode.attachChild(agv[i].agv);

            Xagv += 1f;
        }
    }
    
    public void loadTruckCranes(){
        float XtruckCrane = 69;
        float YtruckCrane = 0;
        float ZtruckCrane = 22f;

        List<TruckCrane> TruckCraneList = new LinkedList<TruckCrane>();
        TruckCrane[] truckCrane = new TruckCrane[20];

        for (int i = 0; i < 20; i++) {
            truckCrane[i] = new TruckCrane(assetManager);
            TruckCraneList.add(truckCrane[i]);

            truckCrane[i].createTruckCrane();
            truckCrane[i].craneLift.setLocalTranslation(XtruckCrane, YtruckCrane, ZtruckCrane);
            rootNode.attachChild(truckCrane[i].craneLift);

            XtruckCrane -= 3;
        }
    }
    
    public void loadTrainCranes(){
        float XtrainCrane = -62.5f;
        float YtrainCrane = 0;
        float ZtrainCrane = -27;

        List<TrainCrane> TrainCraneList = new LinkedList<TrainCrane>();
        TrainCrane[] trainCrane = new TrainCrane[4];

        for (int i = 0; i < 4; i++) {
            trainCrane[i] = new TrainCrane(assetManager);
            TrainCraneList.add(trainCrane[i]);

            trainCrane[i].createTrainCrane();
            trainCrane[i].trainCrane.setLocalTranslation(XtrainCrane, YtrainCrane, ZtrainCrane);

            rootNode.attachChild(trainCrane[i].trainCrane);

            XtrainCrane += 10;
        }
    }
    
    public void loadStorageCranes(){
        float XstorecraneOne = -64.5f;
        float YstorecraneOne = 0;
        float ZstorecraneOne = 18;

        float XstorecraneTwo = 7.5f;
        float YstorecraneTwo = 0;
        float ZstorecraneTwo = 18;

        List<StoreCrane> StorageCraneList = new LinkedList<StoreCrane>();
        StoreCrane[] storageCrane = new StoreCrane[46];

        for (int i = 0; i < 23; i++) {
            storageCrane[i] = new StoreCrane(assetManager);
            StorageCraneList.add(storageCrane[i]);
            storageCrane[i].createStoreCrane();
            storageCrane[i].storageCrane.setLocalTranslation(XstorecraneOne, YstorecraneOne, ZstorecraneOne);

            rootNode.attachChild(storageCrane[i].storageCrane);

            XstorecraneOne += 3;
        }

        for (int i = 23; i < 46; i++) {
            storageCrane[i] = new StoreCrane(assetManager);
            StorageCraneList.add(storageCrane[i]);
            storageCrane[i].createStoreCrane();
            storageCrane[i].storageCrane.setLocalTranslation(XstorecraneTwo, YstorecraneTwo, ZstorecraneTwo);

            rootNode.attachChild(storageCrane[i].storageCrane);

            XstorecraneTwo += 3;
        }
    }
    
    public void loadShipCranes(){
        float Xshipcrane = -77;
        float Yshipcrane = 0;
        float Zshipcrane = -24;

        List<ShipCrane> ShipCraneList = new LinkedList<ShipCrane>();
        ShipCrane[] shipCrane = new ShipCrane[10];

        for (int i = 0; i < 10; i++) {
            shipCrane[i] = new ShipCrane(assetManager);
            ShipCraneList.add(shipCrane[i]);
            shipCrane[i].createShipCrane();
            shipCrane[i].shipCrane.setLocalTranslation(Xshipcrane, Yshipcrane, Zshipcrane);

            rootNode.attachChild(shipCrane[i].shipCrane);

            Zshipcrane += 5.5f;
        }
    }
    
    public void loadBargeCranes(){
        float Xbargecrane = -64;
        float Ybargecrane = 0;
        float Zbargecrane = 29;

        List<BargeCrane> BargeCraneList = new LinkedList<BargeCrane>();
        BargeCrane[] bargeCrane = new BargeCrane[8];

        for (int i = 0; i < 8; i++) {
            bargeCrane[i] = new BargeCrane(assetManager);
            BargeCraneList.add(bargeCrane[i]);
            bargeCrane[i].createBargeCrane();
            bargeCrane[i].bargeCrane.setLocalTranslation(Xbargecrane, Ybargecrane, Zbargecrane);

            rootNode.attachChild(bargeCrane[i].bargeCrane);
            Xbargecrane += 9.25f;
        }
    }
    
    public void loadContainers(){
        containerAmountVar = 0;
        containerAmount = 1500;
        
        /*
         * Vanuit de cabine is de opbouw van id's als volgt:
         * Rechtsonder = 0
         * Linksonder = 74
         */

        List<Container> containerList = new LinkedList<Container>();
        Container[] container = new Container[containerAmount];
        
        //Manual i,moet uit lijst komen
        int i = 0;
        
        float contXdist = schip[i].ship.getLocalTranslation().x - 0.5f;// - 80.5f
        float contYdist = schip[i].ship.getLocalTranslation().y - 1.5f; // -2f
        float contZdist = schip[i].ship.getLocalTranslation().z - 10.75f; // -30.5f
        
        for (int contZ = 0; contZ < 20; contZ++){ // 20
            for (int contY = 0; contY < 15; contY++){ // 15
                for (int contX = 0; contX < 5; contX++) { // 1
                    container[containerAmountVar] = new Container(assetManager, rootNode);
                    containerList.add(container[containerAmountVar]);

                    container[containerAmountVar].loadContainer();
                    container[containerAmountVar].contNode.setLocalTranslation(contXdist, contYdist, contZdist);
                    rootNode.attachChild(container[containerAmountVar].contNode);
                    contXdist += 0.255f;
                    containerAmountVar++;
                }
                contXdist = schip[i].ship.getLocalTranslation().x - 0.5f;
                contYdist +=0.265f;
            }
            contYdist = schip[i].ship.getLocalTranslation().y - 1.5f;
            contZdist += 1.25f;
        }
        //testje van niels niet aankomen virus alles
        //container[74].contNode.setLocalTranslation(new Vector3f(agv[0].agv.getLocalTranslation().x, agv[0].agv.getLocalTranslation().y + 1, agv[0].agv.getLocalTranslation().z));
    }
    
    public void loadTrucks(){
        
        float truckSpawnX = 69.5f;
        float truckSpawnY = 0;
        float truckSpawnZ = 24f;
        
        List<Truck> TruckList = new LinkedList<Truck>();
        Truck[] truck = new Truck[10];
        
        for (int i = 0; i < 1; i++){
            truck[i] = new Truck(assetManager);
            TruckList.add(truck[i]);
            
            truck[i].createTruck();
            truck[i].truck.setLocalTranslation(truckSpawnX, truckSpawnY, truckSpawnZ);
            rootNode.attachChild(truck[i].truck);
        }
    }
    
    public void loadShips(){
        List<Ship> ShipList = new LinkedList<Ship>();
        schip = new Ship[2];
        
        for (int i = 0; i < 1; i++){
            schip[i] = new Ship(assetManager, rootNode);
            ShipList.add(schip[i]);
            
            schip[i].createShip();
            schip[i].ship.setLocalTranslation(-80f, -1f, -20f);
            rootNode.attachChild(schip[i].ship);
        }
    }
    
    public void loadBarges(){
        List<Barge> BargeList = new LinkedList<Barge>();
        barge = new Barge[2];
        
        for (int i = 0; i < 1; i++){ 
            barge[i] = new Barge(assetManager);
            barge[i].createBarge();
            barge[i].barge.setLocalTranslation(-62.5f, -1.25f, 31f);
            rootNode.attachChild(barge[i].barge);
        }
    }
}
