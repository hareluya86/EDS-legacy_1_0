/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author KH
 */
@Embeddable
@DiscriminatorColumn(name="REL_TYPE")
public class EnterpriseRelationshipId implements Serializable{

    private EnterpriseUnit SOURCE;
    private EnterpriseUnit TARGET;
    private String REL_TYPE;
    //private java.sql.Date START_DATE;
    //private java.sql.Date END_DATE;
    //private int SEQUENCE;

    /*
    public Date getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(Date END_DATE) {
        this.END_DATE = END_DATE;
    }
    * 
    */

    @ManyToOne
    public EnterpriseUnit getSOURCE() {
        return SOURCE;
    }

    public void setSOURCE(EnterpriseUnit SOURCE) {
        this.SOURCE = SOURCE;
    } 
    
    @ManyToOne
    public EnterpriseUnit getTARGET() {
        return TARGET;
    }
    
    public void setTARGET(EnterpriseUnit TARGET) {
        this.TARGET = TARGET;
    }

    public String getREL_TYPE() {
        return REL_TYPE;
    }

    public void setREL_TYPE(String REL_TYPE) {
        this.REL_TYPE = REL_TYPE;
    }
    
}
