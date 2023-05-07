/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erdem
 */
public class GITListTest {
    
    public GITListTest() {
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
     * Test of addFirst method, of class GITList.
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        Object obj = "ayse";
        GITList instance = new GITList();
        instance.addFirst(obj);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addLast method, of class GITList.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast");
        Object obj = "ayse";
        GITList instance = new GITList();
        instance.addLast(obj);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class GITList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int index = 0;
        Object obj = "ayse";
        GITList instance = new GITList();
        instance.add(index, obj);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFirst method, of class GITList.
     */
    @Test
    public void testGetFirst() {
        System.out.println("getFirst");
        GITList instance = new GITList();
        Object expResult = "ayse";
        instance.addFirst(expResult);
        Object result = instance.getFirst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getLast method, of class GITList.
     */
    @Test
    public void testGetLast() {
        System.out.println("getLast");
        GITList instance = new GITList();
        Object expResult = "ayse";
        instance.addLast(expResult);
        Object result = instance.getLast();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class GITList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        
        Object expResult = "ayse";
        GITList instance = new GITList();
        instance.add(index, expResult);
        Object result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class GITList.
     */
   /* @Test
    public void testListIterator_0args() {
        System.out.println("listIterator");
        GITList instance = new GITList();
        GITIterator expResult = null;
        GITIterator result = instance.listIterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of listIterator method, of class GITList.
     */
    /*@Test
    public void testListIterator_int() {
        System.out.println("listIterator");
        int index = 0;
        GITList instance = new GITList();
        GITIterator expResult = null;
        GITIterator result = instance.listIterator(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
