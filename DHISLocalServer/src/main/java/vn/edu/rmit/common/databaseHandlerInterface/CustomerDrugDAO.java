package vn.edu.rmit.common.databaseHandlerInterface;

import vn.edu.rmit.common.model.Customer;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 11/24/13
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerDrugDAO {

    public void insert(int customerId, int drugId);

}
