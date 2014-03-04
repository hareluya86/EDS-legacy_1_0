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
    
    /**
     * Test data and utilities
     */
    int numOfDAOs = 10;
    Stack<DAO> DAOPool;
    
    int numOfTestUnits = 10;
    Stack<EnterpriseEntity> testEntities;
    
    final DAOFactory.JPAType DEFAULT_JPA_PROVIDER = DAOFactory.JPAType.HIBERNATE;
    
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
            DAO daoTemp = DAOFactory.getDAOFactory(DEFAULT_JPA_PROVIDER).getDAO();
            DAOPool.push(daoTemp);
            
            EnterpriseEntity ee = new TestUnit();
            ee.randInit();
            testEntities.add(ee);
        }
    }
    
    @After
    public void tearDown() {
        
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
            dao1.deleteEntities(testEntities);
        }
        
    }
    
    /**
     * TCER 21
     */
    @Test(expected=java.lang.NullPointerException.class)
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
    public void testInsertSingleObject1() {
        System.out.println("testInsertSingleObject 1");
        DAO dao1 = DAOPool.pop();
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
            dao1.insertEntity(tu1);
            dao1.insertEntity(tu2);
            dao1.insertEntity(trA1);
            dao1.commit();
            dao1.close();
        }catch(DBConnectionException dbce){
            fail("Database connection not opened!");
            dbce.printStackTrace(System.out);
        }catch(Throwable ex){
            fail("Failed: "+ex.getMessage());
            ex.printStackTrace();
        }
        assertTrue(true);
    }

    
}
