package vn.edu.rmit.common.databaseHandler;

import vn.edu.rmit.common.databaseHandlerInterface.ServiceDAO;
import vn.edu.rmit.common.model.Drug;
import vn.edu.rmit.common.model.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 11/24/13
 * Time: 7:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicServiceDAO implements ServiceDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //source: http://www.mkyong.com/spring/maven-spring-jdbc-example/
    public void insert(Service service)
    {
        String insertCommand = "INSERT INTO Service " +
                "(labTest, imageDiagnosis, surgery, mirrorSurgery) VALUES (?,?,?,?)";

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(insertCommand);

            ps.setString(1, service.getLabTest());
            ps.setString(2, service.getImageDiagnosis());
            ps.setString(3, service.getSurgery());
            ps.setString(4, service.getMirrorSurgery());

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
        String queryCommand = "SELECT MAX(idService) as idService FROM Service";

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(queryCommand);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                key = rs.getInt("idService");
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
