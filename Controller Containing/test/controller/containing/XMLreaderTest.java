/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.containing;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;

/**
 *
 * @author Ivar
 */
public class XMLreaderTest {
    
    public XMLreaderTest() {
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
     * Test of XMLreader method, of class XMLreader.
     */
    @Test
    public void testXMLreader() {
        String testxml;
        try {
            File ContainerList = new File("xml1.xml");
            testxml = "Test success";
        } catch (Exception e) {
            testxml = "Test fail";
        }
        
        
        
        System.out.println(testxml);
        XMLreader instance = new XMLreader();
        instance.XMLreader();
        // TODO review the generated test code and remove the default call to fail.
        if (testxml == "Test fail"){
            fail("Test failed.");
        } else {
            System.out.println("Test passed.");
        }
    }

    /**
     * Test of getContainerList method, of class XMLreader.
     */
    @Test
    public void testGetContainerList() {
        System.out.println("getContainerList");
        XMLreader instance = new XMLreader();
        ArrayList<Container> expResult = null;
        ArrayList<Container> result = instance.getContainerList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}