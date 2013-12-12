/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.containing;

/**
 *
 * @author Niels Riemersma
 */
public class Container {

    private int id;
    /*
     * Dimensies voor buitenkant van de container
     */
    private float length = 1.2192f;
    private float width = 0.2438f;
    private float height = 0.2393f;
    
    /*
     * Aankomst van container
     * - Datum en tijd (tijd 1 en 2)
     * - Vervoersbedrijf en typevervoer
     * - Aankomst positie (XYZ)
     */
    private String dateArrive;
    private double timeArrive1;
    private double timeArrive2;
    private String vehicleArrive;
    private String companyArrive;
    //COORDINATEN
    private int xLoc;
    private int yLoc;
    private int zLoc;
    
    /*
     * Vertrek van container
     * - Datum en tijd (tijd 1 en 2)
     * - Vervoersbedrijf en typevervoer
     */
    private String dateDept;
    private double timeDept1;
    private double timeDept2;
    private String vehicleDept;
    private String companyDept;
    
    /*
     * Container informatie
     * - Eigenaar (naam)
     * - Containernummer
     * - Gewicht (leeg/vol)
     * - Inhoud (content, type, danger)
     * - ISO Code
     */
    private String ownerCont;
    private int idCont;
    private int weightCont;
    private String contentCont;
    private String contentTypeCont;
    private String contentDangerCont;
    private String isoCode;

    public Container(int id, String dateArrive, double timeArrive1, double timeArrive2, String vehicleArrive, String companyArrive, int xLoc, int yLoc, int zLoc, String dateDept, double timeDept1, double timeDept2, String vehicleDept, String companyDept, String ownerCont, int idCont, int weightCont, String contentCont, String contentTypeCont, String contentDangerCont, String isoCode) {
        this.id = id;
        this.dateArrive = dateArrive;
        this.timeArrive1 = timeArrive1;
        this.timeArrive2 = timeArrive2;
        this.vehicleArrive = vehicleArrive;
        this.companyArrive = companyArrive;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.zLoc = zLoc;
        this.dateDept = dateDept;
        this.timeDept1 = timeDept1;
        this.timeDept2 = timeDept2;
        this.vehicleDept = vehicleDept;
        this.companyDept = companyDept;
        this.ownerCont = ownerCont;
        this.idCont = idCont;
        this.weightCont = weightCont;
        this.contentCont = contentCont;
        this.contentTypeCont = contentTypeCont;
        this.contentDangerCont = contentDangerCont;
        this.isoCode = isoCode;
    }
    
    @Override
    public String toString()
    {
        return "[" + Container.class.getSimpleName() + 
        " " +id + " " + dateArrive + " " +  timeArrive1 + " " +  timeArrive2 + " " +  vehicleArrive + " " +  companyArrive+ 
        " " +  xLoc + " " +  yLoc + " " +  zLoc + " " +  dateDept + " " +  timeDept1 + " " +  timeDept2 + " " +  vehicleDept + 
        " " +  companyDept + " " +  ownerCont + " " +  idCont + " " +  weightCont + " " +  contentCont + " " +  contentTypeCont + 
        " " +  contentDangerCont + " " +  isoCode+ "]";
    }    
}
