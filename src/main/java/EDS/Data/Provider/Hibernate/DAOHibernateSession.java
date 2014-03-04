/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data.Provider.Hibernate;

import EDS.Data.DBConnectionException;
import EDS.Data.EnterpriseEntity;
import java.util.Collection;
import javax.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author KH
 */
public class DAOHibernateSession extends DAOHibernate {

    protected SessionFactory sessionFactory;
    protected Session session;
    protected Transaction tx;
    
    @Override
    public void init() {
        //cfg.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        sessionFactory = this.cfg.buildSessionFactory(serviceRegistry);
    }

    @Override
    public void start() throws DBConnectionException {
        if(sessionFactory == null)
            throw new RuntimeException("Start: Hibernate SessionFactory is not initialized yet!");
        
        session = sessionFactory.openSession();
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
        session.save(entity);
    }

    @Override
    public void insertEntities(Collection<EnterpriseEntity> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateEntity(EnterpriseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateEntities(Collection<EnterpriseEntity> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEntity(EnterpriseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEntities(Collection<EnterpriseEntity> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
