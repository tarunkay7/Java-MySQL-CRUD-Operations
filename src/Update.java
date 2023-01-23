import java.sql.*;

public class Update {

    public static void main(String[] args)
    {
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "tarun", "taruntanush160104")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();
            String sql = "update emp set designation ='Cloud Architect' where id=3";
            int res = stmt.executeUpdate(sql);
            if(res>0) {
                System.out.println("Data updated successfully");
            }



        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("There has been an Error");
        }
    }
}
