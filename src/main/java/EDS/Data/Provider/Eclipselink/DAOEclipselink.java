/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data.Provider.Eclipselink;

import EDS.Data.DAO;
import EDS.Data.EnterpriseEntity;
import java.util.Collection;
import java.util.Map;

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
    public void init() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void commit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void insertEntity(EnterpriseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet.");
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
