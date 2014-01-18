/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EDS.Data;

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
     * @throws 
     */
    public abstract void insertSingleEntity(EnterpriseEntity entity);
}
