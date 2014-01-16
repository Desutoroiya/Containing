package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.renderer.RenderManager;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main CONTROL SIM 
 *
 * @author GROEP 8
 */
public class Main extends SimpleApplication {
    /*
     * Declaration of variables.
     */
    //TERRAIN LIGHT
    DirectionalLight sun;
    DirectionalLight sun2;
    AmbientLight ambLight;
    Terrain terrain;
    
    //variabelen voor containers
    int containerAmount;
    int containerAmountVar;
    
    //variabelen voor trucks
    float truckSpawnX = 69;
    public static int truckcount = 0;
    
    /*
     * Lists for containers, vehicles and cranes
     */
    public static Container[] container;
    List<Container> containerList;
    
    public static Ship[] schip;
    List<Ship> ShipList;
    
    public static Barge[] barge;
    List<Barge> BargeList;
    
    public static AGV[] agv;
    List<AGV> AGVList;
    
    public static Truck[] truck;
    List<Truck> TruckList;
    
    public static ShipCrane[] shipCrane;
    List<ShipCrane> ShipCraneList;
    
    public static StoreCrane[] storageCrane;
    List<StoreCrane> StorageCraneList;
    
    public static TruckCrane[] truckCrane;
    List<TruckCrane> TruckCraneList;
    
    public static BargeCrane[] bargeCrane;
    List<BargeCrane> BargeCraneList;
    
    public static TrainCrane[] trainCrane;
    List<TrainCrane> TrainCraneList;
    
    TrainWagon[] trainWagon;
    List<TrainWagon> trainWagonList;
    
    /*
     * Initializes the application includes cranes, scene and other assets which are required.
     */
    @Override
    public void simpleInitApp() {
        //SET LOCATION FOR CAMERA + SPEED
        cam.setLocation(new Vector3f(60, 5, 30));
        flyCam.setMoveSpeed(25);
        
        //LOAD ASSETS
        loadTerrainLight();
        loadAGV();
        loadTruckCranes();
        loadTrainCranes();
        loadStorageCranes();
        loadShipCranes();
        loadBargeCranes();
        loadShips();
        loadBarges();
        
        loadContainers();
        readHandler();
        
        agv[0].moveToCrane();
    }

