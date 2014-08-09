/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dropped.EDS.Data.Provider.Hibernate;

import Dropped.EDS.Data.DBConnectionException;
import Dropped.EDS.Data.EnterpriseEntity;
import Dropped.EDS.Data.EnterpriseKey;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.service.ServiceRegistry;

/**
 * - Should I have multiple Sessions object per DAO? hmm....
 * <p>
 * 
 * @author KH
 */
public class DAOHibernateSession extends DAOHibernate {

    private final int MAX_FLUSH_SIZE = 1000;
    protected SessionFactory sessionFactory;
    protected Session session;
    protected Transaction tx;
    
    @Override
    public void init() {
        cfg.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder ().applySettings(cfg.getProperties()).build();
        sessionFactory = this.cfg.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
    }

    @Override
    public void start() throws DBConnectionException {
        if(session == null)
            throw new RuntimeException("Start: Hibernate Session is not initialized yet!");
        
        tx = session.getTransaction();
        try{
            tx.begin();
        }catch(PersistenceException pe){
            close();
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
    public void commit() throws DBConnectionException {
        if(tx == null) throw new RuntimeException("Hibernate DAO Commit: Transaction is not initialized yet.");
        try{
            tx.commit();
        }catch(PersistenceException pe){
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
    public void close() {
        if(tx != null && tx.isActive())
            tx = null;
        if(session != null && session.isOpen())
            session.close();
        if(sessionFactory != null && !sessionFactory.isClosed())
            sessionFactory.close();
    }

    @Override
    public void insertEntity(EnterpriseEntity entity) {
        if(session == null) this.init();
        session.save(entity);
        session.flush();
    }

    @Override
    public void insertEntities(Collection<EnterpriseEntity> entities) {
        if(session == null) this.init();
        Iterator<EnterpriseEntity> i = entities.iterator();
        int count = 0;
        while(i.hasNext()){
            session.save(i.next());
            if((++count) % this.MAX_FLUSH_SIZE == 0)
                session.flush();
        }
        session.flush();
    }

    @Override
    public void updateEntity(EnterpriseEntity entity) {
        if(session == null) this.init();
        session.update(entity);
        session.flush();
    }

    @Override
    public void updateEntities(Collection<EnterpriseEntity> entities) {
        if(session == null) this.init();
        Iterator<EnterpriseEntity> i = entities.iterator();
        int count = 0;
        while(i.hasNext()){
            session.update(i.next());
            if((++count) % this.MAX_FLUSH_SIZE == 0)
                session.flush();
        }
        session.flush();
    }

    @Override
    public void deleteEntity(EnterpriseEntity entity) {
        if(session == null) this.init();
        session.delete(entity);
        session.flush();
    }

    @Override
    public void deleteEntities(Collection<EnterpriseEntity> entities) {
        if(session == null) this.init();
        Iterator<EnterpriseEntity> i = entities.iterator();
        int count = 0;
        while(i.hasNext()){
            session.delete(i.next());
            if((++count) % this.MAX_FLUSH_SIZE == 0)
                session.flush();
        }
        session.flush();
    }

    @Override
    public EntityManager getEntityManager() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EnterpriseEntity getEntity(EnterpriseKey key) {
        return (EnterpriseEntity)session.get(key.getClass(), key);
    }

    @Override
    public Collection<EnterpriseEntity> getEntities(CriteriaQuery query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
