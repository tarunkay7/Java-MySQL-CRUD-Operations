
import java.sql.*;

public class EmployeeCRUD {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        EmployeeCRUD m = new EmployeeCRUD();
        m.Insert();
        m.Extract();
        m.Delete();
        m.Update();


    }

    public void Extract() throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "tarun", "taruntanush160104")) {
            Statement stmt = con.createStatement();
            String sql = "select * from emp";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("There has been an Error");
        }
    }

    public void Insert() throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "tarun", "taruntanush160104")) {

            Statement stmt = con.createStatement();
            String sql2 = "insert into emp values(6,'Tina','IAS')";
            int res = stmt.executeUpdate(sql2);
            if (res > 0) {
                System.out.println("Data inserted successfully");
            } else {
                System.out.println("Data not inserted");
            }

        } catch (SQLException e) {
            System.out.println("There has been an Error");
        }
    }

    public void Delete() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "tarun", "taruntanush160104")) {

            Statement stmt = con.createStatement();
            String sql = "delete from emp where id=6";
            int res = stmt.executeUpdate(sql);
            if (res > 0) {
                System.out.println("Data deleted successfully");
            } else {
                System.out.println("Data not deleted");
            }

        } catch (SQLException e) {
            System.out.println("There has been an Error");
        }
    }

    public void Update() throws SQLException, ClassNotFoundException {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "tarun", "taruntanush160104")) {

            Statement stmt = con.createStatement();
            String sql = "update emp set designation ='Cloud Architect' where id=2";
            int res = stmt.executeUpdate(sql);
            if (res > 0) {
                System.out.println("Data updated successfully");
            }
        }
    }
}