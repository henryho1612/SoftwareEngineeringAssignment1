package vn.edu.rmit.common.databaseHandler;

import vn.edu.rmit.common.databaseHandlerInterface.CustomerDrugDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 11/24/13
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicCustomerDrugDAO implements CustomerDrugDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(int customerId, int drugId) {
        String insertCommand = "INSERT INTO CustomerDrug " +
                "(customerId, drugId) VALUES (?,?)";

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(insertCommand);

            ps.setInt(1, customerId);
            ps.setInt(2, drugId);

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

}
