package vn.edu.rmit.common.databaseHandler;

import vn.edu.rmit.common.databaseHandlerInterface.CustomerDAO;
import vn.edu.rmit.common.model.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 11ß/24/13
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class BasicCustomerDAO implements CustomerDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //source: http://www.mkyong.com/spring/maven-spring-jdbc-example/
    public void insert(Customer customer)
    {
        String insertCommand = "INSERT INTO Customer " +
                "(name, dob, gender, address, dateOfVisit, icdCode, additionalIcdCode, dateOfDischarge, outcome, typeOfTreatment) VALUES (?,?,?,?,?,?,?,?,?,?)";

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(insertCommand);

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getDob());
            ps.setInt(3, customer.getGender());
            ps.setString(4, customer.getAddress());
            ps.setString(5, customer.getVisitedDay());
            ps.setString(6, customer.getiCDCode());
            ps.setString(7, customer.getAdditionalICDCode());
            ps.setString(8, customer.getDateOfDischarge());
            ps.setString(9, customer.getOutcome());
            ps.setString(10, customer.getTypeOfTreatment());

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

    @Override
    public int findMaxPrimaryKey() {
        int key = 0;
        String queryCommand = "SELECT MAX(idCustomer) as idCustomer FROM Customer";

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(queryCommand);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                key = rs.getInt("idCustomer");
            }
            rs.close();
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
        return key;
    }
}
