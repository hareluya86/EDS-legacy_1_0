/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EDS.BusinessUnit;

import Dropped.EDS.Data.EnterpriseEntity;
import Dropped.EDS.Data.EnterpriseKey;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 * An descriptive entity of an EnterpriseUnit
 * <p>
 * EnterpriseData are objects which carries attributes of an EnterpriseUnit. Each
 * ED object is linked to only 1 EU object.
 * 
 * @author vincent.a.lee
 */
@Entity
@EntityListeners(DateCreatedListener.class)
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class EnterpriseData implements EnterpriseEntity, EnterpriseKey{
    
    protected EnterpriseUnit BELONG_TO_OBJECT;
    protected String DATA_TYPE;
    
    /*@Id*/ protected java.sql.Date START_DATE;
    /*@Id*/ protected java.sql.Date END_DATE;
    
    protected long SEQNUM;
    protected boolean DATA_LOCK;
    
    protected java.sql.Date DATE_CREATED;
    protected String CREATED_BY;
    
    protected java.sql.Date DATE_CHANGED;
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

    @Override
    public Date getDATE_CREATED() {
        return DATE_CREATED;
    }

    @Override
    public void setDATE_CREATED(Date DATE_CREATED) {
        this.DATE_CREATED = DATE_CREATED;
    }

    @Override
    public String getCREATED_BY() {
        return CREATED_BY;
    }

    @Override
    public void setCREATED_BY(String CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    @Override
    public Date getDATE_CHANGED() {
        return DATE_CHANGED;
    }

    @Override
    public void setDATE_CHANGED(Date DATE_CHANGED) {
        this.DATE_CHANGED = DATE_CHANGED;
    }

    @Override
    public String getCHANGED_BY() {
        return CHANGED_BY;
    }

    @Override
    public void setCHANGED_BY(String CHANGED_BY) {
        this.CHANGED_BY = CHANGED_BY;
    }

    @Override
    public Map<String, Object> exportAsMap(){
        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("BELONG_TO_OBJECT", BELONG_TO_OBJECT);
        map.put("DATA_TYPE", DATA_TYPE);
        map.put("START_DATE",START_DATE);
        map.put("END_DATE",END_DATE);
        map.put("DATE_CREATED",DATE_CREATED);
        map.put("CREATED_BY",CREATED_BY);
        map.put("DATE_CHANGED",DATE_CHANGED);
        map.put("CHANGED_BY",CHANGED_BY);
        map.put("SEQNUM", SEQNUM);
        map.put("DATA_LOCK",DATA_LOCK);
        
        return map;
    }
    
    
    
}
