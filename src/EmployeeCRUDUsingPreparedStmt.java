import java.sql. *;
public class EmployeeCRUDUsingPreparedStmt {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        EmployeeCRUDUsingPreparedStmt e = new EmployeeCRUDUsingPreparedStmt();
        e.Insert();
        e.Extract();
        e.Delete();
        e.Update();
    }

    public void Insert() throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "tarun", "taruntanush160104")) {
            String sql = "insert into emp values(?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, 7);
            st.setString(2, "Volley");

            int res = st.executeUpdate();
            if (res > 0) System.out.println("Data inserted successfully");
            else {
                System.out.println("Data not inserted");
            }
        } catch (SQLException e) {
            System.out.println("There has been an Error");
        }
    }

    public void Extract() throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "tarun", "taruntanush160104")) {
            PreparedStatement st = con.prepareStatement("select * from emp");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("There has been an Error");
        }
    }
    public void Update()
    {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "tarun", "taruntanush160104")) {
            String sql = "update emp set designation ='?' where id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,3);
            int res = st.executeUpdate();
            if(res>0) {
                System.out.println("Data updated successfully");
            }
        } catch (SQLException e) {
            System.out.println("There has been an Error");
        }
    }

    public void Delete()
    {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "tarun", "taruntanush160104")) {
            String sql = "delete from emp where id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,7);
            int res = st.executeUpdate();
            if(res>0) {
                System.out.println("Data deleted successfully");
            }
        } catch (SQLException e) {
            System.out.println("There has been an Error");
        }
    }
}
