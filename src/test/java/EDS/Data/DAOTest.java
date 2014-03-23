/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data;

import EDS.BusinessUnit.EnterpriseRelationship;
import EDS.BusinessUnit.Test.TestData;
import EDS.BusinessUnit.Test.TestRelationshipA;
import EDS.BusinessUnit.Test.TestUnit;
import EDS.BusinessUnit.Test.TestUnit_;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author KH
 */
public class DAOTest {
    
    /**
     * Test data and utilities
     */
    int numOfDAOs = 10;
    Stack<DAO> DAOPool;
    
    int numOfTestUnits = 10;
    Stack<EnterpriseEntity> testEntities;
    
    final DAOFactory.JPAType DEFAULT_JPA_PROVIDER = DAOFactory.JPAType.HIBERNATE;
    
    @Inject @DAOFactoryType("HIBERNATE")
    DAOFactory daoFactoryHibernate;
    
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
        DAOPool = new Stack<DAO>();
        testEntities = new Stack<EnterpriseEntity>();
        for(int i=0; i<numOfDAOs; i++){
            
            DAO daoTemp = DAOFactory.getDAOFactory(DEFAULT_JPA_PROVIDER).getDAO();//daoFactoryHibernate.getDAO();
            
            DAOPool.push(daoTemp);
        }
        
