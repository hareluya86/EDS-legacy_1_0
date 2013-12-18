/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data.Provider.Hibernate;

import EDS.BusinessUnit.EnterpriseRelationship;
import EDS.BusinessUnit.Test.TestRelationshipA;
import EDS.Data.DAO;
import EDS.Data.EnterpriseKey;
import EDS.Data.EnterpriseEntity;
import EDS.Data.Provider.Hibernate.DAOFactoryHibernate.CONFIG_TYPE;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author KH
 */
public class DAOHibernate extends DAO {

    private Configuration cfg;
    private SessionFactory sessions;
    private CONFIG_TYPE config_type;

    public DAOHibernate() {
        super();
    }

    public Configuration getCfg() {
        return cfg;
    }

    public void setCfg(Configuration cfg) {
        this.cfg = cfg;
    }

    public CONFIG_TYPE getConfig_type() {
        return config_type;
    }

    public void setConfig_type(CONFIG_TYPE config_type) {
        this.config_type = config_type;
    }
    
    /*
     * No outside access to SessionFactory required
     *
    public SessionFactory getSessions() {
        return sessions;
    }

    public void setSessions(SessionFactory sessions) {
        this.sessions = sessions;
    }
    * 
    */

    @Override
    public EnterpriseEntity getSingleObject(EnterpriseKey key) {
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.getCurrentSession();
        
        return (EnterpriseEntity)s.get(key.getClass(), key);
        
    }

    @Override
    public Collection<EnterpriseEntity> getManyObjects(Collection<EnterpriseKey> keys) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void insertSingleObject(EnterpriseEntity row) {
        /*
        SessionFactory sf = cfg
                .addAnnotatedClass(row.getClass())
                //.addAnnotatedClass(EnterpriseRelationship.class)
                .buildSessionFactory();
        Session s = sf.getCurrentSession();
        
        s.beginTransaction();
        s.save(row);
        s.getTransaction().commit();*/
        //use entitymanager instead, for autodiscovery
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HIBERNATE", cfg.getProperties());
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(row);
        et.commit();
    }

    @Override
    public void insertManyObjects(Collection<EnterpriseEntity> objects) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteSingleObject(EnterpriseKey key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteManyObjects(Collection<EnterpriseKey> keys) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
