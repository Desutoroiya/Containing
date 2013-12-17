/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.containing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johan
 */
public class ContainerTest {
    
    public ContainerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Container.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Container instance = new Container(1, "131204", 0.0, 12.0, "vrachtauto", "DijckLogisticsBV", 1 , 0 ,0, "221204", 0.0, 12.0, "zeeschip", "ChinaShippingAgency","FlowersNL", 19965, 81, "nitrotolueen", "gas", "brandbaar", "1496-1");
        String expResult = "[Container 1 131204 0.0 12.0 vrachtauto DijckLogisticsBV 1 0 0 221204 0.0 12.0 zeeschip ChinaShippingAgency FlowersNL 19965 81 nitrotolueen gas brandbaar 1496-1]";
        String result = instance.toString();
        Container instance2 = new Container(3, "141204", 0.0, 12.0, "vrachtauto", "DHL", 1 , 0 ,0, "221204", 0.0, 12.0, "zeeschip", "DutchGeneralCargo","IntTrans", 4219, 71, "pianos", "los", "brandbaar", "1496-1");
        String expResult2 = "[Container 3 141204 0.0 12.0 vrachtauto DHL 1 0 0 221204 0.0 12.0 zeeschip DutchGeneralCargo IntTrans 4219 71 pianos los brandbaar 1496-1]";
        String result2 = instance2.toString();
        Container instance3 = new Container(4, "121204", 0.0, 12.0, "vrachtauto", "DijckLogisticsBV", 1 , 0 ,0, "251204", 0.0, 12.0, "zeeschip", "OceanTransIntBV","KraftFoods", 1428, 47, "bier", "los", "vloeibaar", "1496-1");
        String expResult3 = "[Container 4 121204 0.0 12.0 vrachtauto DijckLogisticsBV 1 0 0 251204 0.0 12.0 zeeschip OceanTransIntBV KraftFoods 1428 47 bier los vloeibaar 1496-1]";
        String result3 = instance3.toString();
        Container instance4 = new Container(6, "231204", 0.0, 3.0, "vrachtauto", "UPC", 1 , 0 ,0, "251204", 0.0, 3.0, "binnenschip", "GevelcoLogistic","UPS", 46753, 37, "karton", "los", "brandbaar", "1496-1");
        String expResult4 = "[Container 6 231204 0.0 3.0 vrachtauto UPC 1 0 0 251204 0.0 3.0 binnenschip GevelcoLogistic UPS 46753 37 karton los brandbaar 1496-1]";
        String result4 = instance4.toString();
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