    /*
     * Update function, here all things that should be updated go:
     */
    @Override
    public void simpleUpdate(float tpf) {
        if (truckCrane != null){
            for (TruckCrane truckCrane : TruckCraneList){
                    truckCrane.update(tpf);
            }
        }
//        truckCrane[9].update(tpf);
//        truckCrane[8].update(tpf);
        
        if (shipCrane != null){
            for (ShipCrane shipCrane : ShipCraneList){
                shipCrane.update(tpf);
            }
        }
        if (trainCrane != null){
            for (TrainCrane trainCrane : TrainCraneList){
                trainCrane.update(tpf);
            }
        }      
        if (bargeCrane != null){
            for (BargeCrane bargeCrane : BargeCraneList){
                bargeCrane.update(tpf);
            }
        }
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    /*
     * Variables for the readhandler
     * readi = index for input from controller
     * truckID = id given to truck from controller
     */
    int readi = 0;
    public static int truckID = 0;
    
    /*
     * Readhandler, this reads the input from the controller and creates trucks and containers
     */
        
    public void readHandler(){
        
        for (String message : Server_client.log) {
            if(Server_client.log.get(readi).equals("vrachtauto") && truckCrane[truckID].busy == false){
                TruckCrane.localID = truckID;
                loadTrucks();
                
                System.out.println("check " + truckID);
                
                truckCrane[truckID].cranepos = 1;
                
                truckID++;
            }
            readi++;
        }
    }
    
    
    public void createTrain(int wagons){
    /*
     * Method for initializing the train including wagons
     */
        float Xtrainwagon = - 63;
        float Ytrainwagon = 0.1f;
        float Ztrainwagon = -28;
        
        Train train = new Train(assetManager);
        train.createTrain();
        train.setLocalTranslation(Xtrainwagon, Ytrainwagon, Ztrainwagon);
        rootNode.attachChild(train);
        
        trainWagonList = new LinkedList<TrainWagon>();
        trainWagon = new TrainWagon[wagons];
        
        int test = 35;
        int stapel = 0;
        
        for (int i = 0 ; i < wagons ; i++){
            trainWagon[i] = new TrainWagon(assetManager);
            trainWagonList.add(trainWagon[i]);
            
            trainWagon[i].CreateWagon();
            trainWagon[i].trainwagon.setLocalTranslation(Xtrainwagon+(1.43f*i), Ytrainwagon, Ztrainwagon);
            
            trainWagon[i].trainwagon.attachChild(container[test].contNode);
            container[test].contNode.setLocalTranslation(new Vector3f(0,0.05f,0));
            container[test].contNode.rotate(0,FastMath.HALF_PI,0);
            
            rootNode.attachChild(trainWagon[i].trainwagon);
            
            if (test == 36*stapel){
                
                trainWagon[i].trainwagon.attachChild(container[test].contNode);
                container[test].contNode.setLocalTranslation(new Vector3f(0,0.05f,0));
                stapel++;
                test = 36*(stapel+1);               
            }
            test--;           
        }
    }
    
    public void loadTerrainLight(){
        /*
         * Method to create terrain and light
         */
        
        /**
         * A white, directional light source
         */
        sun = new DirectionalLight();
        sun.setDirection((new Vector3f(-10,-10,-10)).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);

        /*
         * Ambient Lightning
         */
        ambLight = new AmbientLight();
        ambLight.setColor(ColorRGBA.White);
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
         * Method to load 100 AGVs to the scene at the correct location
         */

        float Xagv = 6f;
        float Yagv = 0;
        float Zagv = -22f;

        AGVList = new LinkedList<AGV>();
        agv = new AGV[100];

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
        /*
         * Load truckcranes
         */
        float XtruckCrane = 69f;
        float YtruckCrane = 0f;
        float ZtruckCrane = 22f;

        TruckCraneList = new LinkedList<TruckCrane>();
        truckCrane = new TruckCrane[20];

        for (int i = 0; i < 20; i++) {
            truckCrane[i] = new TruckCrane(assetManager);
            TruckCraneList.add(truckCrane[i]);

            truckCrane[i].createTruckCrane();
            truckCrane[i].truckCraneNode.setLocalTranslation(XtruckCrane, YtruckCrane, ZtruckCrane);
            
            rootNode.attachChild(truckCrane[i].truckCraneNode);

            XtruckCrane -= 3;
        }
    }
    
    public void loadTrainCranes(){
        /*
         * Load traincranes
         */
        float XtrainCrane = -63f;
        float YtrainCrane = 0;
        float ZtrainCrane = -27;

        TrainCraneList = new LinkedList<TrainCrane>();
        trainCrane = new TrainCrane[4];

        for (int i = 0; i < 4; i++) {
            trainCrane[i] = new TrainCrane(assetManager, trainWagon);
            TrainCraneList.add(trainCrane[i]);

            trainCrane[i].createTrainCrane();
            trainCrane[i].trainCrane.setLocalTranslation(XtrainCrane, YtrainCrane, ZtrainCrane);

            rootNode.attachChild(trainCrane[i].trainCrane);

            XtrainCrane += 10;
        }
    }
    
    public void loadStorageCranes(){
        /*
         * Load storagecranes
         */
        float XstorecraneOne = -64.5f;
        float YstorecraneOne = 0;
        float ZstorecraneOne = 18;

        float XstorecraneTwo = 7.5f;
        float YstorecraneTwo = 0;
        float ZstorecraneTwo = 18;

        StorageCraneList = new LinkedList<StoreCrane>();
        storageCrane = new StoreCrane[46];

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
        /*
         * Load shipcranes (big ships)
         */
        float Xshipcrane = -77;
        float Yshipcrane = 0;
        float Zshipcrane = -24;

        ShipCraneList = new LinkedList<ShipCrane>();
        shipCrane = new ShipCrane[10];

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
        /*
         * Load bargecranes (small ships)
         */
        float Xbargecrane = -64;
        float Ybargecrane = 0;
        float Zbargecrane = 29;

        BargeCraneList = new LinkedList<BargeCrane>();
        bargeCrane = new BargeCrane[8];

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
        /*
         * Method to fill the boat with containers
         */
        containerAmountVar = 0;
        containerAmount = 10000;
        
        /*
         * Vanuit de cabine is de opbouw van id's als volgt:
         * Rechtsonder = 0
         * Linksonder = 74
         */

        containerList = new LinkedList<Container>();
        container = new Container[containerAmount];
        
        //Manual i,moet uit lijst komen
        int i = 0;
        
        float contXdist = -0.5f;
        float contYdist = -1.5f;
        float contZdist = -10.75f;
        
        for (int contZ = 0; contZ < 20; contZ++){ // 20
            for (int contY = 0; contY < 15; contY++){ // 15
                for (int contX = 0; contX < 5; contX++) { // 1
                    container[containerAmountVar] = new Container(assetManager, schip[i].ship);
                    containerList.add(container[containerAmountVar]);

                    container[containerAmountVar].loadContainer();
                    container[containerAmountVar].contNode.setLocalTranslation(contXdist,contYdist,contZdist);
                    schip[i].ship.attachChild(container[containerAmountVar].contNode);
                    contXdist += 0.255f;
                    containerAmountVar++;
                }
                contXdist = -0.5f;
                contYdist +=0.265f;
            }
            contYdist = -1.5f;
            contZdist += 1.25f;
        }
    }
    
    public void loadTrucks(){
        /*
         * Load trucks
         */
        float truckSpawnY = 0;
        float truckSpawnZ = 24.25f;
        
        TruckList = new LinkedList<Truck>();
        truck = new Truck[10];
        
        truck[truckID] = new Truck(assetManager);
        TruckList.add(truck[truckID]);

        truck[truckID].createTruck();
        truck[truckID].truck.setLocalTranslation(truckSpawnX, truckSpawnY, truckSpawnZ);
        rootNode.attachChild(truck[truckID].truck);
        truck[truckID].truck.attachChild(container[truckID].contNode);
        container[truckID].contNode.setLocalTranslation(0.32f,0.2f,0);
        container[truckID].contNode.rotate(0, FastMath.HALF_PI, 0);
        
        truckcount++;
        truckSpawnX -= 3;
    }
    
    public void loadShips(){
        /*
         * Load ships (big ships)
         */
        ShipList = new LinkedList<Ship>();
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
        /*
         * Load barges (big ships)
         */
        BargeList = new LinkedList<Barge>();
        barge = new Barge[2];
        
        for (int i = 0; i < 1; i++){ 
            barge[i] = new Barge(assetManager);
            BargeList.add(barge[i]);
            
            barge[i].createBarge();
            barge[i].barge.setLocalTranslation(-62.5f, -1.25f, 31f);
            rootNode.attachChild(barge[i].barge);
        }
    }
    
//    public void moveContainer(int containerAmountVar, int i, int storageCrane){
//        container[containerAmountVar].contNode.getLocalTranslation();
//        container[containerAmountVar].contNode.setLocalTranslation(new Vector3f(shipCrane[i].shipCrane.getLocalTranslation().x, shipCrane[i].shipCrane.getLocalTranslation().y - 2, shipCrane[i].shipCrane.getLocalTranslation().z));
//    }
    
}
