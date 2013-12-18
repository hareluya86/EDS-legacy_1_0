/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data.Provider.Eclipselink;

import EDS.Data.DAO;
import EDS.Data.EnterpriseKey;
import EDS.BusinessUnit.EnterpriseUnit;
import EDS.Data.EnterpriseEntity;
import java.util.Collection;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author KH
 */
public class DAOEclipselink extends DAO{

    private Map<String,Object> DBConfig;

    public Map<String, Object> getDBConfig() {
        return DBConfig;
    }

    public void setDBConfig(Map<String, Object> DBConfig) {
        this.DBConfig = DBConfig;
    }

    @Override
    public EnterpriseEntity getSingleObject(EnterpriseKey key) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECLIPSELINK", DBConfig);
        EntityManager em = emf.createEntityManager();
        
        EnterpriseEntity e = (EnterpriseEntity)em.find(key.getClass(), key);
        
        return e;
    }

    @Override
    public Collection<EnterpriseEntity> getManyObjects(Collection<EnterpriseKey> keys) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void insertSingleObject(EnterpriseEntity row) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ECLIPSELINK", DBConfig);
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
