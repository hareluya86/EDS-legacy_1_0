
import EDS.Data.DAOFactory;
import EDS.Data.DAOFactoryType;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KH
 */
public class TestDependency {
    @Inject @DAOFactoryType("HIBERNATE")
    private DAOFactory daoFactoryHibernate;
    
    public DAOFactory getDaoFactoryHibernate() {
        return daoFactoryHibernate;
    }
    
    public void setDaoFactoryHibernate(DAOFactory daoFactoryHibernate) {
        this.daoFactoryHibernate = daoFactoryHibernate;
    }
    
    public static void main(String[] args){
        TestDependency td = new TestDependency();
    }
}
