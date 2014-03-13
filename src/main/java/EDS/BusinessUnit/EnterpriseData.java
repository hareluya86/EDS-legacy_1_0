/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EDS.BusinessUnit;

import EDS.Data.EnterpriseEntity;
import EDS.Data.EnterpriseKey;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 *
 * @author vincent.a.lee
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class EnterpriseData implements EnterpriseEntity, EnterpriseKey{
    
    protected EnterpriseUnit BELONG_TO_OBJECT;
    protected String DATA_TYPE;
    
    /*@Id*/ protected java.sql.Date START_DATE;
    /*@Id*/ protected java.sql.Date END_DATE;
    
    protected long SEQNUM;
    protected boolean DATA_LOCK;
    
    protected java.sql.Date CREATED_ON;
    protected String CREATED_BY;
    
    protected java.sql.Date CHANGED_ON;
    protected String CHANGED_BY;

    @Id @ManyToOne
    public EnterpriseUnit getBELONG_TO_OBJECT() {
        return BELONG_TO_OBJECT;
    }

    public void setBELONG_TO_OBJECT(EnterpriseUnit BELONG_TO_OBJECT) {
        this.BELONG_TO_OBJECT = BELONG_TO_OBJECT;
    }

    public String getDATA_TYPE() {
        return DATA_TYPE;
    }

    public void setDATA_TYPE(String DATA_TYPE) {
        this.DATA_TYPE = DATA_TYPE;
    }

    public Date getSTART_DATE() {
        return START_DATE;
    }

    public void setSTART_DATE(Date START_DATE) {
        this.START_DATE = START_DATE;
    }

    public Date getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(Date END_DATE) {
        this.END_DATE = END_DATE;
    }

    public long getSEQNUM() {
        return SEQNUM;
    }

    public void setSEQNUM(long SEQNUM) {
        this.SEQNUM = SEQNUM;
    }

    public boolean isDATA_LOCK() {
        return DATA_LOCK;
    }

    public void setDATA_LOCK(boolean DATA_LOCK) {
        this.DATA_LOCK = DATA_LOCK;
    }

    public Date getCREATED_ON() {
        return CREATED_ON;
    }

    public void setCREATED_ON(Date CREATED_ON) {
        this.CREATED_ON = CREATED_ON;
    }

    public String getCREATED_BY() {
        return CREATED_BY;
    }

    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    public Date getCHANGED_ON() {
        return CHANGED_ON;
    }

    public void setCHANGED_ON(Date CHANGED_ON) {
        this.CHANGED_ON = CHANGED_ON;
    }

    public String getCHANGED_BY() {
        return CHANGED_BY;
    }

    public void setCHANGED_BY(String CHANGED_BY) {
        this.CHANGED_BY = CHANGED_BY;
    }
    
    
}
