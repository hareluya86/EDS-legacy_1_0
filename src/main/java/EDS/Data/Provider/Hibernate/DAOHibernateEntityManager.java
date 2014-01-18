/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data.Provider.Hibernate;

import EDS.Data.DBConnectionException;
import EDS.Data.EnterpriseEntity;
import javax.persistence.*;
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
        
        try{
            et.commit();
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
    public void close(){
        if(et != null && et.isActive())
            et = null;
        if(em != null && em.isOpen())
            em.close();
        if(emf != null && emf.isOpen())
            emf.close();
    }

    @Override
    public void insertSingleEntity(EnterpriseEntity entity) {
        em.persist(entity);
    }
    
}
