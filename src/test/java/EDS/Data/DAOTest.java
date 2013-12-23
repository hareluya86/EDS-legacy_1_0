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
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author KH
 */
public class DAOTest {
    
    DAO dao1;
    DAO dao2;
    
    public DAOTest() {
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
        dao1 = DAOFactory.getDAOFactory(DAOFactory.JPAType.HIBERNATE).getDAO();
    }
    
    @After
    public void tearDown() {
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
        
        dao1.insertSingleObject(tu1);
        dao1.insertSingleObject(tu2);
        dao1.insertSingleObject(trA1);
    }

    /**
     * Test of getManyObjects method, of class DAO.
     */
    @Test
    public void testGetManyObjects() {
        System.out.println("getManyObjects");
        Collection<EnterpriseKey> keys = null;
        DAO instance = new DAOImpl();
        Collection expResult = null;
        Collection result = instance.getManyObjects(keys);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertSingleObject method, of class DAO.
     */
    @Test
    public void testInsertSingleObject() {
        System.out.println("insertSingleObject");
        EnterpriseEntity row = null;
        DAO instance = new DAOImpl();
        instance.insertSingleObject(row);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertManyObjects method, of class DAO.
     */
    @Test
    public void testInsertManyObjects() {
        System.out.println("insertManyObjects");
        Collection<EnterpriseEntity> objects = null;
        DAO instance = new DAOImpl();
        instance.insertManyObjects(objects);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSingleObject method, of class DAO.
     */
    @Test
    public void testDeleteSingleObject() {
        System.out.println("deleteSingleObject");
        EnterpriseKey key = null;
        DAO instance = new DAOImpl();
        instance.deleteSingleObject(key);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteManyObjects method, of class DAO.
     */
    @Test
    public void testDeleteManyObjects() {
        System.out.println("deleteManyObjects");
        Collection<EnterpriseKey> keys = null;
        DAO instance = new DAOImpl();
        instance.deleteManyObjects(keys);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class DAOImpl extends DAO {

        public EnterpriseEntity getSingleObject(EnterpriseKey key) {
            return null;
        }

        public Collection<EnterpriseEntity> getManyObjects(Collection<EnterpriseKey> keys) {
            return null;
        }

        public void insertSingleObject(EnterpriseEntity row) {
        }

        public void insertManyObjects(Collection<EnterpriseEntity> objects) {
        }

        public void deleteSingleObject(EnterpriseKey key) {
        }

        public void deleteManyObjects(Collection<EnterpriseKey> keys) {
        }
    }
}
