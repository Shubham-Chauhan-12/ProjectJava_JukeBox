package Project.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDb {

    public static Connection getConnection(){

        Connection connection = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jukebox_project";
            String user = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Connection Succeed");
            } else {
                System.out.println("Connection - Failed");
            }
        }

        catch (SQLException  | ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
}
