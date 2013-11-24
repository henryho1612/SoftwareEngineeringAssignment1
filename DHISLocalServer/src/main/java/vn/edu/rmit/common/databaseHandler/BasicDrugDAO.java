package vn.edu.rmit.common.databaseHandler;

import vn.edu.rmit.common.databaseHandlerInterface.DrugDAO;
import vn.edu.rmit.common.model.Drug;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 11/24/13
 * Time: 6:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicDrugDAO implements DrugDAO{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //source: http://www.mkyong.com/spring/maven-spring-jdbc-example/
    public void insert(Drug drug)
    {
        String insertCommand = "INSERT INTO Drug " +
                "(name, quantity, length) VALUES (?,?,?)";

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(insertCommand);

            ps.setString(1, drug.getName());
            ps.setInt(2, drug.getQuantity());
            ps.setInt(3, drug.getLength());

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
        String queryCommand = "SELECT MAX(idDrug) as idDrug FROM Drug";

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(queryCommand);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                key = rs.getInt("idDrug");
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