        for(int i=0; i<numOfTestUnits; i++){
            EnterpriseEntity ee = new TestUnit();
            ee.randInit();
            testEntities.add(ee);
        }
    }
    
    @After
    public void tearDown() {
        if(DAOPool != null){
            for(DAO dao:DAOPool){
                if(dao != null){
                    dao.close();
                }
            }
        }
    }
    
    /**
     * TCER 1
     */
    @Test
    public void allowedSequenceOfCall_1(){
        System.out.println("TCER 1: allowedSequenceOfCall_1");
        DAO dao1 = DAOPool.pop();
        
        try{
            dao1.init();
            dao1.start();
            dao1.commit();
            dao1.close();
        }catch(Exception e){
            e.printStackTrace(System.out);
            fail(e.getMessage());
        }
        assertTrue(true);
    }
    
    /**
     * TCER 2
     */
    @Test
    public void allowedSequenceOfCall_2(){
        System.out.println("TCER 2: allowedSequenceOfCall_2");
        DAO dao1 = DAOPool.pop();
        try{
            dao1.init();
            dao1.start();
            dao1.close();
        }catch(Exception e){
            fail(e.getMessage());
        }
        assertTrue(true);
    }
    
    /**
     * TCER 3
     */
    @Test
    public void allowedSequenceOfCall_3(){
        System.out.println("TCER 3: allowedSequenceOfCall_3");
        DAO dao1 = DAOPool.pop();
        try{
            dao1.init();
            dao1.close();
        }catch(Exception e){
            fail(e.getMessage());
        }
        assertTrue(true);
    }
    
    /**
     * TCER 4
     */
    @Test
    public void allowedSequenceOfCall_4(){
        System.out.println("TCER 4: allowedSequenceOfCall_4");
        DAO dao1 = DAOPool.pop();
        try{
            dao1.init();
            dao1.init();
        }catch(Exception e){
            fail(e.getMessage());
            dao1.close();
        }
        assertTrue(true);
    }
    
    /**
     * TCER 5
     */
    @Test
    public void allowedSequenceOfCall_5(){
        System.out.println("TCER 5: allowedSequenceOfCall_5");
        DAO dao1 = DAOPool.pop();
        try{
            dao1.close();
        }catch(Exception e){
            fail(e.getMessage());
        }
        assertTrue(true);
    }
    
    /**
     * TCER 6
     */
    @Test(expected=java.lang.RuntimeException.class)
    public void illegalSequenceOfCall_6() throws DBConnectionException{
        System.out.println("TCER 6: illegalSequenceOfCall_6");
        DAO dao1 = DAOPool.pop();
        dao1.start();
    }
    
    /**
     * TCER 7
     */
    @Test(expected=java.lang.RuntimeException.class)
    public void illegalSequenceOfCall_7() throws DBConnectionException{
        System.out.println("TCER 7: illegalSequenceOfCall_7");
        DAO dao1 = DAOPool.pop();
        dao1.commit();
    }
    
    /**
     * TCER 8
     */
    @Test(expected=java.lang.RuntimeException.class)
    public void illegalSequenceOfCall_8() throws DBConnectionException{
        System.out.println("TCER 8: illegalSequenceOfCall_8");
        DAO dao1 = DAOPool.pop();
        dao1.init();
        dao1.commit();
    }
    
    /**
     * TCER 9
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_9() throws DBConnectionException{
        System.out.println("TCER 9: illegalSequenceOfCall_9");
        DAO dao1 = DAOPool.pop();
        EnterpriseEntity test = testEntities.pop();
        dao1.init();
        dao1.insertEntity(test);
    }
    
    /**
     * TCER 10
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_10() throws DBConnectionException{
        System.out.println("TCER 10: illegalSequenceOfCall_10");
        DAO dao1 = DAOPool.pop();
        EnterpriseEntity test = testEntities.pop();
        dao1.init();
        dao1.updateEntity(test);
    }
    
    /**
     * TCER 11
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_11() throws DBConnectionException{
        System.out.println("TCER 11: illegalSequenceOfCall_11");
        DAO dao1 = DAOPool.pop();
        EnterpriseEntity test = testEntities.pop();
        dao1.init();
        dao1.deleteEntity(test);
    }
    
    /**
     * TCER 12
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_12() throws DBConnectionException{
        System.out.println("TCER 12: illegalSequenceOfCall_12");
        DAO dao1 = DAOPool.pop();
        dao1.init();
        dao1.insertEntities(testEntities);
    }
    
    /**
     * TCER 13
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_13() throws DBConnectionException{
        System.out.println("TCER 13: illegalSequenceOfCall_13");
        DAO dao1 = DAOPool.pop();
        dao1.init();
        dao1.updateEntities(testEntities);
    }
    
    /**
     * TCER 14
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_14() throws DBConnectionException{
        System.out.println("TCER 14: illegalSequenceOfCall_14");
        DAO dao1 = DAOPool.pop();
        dao1.init();
        dao1.deleteEntities(testEntities);
    }
    
    /**
     * TCER 15
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_15() throws DBConnectionException{
        System.out.println("TCER 15: illegalSequenceOfCall_15");
        DAO dao1 = DAOPool.pop();
        EnterpriseEntity test = testEntities.pop();
        dao1.init();
        try{
            dao1.insertEntity(test);
        }catch(javax.persistence.TransactionRequiredException ex){
            ex.printStackTrace(System.out);
            dao1.insertEntity(test);
            
        }
        
    }
    
    /**
     * TCER 16
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_16() throws DBConnectionException{
        System.out.println("TCER 16: illegalSequenceOfCall_16");
        DAO dao1 = DAOPool.pop();
        EnterpriseEntity test = testEntities.pop();
        dao1.init();
        try{
            dao1.updateEntity(test);
        }catch(javax.persistence.TransactionRequiredException ex){
            ex.printStackTrace(System.out);
            dao1.updateEntity(test);
        }
        
    }
    
    /**
     * TCER 17
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_17() throws DBConnectionException{
        System.out.println("TCER 17: illegalSequenceOfCall_17");
        DAO dao1 = DAOPool.pop();
        EnterpriseEntity test = testEntities.pop();
        dao1.init();
        try{
            dao1.deleteEntity(test);
        }catch(javax.persistence.TransactionRequiredException ex){
            ex.printStackTrace(System.out);
            dao1.deleteEntity(test);
        }
        
    }
    
    /**
     * TCER 18
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_18() throws DBConnectionException{
        System.out.println("TCER 18: illegalSequenceOfCall_18");
        DAO dao1 = DAOPool.pop();
        dao1.init();
        try{
            dao1.insertEntities(testEntities);
        }catch(javax.persistence.TransactionRequiredException ex){
            ex.printStackTrace(System.out);
            dao1.insertEntities(testEntities);
            
        }
        
    }
    
    /**
     * TCER 19
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_19() throws DBConnectionException{
        System.out.println("TCER 19: illegalSequenceOfCall_19");
        DAO dao1 = DAOPool.pop();
        dao1.init();
        try{
            dao1.updateEntities(testEntities);
        }catch(javax.persistence.TransactionRequiredException ex){
            ex.printStackTrace(System.out);
            dao1.updateEntities(testEntities);
            
        }
        
    }
    
    /**
     * TCER 20
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_20() throws DBConnectionException{
        System.out.println("TCER 20: illegalSequenceOfCall_20");
        DAO dao1 = DAOPool.pop();
        dao1.init();
        try{
            dao1.deleteEntities(testEntities);
        }catch(javax.persistence.TransactionRequiredException ex){
            ex.printStackTrace(System.out);
            dao1.deleteEntities(testEntities);
        }//debug
        catch(org.hibernate.MappingException mex){
            mex.printStackTrace(System.out);
        }
        
    }
    
    /**
     * TCER 21
     */
    @Test(expected=javax.persistence.TransactionRequiredException.class)
    public void illegalSequenceOfCall_21() throws DBConnectionException{
        System.out.println("TCER 21: withoutSetup_21");
        DAO dao1 = DAOPool.pop();
        EnterpriseEntity test = testEntities.pop();
        dao1.insertEntity(test);
    }
    
    /**
     * TCER 22
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void illegalSequenceOfCall_22() throws DBConnectionException{
        System.out.println("TCER 22: withoutSetup_22");
        DAO dao1 = DAOPool.pop();
        EnterpriseEntity test = testEntities.pop();
        dao1.updateEntity(test);   
    }
    
    /**
     * TCER 23
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void illegalSequenceOfCall_23() throws DBConnectionException{
        System.out.println("TCER 23: withoutSetup_23");
        DAO dao1 = DAOPool.pop();
        EnterpriseEntity test = testEntities.pop();
        dao1.updateEntity(test);   
    }
    
    /**
     * TCER 24
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void illegalSequenceOfCall_24() throws DBConnectionException{
        System.out.println("TCER 24: withoutSetup_24");
        DAO dao1 = DAOPool.pop();
        dao1.insertEntities(testEntities);   
    }
    
    /**
     * TCER 25
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void illegalSequenceOfCall_25() throws DBConnectionException{
        System.out.println("TCER 25: withoutSetup_25");
        DAO dao1 = DAOPool.pop();
        dao1.updateEntities(testEntities);   
    }
    
    /**
     * TCER 25
     */
    @Test(expected=java.lang.NullPointerException.class)
    public void illegalSequenceOfCall_26() throws DBConnectionException{
        System.out.println("TCER 26: withoutSetup_26");
        DAO dao1 = DAOPool.pop();
        dao1.deleteEntities(testEntities);   
    }
    
    /**
     * Test of getSingleObject method, of class DAO.
     */
    @Test
    public void testInsertEUwithERandED1() {
        System.out.println("testInsertEUwithERandED1");
        DAO dao1 = DAOPool.pop();
        TestUnit tu1 = (TestUnit) testEntities.pop();
        TestUnit tu2 = (TestUnit) testEntities.pop();
        EnterpriseRelationship trA1 = new TestRelationshipA();
        trA1.randInit();
        trA1.setSOURCE(tu1);
        trA1.setTARGET(tu2);
        //trA1.getPk().setREL_TYPE("TRA1");
        
        TestData td1 = new TestData();
        td1.randInit();
        tu1.getData().add(td1);
        td1.setBELONG_TO_OBJECT(tu1);
        
        try{
            dao1.init();
            dao1.start();
            dao1.insertEntity(tu1);
            dao1.insertEntity(tu2);
            dao1.insertEntity(td1);
            dao1.insertEntity(trA1);
            
            dao1.commit();
            dao1.close();
        }catch(DBConnectionException dbce){
            fail("Database connection not opened!");
            dbce.printStackTrace(System.out);
        }/*catch(Throwable ex){
            fail("Failed: "+ex.getMessage());
            ex.printStackTrace();
        }*/
        assertTrue(true);
    }
    
    //@Test
    public void testInsertEUwithERandED2() {
        System.out.println("testInsertEUwithERandED2");
        DAO dao1 = DAOPool.pop();
        TestUnit tu1 = (TestUnit) testEntities.pop();
        
        TestData td1 = new TestData();
        TestData td2 = new TestData();
        TestData td3 = new TestData();
        td1.randInit();
        td2.randInit();
        td3.randInit();
        
        tu1.getData().add(td1);
        //tu1.getData().add(td2);
        //tu1.getData().add(td3);
        
        List<EnterpriseEntity> insertAsAUnit = new ArrayList<EnterpriseEntity>();
        insertAsAUnit.add(tu1);
        try{
            dao1.init();
            dao1.start();
            
            dao1.insertEntity(tu1);
            dao1.commit();
            dao1.start();
            dao1.insertEntity(td1);
            
            dao1.commit();
        }catch(DBConnectionException dbce){
            fail("Database connection not opened!");
            dbce.printStackTrace(System.out);
        }
        
        
        
        
    }

    @Test
    public void testInsertEUandDelete(){
        System.out.println("testInsertEUandDelete1");
        DAO dao1 = DAOPool.pop();
        TestUnit tu1 = (TestUnit) testEntities.pop();
        tu1.randInit();
        try{
            dao1.init();
            dao1.start();
            dao1.insertEntity(tu1);
            dao1.deleteEntity(tu1);
            dao1.commit();
            dao1.close();
        }catch(DBConnectionException dbce){
            fail("Database connection not opened!");
            dbce.printStackTrace(System.out);
        }/*catch(Throwable ex){
            fail("Failed: "+ex.getMessage());
            ex.printStackTrace();
        }*/
        DAO dao2 = DAOPool.pop();
        dao2.init();
        TestUnit tu2 = (TestUnit) dao2.getEntity(tu1);
        assertNull(tu2);
    }
    
    @Test
    public void testInsertAndGetMany1(){
        System.out.println("testInsertAndGetMany1");
        
        DAO dao1 = DAOPool.pop(); //for inserting and retrieval (should be cached)
        DAO dao2 = DAOPool.pop(); //for retrieval
        
        try{
            dao1.init();
            dao1.start();
            dao1.insertEntities(testEntities);
            dao1.commit();
            dao1.close();
        }catch(DBConnectionException dbce){
            fail("Database connection not opened!");
            dbce.printStackTrace(System.out);
        }catch(Throwable ex){
            fail("Failed: "+ex.getMessage());
            ex.printStackTrace();
        }
        
        //Get entitymanager and build criteria from there
        dao1.init();
        EntityManager em = dao1.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<TestUnit> root = cq.from(TestUnit.class);
        List<Long> objectids = new ArrayList<Long>();
        for(EnterpriseEntity tu:testEntities){
            objectids.add((Long)tu.exportAsMap().get("OBJECTID"));
        }
        cq.select(root);
        cq.where(root.get(TestUnit_.OBJECTID).in(objectids));
        
        List<TestUnit> results = em.createQuery(cq).getResultList();
        
        //verify results
        assertEquals(testEntities,results);
        for(TestUnit tu:results){
            assertTrue(testEntities.contains(tu));
        }
        
        //verify with another DAO instance
        dao2.init();
        CriteriaBuilder cb2 = em.getCriteriaBuilder();
        CriteriaQuery cq2 = cb.createQuery();
        Root<TestUnit> root2 = cq2.from(TestUnit.class);
        cq2.select(root2);
        cq2.where(root2.get(TestUnit_.OBJECTID).in(objectids));
        
        List<TestUnit> results2 = new ArrayList(dao2.getEntities(cq2));
        
        assertEquals(testEntities,results2);
        for(TestUnit tu:results2){
            assertTrue(testEntities.contains(tu));
        }
    }
}
