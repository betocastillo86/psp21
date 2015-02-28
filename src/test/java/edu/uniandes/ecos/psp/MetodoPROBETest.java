/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp;

import edu.uniandes.ecos.modelos.RangoTamano;
import edu.uniandes.ecos.modelos.ResumenPrograma;
import java.util.LinkedList;
import junit.framework.TestCase;

/**
 *
 * @author Administrator
 */
public class MetodoPROBETest extends TestCase {
    
    public MetodoPROBETest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

   
    /**
     * Test of CalcularX method, of class MetodoPROBE.
     */
    public void testCalcularX() {
        System.out.println("CalcularX");
        Double dof = 0.20;
        Double p = 6d;
        Double semilla = 1d;
        MetodoPROBE instance = new MetodoPROBE();
        Double expResult = 0.55338;
        Double result = instance.CalcularX(dof, p, semilla);
        assertEquals(expResult, result);
    }
    
}
