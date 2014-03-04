/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data;

import java.util.Collection;

/**
 *
 * @author KH
 */
public abstract class DAO {
    
    /**
     * Initializes the DAO with the persistence provider.
     * <p>
     * This method must be called before any other methods, or else the 
     * provider-specific implementations will throw runtime errors. 
     * Alternatively, the provider-specific implementations can call this in 
     * all their methods to avoid throwing unnecessary runtime errors.
     */
    public abstract void init();
    
    /**
     * Starts a DAO transaction.
     * <p>
     * This method must be called before any CUD methods - Insert, Update and 
     * Deletions, or else the provider-specific implementations will throw 
     * runtime errors. Alternatively, the provider-specific implementations can 
     * call this in all CUD methods, but it is not advisable because the client 
     * may decide to insert multiple CUD operations within 1 transaction.
     * 
     * @throws DBConnectionException    if the DB connection cannot be opened or 
     *                                  is lost halfway
     */
    public abstract void start()throws DBConnectionException;
    
    /**
     * Commits a DAO transaction.
     * <p>
     * This method must be called after any CUD methods - Insert, Update and 
     * Deletions, or else the changes would not be flushed to the database. 
     * Alternatively, provider specific implementations can call this in all CUD
     * methods, but it is not advisable because the client may decide to insert 
     * multiple CUD operations within 1 transaction. 
     * 
     * @throws DBConnectionException    if the DB connection cannot be opened or 
     *                                  is lost halfway
     *                               
     */
    public abstract void commit()throws DBConnectionException;
    
    /**
     * Rolls back a DAO transaction.
     * <p>
     * This method must be called if commit hits any error to roll back the 
     * entire transaction that was meant to be 
     * <p>
     * Should I allow client to rollback DAO transactions?
     * NO:      The commit() method should auto-rollback any inconsistent 
     *          transactions. All operation within a start() and commit() should 
     *          be automatically rolled back if the commit fails without client 
     *          having to worry about inconsistent transactions. To make rollback 
     *          a mandatory operation result in additional, cumbersome coding 
     *          and an imminent disaster. Imagine this scenario:
     * 1) DAO1 starts transaction
     * 2) DAO2 starts transaction
     * 3) DAO1 modifies DB1
     * 4) DAO2 modifies DB2
     * 
     * ..to be continued...
     */
    /**
     * Releases any resources held by the DAO.
     * <p>
     * This method act as a destructor, it will close any database connection 
     * and release any concurrency locks held by this instance of DAO.
     */
    public abstract void close();
    
    /**
     * Inserts 1 EnterpriseEntity object
     * <p>
     * Takes in the EnterpriseEntity object and inserts into the database
     * 
     * @param entity    The EnterpriseEntity object to be inserted
     * @throws javax.persistence.TransactionRequiredException if there is no 
     *          transactions started.
     */
    public abstract void insertEntity(EnterpriseEntity entity);
    
    /**
     * Inserts many EnterpriseEntity object
     * <p>
     * Takes in a collection of EnterpriseEntity object and inserts into the 
     * database. Note that this method should not commit at all but flushes only 
     * once.
     * 
     * @param entities  The collection of EnterpriseEntity object to be inserted
     * @throws javax.persistence.TransactionRequiredException if there is no 
     *          transactions started.
     */
    public abstract void insertEntities(Collection<EnterpriseEntity> entities);
    
    /**
     * Flushes any updates of an EnterpriseEntity object
     * <p>
     * Takes in an EnterpriseEntity object and flushes any updates to the 
     * datastore of the provider. 
     * 
     * @param entity    The EnterpriseEntity object to be updated.
     * @throws javax.persistence.TransactionRequiredException if there is no 
     *          transactions started.
     */
    public abstract void updateEntity(EnterpriseEntity entity);
    
    /**
     * Flushes any updates of an many EnterpriseEntity objects
     * <p>
     * Takes in a collection of EnterpriseEntity object and flushes any updates 
     * to the datastore of the provider. Note that this method should not commit 
     * at all but flushes only once.
     * 
     * @param entities    The collection of EnterpriseEntity object to be updated.
     * @throws javax.persistence.TransactionRequiredException if there is no 
     *          transactions started.
     */
    public abstract void updateEntities(Collection<EnterpriseEntity> entities);
    
    /**
     * Deletes an EnterpriseEntity object
     * <p>
     * Takes in an EnterpriseEntity object and removes it from the database.
     * 
     * @param entity    The EnterpriseEntity object to be removed.
     * @throws javax.persistence.TransactionRequiredException if there is no 
     *          transactions started.
     */
    public abstract void deleteEntity(EnterpriseEntity entity);
    
    /**
     * Deletes a collection of EnterpriseEntity objects
     * <p>
     * Takes in a collection of EnterpriseEntity object and removes it from the 
     * database. Note that this method should not commit at all but flushes only 
     * once.
     * 
     * @param entities    The collection of EnterpriseEntity object to be removed.
     * @throws javax.persistence.TransactionRequiredException if there is no 
     *          transactions started.
     */
    public abstract void deleteEntities(Collection<EnterpriseEntity> entities);
}
