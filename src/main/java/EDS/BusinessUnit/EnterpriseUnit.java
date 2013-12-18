/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.BusinessUnit;

import EDS.Data.EnterpriseEntity;
import EDS.Data.EnterpriseKey;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author KH
 */
@Entity
@Table(name="ENTERPRISEUNIT")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="UNIT_TYPE")
@TableGenerator(name="ENTERPRISEUNIT_SEQ",initialValue=1,allocationSize=10,table="SEQUENCE")
public abstract class EnterpriseUnit implements EnterpriseEntity, EnterpriseKey{
    
    private long OBJECTID;
    //private String OBJECT_TYPE;
    /*
     * Start and End dates should not be primary keys
     * - Only 1 instance of an entity should exist anytime
     * - If both start and end dates are PK, this means >1 record can be created
     * for 1 object id.
     */
    /*@Id*/ private java.sql.Date START_DATE;
    /*@Id*/ private java.sql.Date END_DATE;
    
    private java.sql.Date DATE_CREATED;
    private String CREATED__BY;
    
    private java.sql.Date DATE_CHANGED;
    private String CHANGED__BY;
    
    private String SEARCH_TERM;
    private String SHORT_NAME;

    private List<EnterpriseRelationship> toRelationships = new ArrayList<EnterpriseRelationship>();
    
    public String getCHANGED__BY() {
        return CHANGED__BY;
    }

    public void setCHANGED__BY(String CHANGED__BY) {
        this.CHANGED__BY = CHANGED__BY;
    }

    public String getCREATED__BY() {
        return CREATED__BY;
    }

    public void setCREATED__BY(String CREATED__BY) {
        this.CREATED__BY = CREATED__BY;
    }

    public Date getDATE_CHANGED() {
        return DATE_CHANGED;
    }

    public void setDATE_CHANGED(Date DATE_CHANGED) {
        this.DATE_CHANGED = DATE_CHANGED;
    }

    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }
 
    @Id @GeneratedValue(generator="ENTERPRISEUNIT_SEQ",strategy=GenerationType.TABLE) 
    public long getOBJECTID() {
        return OBJECTID;
    }

    public void setOBJECTID(long OBJECTID) {
        this.OBJECTID = OBJECTID;
    }

    @OneToMany(fetch=FetchType.LAZY,mappedBy="pk.SOURCE")
    public List<EnterpriseRelationship> getToRelationships(){
        return this.toRelationships;
    }
    
    public void setToRelationships(List<EnterpriseRelationship> toRelationships){
        this.toRelationships = toRelationships;
    }

    public Date getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(Date END_DATE) {
        this.END_DATE = END_DATE;
    }

    public String getSEARCH_TERM() {
        return SEARCH_TERM;
    }

    public void setSEARCH_TERM(String SEARCH_TERM) {
        this.SEARCH_TERM = SEARCH_TERM;
    }

    public String getSHORT_NAME() {
        return SHORT_NAME;
    }

    public void setSHORT_NAME(String SHORT_NAME) {
        this.SHORT_NAME = SHORT_NAME;
    }

    public Date getSTART_DATE() {
        return START_DATE;
    }

    public void setSTART_DATE(Date START_DATE) {
        this.START_DATE = START_DATE;
    }
    
    public void addRelationship(EnterpriseRelationship rel){
        this.toRelationships.add(rel);
    }
}