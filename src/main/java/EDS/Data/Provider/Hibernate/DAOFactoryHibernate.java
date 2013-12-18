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
    
    @Override
    public DAO getDAO() {
        Configuration cfg = new Configuration();
        cfg.setProperty("hibernate.current_session_context_class", "thread");
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/eds");
        cfg.setProperty("hibernate.connection.username","eds");
        cfg.setProperty("hibernate.connection.password","eds");
        cfg.setProperty("hibernate.c3p0.min_size","5");
        cfg.setProperty("hibernate.c3p0.max_size","20");
        cfg.setProperty("hibernate.c3p0.timeout","1800");
        cfg.setProperty("hibernate.c3p0.max_statements","100");
        cfg.setProperty("hibernate.hbm2ddl.auto","update");
        cfg.setProperty("hibernate.archive.autodetection","class, hbm");
        cfg.setProperty("hibernate.show_sql","true");
        cfg.setProperty("hibernate.connection.autocommit","false");
        //cfg.setProperty("","");
        
        DAOHibernate dao = new DAOHibernate();
        dao.setCfg(cfg);
        dao.setConfig_type(CONFIG_TYPE.FILE);//Default configuration and mapping type
        
        return dao;
    }
    
}
