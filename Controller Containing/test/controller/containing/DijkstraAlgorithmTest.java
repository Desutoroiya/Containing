/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.containing;

import java.util.List;
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
public class DijkstraAlgorithmTest {
    
    public DijkstraAlgorithmTest() {
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
     * Test of computePaths method, of class DijkstraAlgorithm.
     */
    @Test
    public void testComputePaths() {
        System.out.println("computePaths");
        Vertex source = null;
        DijkstraAlgorithm.computePaths(source);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShortestPathTo method, of class DijkstraAlgorithm.
     */
    @Test
    public void testGetShortestPathTo() {
        System.out.println("getShortestPathTo");
        Vertex target = null;
        List<Vertex> expResult = null;
        List<Vertex> result = DijkstraAlgorithm.getShortestPathTo(target);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makePath method, of class DijkstraAlgorithm.
     */
    @Test
    public void testMakePath() {
        System.out.println("makePath");
        String a = "";
        DijkstraAlgorithm instance = new DijkstraAlgorithm();
        instance.makePath(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
