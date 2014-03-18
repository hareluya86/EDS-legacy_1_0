/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data;

import EDS.Data.Provider.Eclipselink.DAOFactoryEclipselink;
import EDS.Data.Provider.Hibernate.DAOFactoryHibernate;
import javax.inject.Inject;

/**
 *
 * @author KH
 */
public abstract class DAOFactory {
    
    /*
     * To decide which JPA Provider to user
     */
    public enum JPAType {
        ECLIPSELINK,
        HIBERNATE
    }
    
    private static JPAType DEFAULT_PROVIDER = JPAType.ECLIPSELINK;
    
    /*@Inject @DAOType(DAOType.Impl.ECLIPSELINK)
    DAO DAOEclipseLink;*/
    
    public static DAOFactory getDAOFactory(JPAType type){
        
        switch(type){
            case ECLIPSELINK : return new DAOFactoryEclipselink();
            case HIBERNATE : return new DAOFactoryHibernate();
            default :   throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    /*
     * This is where all the configurations gets initialized and passed on to the DAO object
     */
    public abstract DAO getDAO();
}
