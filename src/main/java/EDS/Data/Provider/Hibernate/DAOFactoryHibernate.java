/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data.Provider.Hibernate;

import EDS.Data.DAO;
import EDS.Data.DAOFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author KH
 */
public class DAOFactoryHibernate extends DAOFactory {

    enum CONFIG_TYPE {
        FILE,
        ANNOTATION
    }
    
    enum ACCESS_TYPE {
        SESSIONFACTORY,
        ENTITYMANAGER
    }
    
    private CONFIG_TYPE config_type = CONFIG_TYPE.ANNOTATION;
    private ACCESS_TYPE access_type = ACCESS_TYPE.ENTITYMANAGER;
    
    @Override
    public DAO getDAO() {
        
        DAOHibernate dao;
        
        switch(access_type){
            case SESSIONFACTORY :   dao = new DAOHibernateSession();
                                    break; 
            case ENTITYMANAGER  :   dao = new DAOHibernateEntityManager();
                                    break;
            default             :   dao = new DAOHibernateEntityManager();
                                    break;
        }
        
        switch(config_type){
            case FILE       :   dao.setCfg(createPartialConfig());
                                break;
            case ANNOTATION :   dao.setCfg(createFullConfig());
                                break;
            default         :   dao.setCfg(createFullConfig()); //default config type
                                break;
        }
        
        return dao;
    }
    
    private Configuration createFullConfig(){
        Configuration cfg = createPartialConfig();
        cfg.setProperty("hibernate.current_session_context_class", "thread");
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/eds");
        cfg.setProperty("hibernate.connection.username","eds");
        cfg.setProperty("hibernate.connection.password","eds");
        cfg.setProperty("hibernate.c3p0.min_size","5");
        cfg.setProperty("hibernate.c3p0.max_size","20");
        cfg.setProperty("hibernate.c3p0.timeout","30");
        cfg.setProperty("hibernate.c3p0.max_statements","100");
        cfg.setProperty("hibernate.hbm2ddl.auto","update");
        cfg.setProperty("hibernate.archive.autodetection","class, hbm");
        cfg.setProperty("hibernate.show_sql","true");
        cfg.setProperty("hibernate.connection.autocommit","false");
        
        //cfg.setProperty("hibernate.session_factory_name","hi");
        
        return cfg;
    }
    
    private Configuration createPartialConfig(){
        Configuration cfg = new Configuration();
        return cfg;
    }
    
}
