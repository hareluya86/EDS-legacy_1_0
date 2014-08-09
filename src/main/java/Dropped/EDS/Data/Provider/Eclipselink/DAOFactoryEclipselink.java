/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dropped.EDS.Data.Provider.Eclipselink;

import Dropped.EDS.Data.DAO;
import Dropped.EDS.Data.DAOFactory;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author KH
 */
public class DAOFactoryEclipselink extends DAOFactory {
    
    @Override
    public DAO getDAO() {
        
        DAOEclipselink dao = new DAOEclipselink();
        dao.setDBConfig(createFullConfig()); //Preferred way is programmatic config
        return dao;
    }
    
    public Map<String,Object> createFullConfig(){
        Map<String,Object> DBConfig = createPartialConfig();
        
        //DBConfig.put("provider","org.eclipse.persistence.jpa.PersistenceProvider");
        //DBConfig.put("exclude-unlisted-classes","false");
        DBConfig.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/eds?characterEncoding=utf8");
        DBConfig.put("javax.persistence.jdbc.user", "eds");
        DBConfig.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver"); //next time can abstract this out
        DBConfig.put("javax.persistence.jdbc.password", "eds");
        DBConfig.put("eclipselink.query-results-cache", false);
        DBConfig.put("eclipselink.ddl-generation", "create-tables");
        
        return DBConfig;
    }
    
    public Map<String,Object> createPartialConfig(){
        Map<String,Object> DBConfig = new HashMap<String,Object>();
        return DBConfig;
    }
}
