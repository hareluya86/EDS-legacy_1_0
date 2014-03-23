/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data.Provider.Hibernate;

import EDS.Data.DAOFactoryType;
import EDS.Data.DBConnectionException;
import EDS.Data.EnterpriseEntity;
import EDS.Data.EnterpriseKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.exception.GenericJDBCException;

/**
 *
 * @author KH
 */
public class DAOHibernateEntityManager extends DAOHibernate {

    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction et;
    
    @Override
    public void init() {
        emf = Persistence.createEntityManagerFactory("HIBERNATE", this.cfg.getProperties());
        em = emf.createEntityManager();
    }

    @Override
    public void start() throws DBConnectionException{
        if(em == null)
            throw new RuntimeException("Start: Hibernate EntityManager is not initialized yet!");
        
        et = em.getTransaction();
        try{
            et.begin();
        }catch(PersistenceException pe){
            close();
            if(pe.getCause() instanceof GenericJDBCException){
                GenericJDBCException gjdbce = (GenericJDBCException)pe.getCause();
                if(gjdbce.getSQLState()==null || gjdbce.getSQLState().equalsIgnoreCase("null"))
                    throw new DBConnectionException(gjdbce);
                
                        
            }else{
                throw pe;
            }
        }finally{
            
        }
        
    }

    @Override
    public void commit() throws DBConnectionException{
        if(et == null) throw new RuntimeException("Hibernate DAO Commit: Transaction is not initialized yet.");
        //if(!et.isActive()) throw new RuntimeException("Hibernate DAO Commit: Transaction is not active yet.");//unnecessary as et.commit() will throw IllegalStateException
        
        //what if transaction is marked for rollback?
            
        try{
            et.commit();
        }catch(PersistenceException pe){
            et.rollback();
            if(pe.getCause() instanceof GenericJDBCException){
                GenericJDBCException gjdbce = (GenericJDBCException)pe.getCause();
                if(gjdbce.getSQLState()==null || gjdbce.getSQLState().equalsIgnoreCase("null"))
                    throw new DBConnectionException(gjdbce);
                        
            }else{
                throw pe;
            }
        }
        
    }

    @Override
    public void close(){
        if(et != null && et.isActive())
            et = null;
        if(em != null && em.isOpen())
            em.close();
        if(emf != null && emf.isOpen())
            emf.close();
    }

    @Override
    public void insertEntity(EnterpriseEntity entity) {
        if(em == null) init();
        em.persist(entity);
        em.flush(); //pushes entity to datastore (provider's cache), but doesn't commit to database!

    }

    @Override
    public void insertEntities(Collection<EnterpriseEntity> entities) {
        Iterator<EnterpriseEntity> i = entities.iterator();
        while(i.hasNext()){
            EnterpriseEntity ee = i.next();
            em.persist(ee);
        }
        //em.persist(entities);
        em.flush();
    }

    @Override
    public void updateEntity(EnterpriseEntity entity) {
        entity = em.merge(entity);
        em.flush();
    }

    @Override
    public void updateEntities(Collection<EnterpriseEntity> entities) {
        Iterator<EnterpriseEntity> i = entities.iterator();
        while(i.hasNext()){
            EnterpriseEntity ee = i.next();
            ee = em.merge(ee);
        }
        em.flush();
    }

    @Override
    public void deleteEntity(EnterpriseEntity entity) {
        em.remove(entity);
        em.flush();
    }

    @Override
    public void deleteEntities(Collection<EnterpriseEntity> entities) {
        Iterator<EnterpriseEntity> i = entities.iterator();
        while(i.hasNext()){
            EnterpriseEntity ee = i.next();
            em.remove(ee);
        }
        em.flush();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public EnterpriseEntity getEntity(EnterpriseKey key) {
        return (EnterpriseEntity) em.find(key.getClass(), key.key());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Collection<EnterpriseEntity> getEntities(CriteriaQuery query) {
        TypedQuery typedQuery = em.createQuery(query);
        List results = typedQuery.getResultList();
        return results;
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Helper methods
     */
    Map<String,List<EnterpriseKey>> sortIntoBuckets(Collection<EnterpriseKey> pkList){
        Map<String,List<EnterpriseKey>> entityHashMap = new HashMap<String,List<EnterpriseKey>>();
        Iterator i = pkList.iterator();
        while(i.hasNext()){
            //Must add a check here for DBObject type
            EnterpriseKey pk = (EnterpriseKey)i.next();
            String entityName = pk.tableName();
            if(entityHashMap.containsKey(entityName)){
                entityHashMap.get(entityName).add(pk);
            }
            else{
                ArrayList<EnterpriseKey> groupedPKList = new ArrayList<EnterpriseKey>();
                groupedPKList.add(pk);
                entityHashMap.put(entityName, groupedPKList);
            }
        }
        return entityHashMap;
    }
}
