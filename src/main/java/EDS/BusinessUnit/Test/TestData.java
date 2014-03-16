/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EDS.BusinessUnit.Test;

import EDS.BusinessUnit.EnterpriseData;
import EDS.Data.EnterpriseKey;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author KH
 */
@Entity
@Table(name="TESTDATA")
public class TestData extends EnterpriseData {

    private String NAME;

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
    
    
    @Override
    public Object key() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void randInit() {
        int i = 100*(int)Math.random();
        String name = "Test Data "+i;
        this.setNAME(name);
    }

    @Override
    public String tableName() {
        return "TESTDATA";
    }

    @Override
    public String className() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Object> exportAsMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String exportAsString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List exportAsList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
