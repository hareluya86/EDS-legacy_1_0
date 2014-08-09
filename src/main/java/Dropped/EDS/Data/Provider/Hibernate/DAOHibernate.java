/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dropped.EDS.Data.Provider.Hibernate;

import Dropped.EDS.Data.DAO;
import Dropped.EDS.Data.DAOFactoryType;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author KH
 */

public abstract class DAOHibernate extends DAO {

    protected Configuration cfg;

    
    public Configuration getCfg() {
        return cfg;
    }

    public void setCfg(Configuration cfg) {
        this.cfg = cfg;
    }
    
    
}
