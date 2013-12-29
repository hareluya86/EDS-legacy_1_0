/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data;

import EDS.BusinessUnit.EnterpriseRelationship;
import EDS.BusinessUnit.EnterpriseUnit;
import EDS.BusinessUnit.Test.TestRelationshipA;
import EDS.BusinessUnit.Test.TestUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author KH
 */
public class DAOTest {
    
    int numOfDAOs = 10;
    Stack<DAO> DAOs;
    DAO dao1;
    DAO dao2;
    
    public DAOTest() {
        DAOs = new Stack<DAO>();
        for(int i=0; i<numOfDAOs; i++){
            DAO daoTemp = DAOFactory.getDAOFactory(DAOFactory.JPAType.HIBERNATE).getDAO();
            DAOs.push(daoTemp);
        }
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        //dao1 = DAOFactory.getDAOFactory(DAOFactory.JPAType.ECLIPSELINK).getDAO();
        dao1 = DAOs.pop();
    }
    
    @After
    public void tearDown() {
        if(dao1 != null)
            dao1.close();
    }
    
    /**
     * Test of init(), start(), commit() and close() methods of the DAO
     * Method numbering:
     * M1) init()
     * M2) start()
     * M3) commit()
     * M4) close()
     */
    
    /**
     * Test case 1: M1,M2,M3,M4
     */
    @Test
    public void testDAOPhases1(){
        try{
            dao1.init();
            dao1.start();
            dao1.commit();
            dao1.close();
        }catch(Exception e){
            fail("testDAOPhases1 failed : "+e.getMessage());
        }
        
        
    }
    /**
     * Test of getSingleObject method, of class DAO.
     */
    @Test
    public void testGetSingleObject() {
        System.out.println("getSingleObject");
        
        TestUnit tu1 = new TestUnit();
        TestUnit tu2 = new TestUnit();
        tu1.randInit();
        tu2.randInit();
        EnterpriseRelationship trA1 = new TestRelationshipA();
        trA1.randInit();
        trA1.setSOURCE(tu1);
        trA1.setTARGET(tu2);
        //trA1.getPk().setREL_TYPE("TRA1");
        
        try{
            dao1.init();
            dao1.start();
            dao1.insertSingleEntity(tu1);
            dao1.insertSingleEntity(tu2);
            dao1.insertSingleEntity(trA1);
            dao1.commit();
        }catch(DBConnectionException dbce){
            fail("Database connection not opened!");
            dbce.printStackTrace(System.out);
        }
        dao1.close();
    }

    
}
