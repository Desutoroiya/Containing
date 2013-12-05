/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Niels Riemersma
 */
public class Container 
{
    /*
     * Dimensies voor buitenkant van de container
     */
    private float length = 1.2192f;
    private float width = 0.2438f;
    private float height = 0.2393f;
    /*
     * Aankomst van container
     * - Datum en tijd
     * - Vervoersbedrijf en typevervoer
     * - Aankomst positie (XYZ)
     */
    private String dateArrive;
    private String vehicleArrive;
    private String companyArrive;
    //COORDINATES
    
    /*
     * Vertrek van container
     * - Datum en tijd
     * - Vervoersbedrijf en typevervoer
     */
    private String dateDept;
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
    
    public Container()
    {
        this.dateArrive = dateArrive;
        this.vehicleArrive = vehicleArrive;
        this.companyArrive = companyArrive;
        
        this.dateDept = dateDept;
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

}

