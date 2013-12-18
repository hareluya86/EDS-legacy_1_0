/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit.Test;

import EDS.BusinessUnit.EnterpriseRelationship;
import EDS.BusinessUnit.EnterpriseRelationshipId;
import EDS.Data.EnterpriseKey;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import org.joda.time.DateTime;

/**
 *
 * @author KH
 */
@Entity
@Table(name="TESTRELATIONSHIPA")
@DiscriminatorValue("TESTRELATIONSHIPA")
/*@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn()
})*/
public class TestRelationshipA extends EnterpriseRelationship{

    private String REL_ATTR;

    public String getREL_ATTR() {
        return REL_ATTR;
    }

    public void setREL_ATTR(String REL_ATTR) {
        this.REL_ATTR = REL_ATTR;
    }
    
    @Override
    public EnterpriseKey enterpriseKey() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void randInit() {
        DateTime today1 = new DateTime();
        DateTime tomorrow1 = today1.plusDays(1);
        java.sql.Date sqlDate1 = new java.sql.Date(today1.getMillis());
        java.sql.Date sqlDate2 = new java.sql.Date(tomorrow1.getMillis());
        int randInt = (int) (349204*Math.random());
        String var = "VARIABLE_";
        
        this.setREL_ATTR(var);
        
    }

    @Override
    public String tableName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String className() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<String, Object> exportAsMap() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String exportAsString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List exportAsList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
