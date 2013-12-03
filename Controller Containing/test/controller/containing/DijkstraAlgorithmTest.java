/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.containing;

import java.util.Arrays;
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
     * Test of makePath method, of class DijkstraAlgorithm.
     */
    @Test
    public void testMakePath() {
        System.out.println("* DijkstraAlgorithmTest: testMakePath()");
        String a = "zeeschip";
        DijkstraAlgorithm instance = new DijkstraAlgorithm();
        instance.makePath(a);
        Points p = new Points();
        List<Vertex> expResult = Arrays.asList(p.CSC1);
        List<Vertex> result = DijkstraAlgorithm.getShortestPathTo(p.CSC1);
        assertEquals(expResult, result);
        // TODO review the generated test 
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
